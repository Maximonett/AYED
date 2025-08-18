package parcial12;

import java.util.*;
import ejercicio1.*;
import adjList.*;


public class Parcial {
	public int resolver(Graph<Ciudad>ciudades,String origen,String destino,int maxControles) {
		int maxTiempo=0;
		if(!ciudades.isEmpty()) {
			Vertex<Ciudad> vOrigen=null;
			Vertex<Ciudad> vDestino=null;
			for (Vertex<Ciudad> v: ciudades.getVertices()){
				if(v.getData().getCiudad().equals(origen)) {
					vOrigen=v;
				}
				if(v.getData().getCiudad().equals(destino)) {
					vDestino=v;
				}
			}
			if (vOrigen!=null&& vDestino!=null) {
				maxTiempo=this.dfs(ciudades,vOrigen,vDestino,new boolean[ciudades.getSize()]
						,vOrigen.getData().getTiempo(),Integer.MIN_VALUE,maxControles);		
			}
		}
		return maxTiempo;
	}
	
	private int dfs(Graph<Ciudad>ciudades, Vertex<Ciudad>origen,Vertex<Ciudad>destino
			,boolean[]marcas,int total,int maxTiempo,int maxControles) {
		marcas[origen.getPosition()]=true;
		if (origen==destino) {
			if (total>maxTiempo) {
				maxTiempo=total;
			}
		}else {
			for (Edge<Ciudad> ady:ciudades.getEdges(origen)) {
				Vertex<Ciudad> aux=ady.getTarget();
				int peso=ady.getWeight();
				int pos=aux.getPosition();
				if(!marcas[pos] && peso<=maxControles) {
					maxTiempo=this.dfs(ciudades, aux, destino, marcas, total+aux.getData().getTiempo(), maxTiempo, maxControles);
				}
			}
		}
		marcas[origen.getPosition()]=false;
		return maxTiempo;
	}
	
    public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", 3));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", 2));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", 2));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", 3));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", 1));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", 2));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", 3));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", 1));
        
        grafo.connect(v1, v2, 2);
        grafo.connect(v2, v1, 2);
        grafo.connect(v2, v3, 2);
        grafo.connect(v3, v2, 2);
        grafo.connect(v3, v4, 2);
        grafo.connect(v4, v3, 2);
        grafo.connect(v1, v5, 2);
        grafo.connect(v5, v1, 2);
        grafo.connect(v5, v6, 2);
        grafo.connect(v6, v5, 2);
        grafo.connect(v6, v7, 2);
        grafo.connect(v7, v6, 2);
        grafo.connect(v7, v3, 3);
        grafo.connect(v3, v7, 3);
        grafo.connect(v7, v8, 2);
        grafo.connect(v8, v7, 2);
        grafo.connect(v8, v4, 2);
        grafo.connect(v4, v8, 2);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, "La Plata", "Suipacha", 2));
        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen", 2));
    }
	
	
}
