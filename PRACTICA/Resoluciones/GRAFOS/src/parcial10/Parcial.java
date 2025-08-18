package parcial10;

import java.util.*;
import ejercicio1.*;
import adjList.*;


public class Parcial {
	public List<String> resolver(Graph<Ciudad> ciudades,String origen,String destino){
		List<String> camino=new LinkedList<String>();
		if(!ciudades.isEmpty()) {
			Vertex<Ciudad> vOrigen=null;
			Vertex<Ciudad> vDestino=null;
			for (Vertex<Ciudad> aux:ciudades.getVertices()) {
				if(aux.getData().getNombre().equals(origen)) {
					vOrigen=aux;
				}
				if(aux.getData().getNombre().equals(destino)) {
					vDestino=aux;
				}
			}
			if(vOrigen!=null && vDestino!=null) {
				this.dfs(ciudades,vOrigen,vDestino,camino,new boolean[ciudades.getSize()]);
			} 
		}
		
		return camino;
	}
	
	
	private boolean dfs(Graph<Ciudad> ciudades,Vertex<Ciudad> origen,Vertex<Ciudad> destino
			,List<String>camino,boolean[]marcas) {
		
		marcas[origen.getPosition()]=true;
		camino.add(origen.getData().getNombre());
		boolean encontre=false;
		
		if(origen==destino) {
			return true;
		}else {
			for (Edge<Ciudad> ady:ciudades.getEdges(origen)) {
				Vertex<Ciudad> aux=ady.getTarget();
				int pos=aux.getPosition();
				if(!marcas[pos]&& !aux.getData().getFase().equals("Fase1")) {
					encontre=this.dfs(ciudades, aux, destino, camino, marcas);
					if(encontre) break;
				}
			}
		}
		if(!encontre) camino.remove(camino.size()-1);
		marcas[origen.getPosition()]=false;
		return encontre;
		
	}
    public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", "Fase 5"));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", "Fase 3"));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", "Fase 1"));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", "Fase 1"));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", "Fase 4"));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", "Fase 3"));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", "Fase 2"));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", "Fase 2"));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen"));
    }	
}	
