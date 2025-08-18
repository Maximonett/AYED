package parcial9;

import java.util.*;
import adjList.*;
import ejercicio1.*;


public class Parcial {
	//El grafo sera de Strings y no de objeto Ciudad, porque dice que solo se conoce nombre
	//, a pesar del grafico.
	public List<String> resolver(Graph<String> ciudades,String origen,String destino,List<String>pasandoPor){
		List<String> camino= new LinkedList<String>();
		if(!ciudades.isEmpty()) {
			Vertices v=this.buscarVertices(ciudades,origen,destino);
			if(v!=null) {
				this.dfs(ciudades,v.getOrigen(),v.getDestino(),camino,pasandoPor,new boolean[ciudades.getSize()]);
			}
		}
		return camino;	
	}
	
	private Vertices buscarVertices(Graph<String>ciudades,String origen,String destino) {
		Vertex<String> v1=ciudades.search(origen);
		Vertex<String> v2=ciudades.search(destino);
		if (v1!=null && v2!=null) return new Vertices(v1,v2);
		else return null;
	}
	
	private boolean dfs(Graph<String> ciudades,Vertex<String>origen,Vertex<String> destino
			,List<String>camino,List<String>pasandoPor,boolean[]marcas){
		
		marcas[origen.getPosition()]=true; //Inicio marcando el primer vertice
		camino.add(origen.getData()); // agrego el nombre del 1er vertice al camino
		boolean encontre=false; //inicializo el flag encontre en false
		
		if (origen==destino) {
			if (camino.containsAll(pasandoPor)) {
				return true;
			}
		}else {
			for (Edge<String> ady: ciudades.getEdges(origen)) { //calles(aristas) que salen desde el origen 
				Vertex<String> aux= ady.getTarget();  //de la calle ady obtenemos el destino a donde va 
				int pos=aux.getPosition(); //guardamos la posicion del destino de es calle
				if(!marcas[pos]) { // si no ha sido visitada la ciudad seguimos 
					encontre=dfs(ciudades,aux,destino,camino,pasandoPor,marcas); //llamamos desde la ciudad nueva
					if(encontre) break; // si encontro sale
				}
			}
		}
		if(!encontre) {
			camino.remove(camino.size()-1);
			marcas[origen.getPosition()]=false;
		}
		return encontre;
	}
	
    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<String> v1 = grafo.createVertex("Suipacha");
        Vertex<String> v2 = grafo.createVertex("Carlos Keen");
        Vertex<String> v3 = grafo.createVertex("Moreno");
        Vertex<String> v4 = grafo.createVertex("Quilmes");
        Vertex<String> v5 = grafo.createVertex("Navarro");
        Vertex<String> v6 = grafo.createVertex("Cañuelas");
        Vertex<String> v7 = grafo.createVertex("Abasto");
        Vertex<String> v8 = grafo.createVertex("La Plata");
        
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
        
        List<String> pasandoPor = new LinkedList<String>();
        
        pasandoPor.add("Quilmes");
        //pasandoPor.add("Abasto");
        pasandoPor.add("Carlos Keen");
        
        System.out.println(p.resolver(grafo, "La Plata", "Suipacha", pasandoPor));
        
        List<String> pasandoPor2 = new LinkedList<String>();
        
        pasandoPor.add("Navarro");
        //pasandoPor.add("Abasto");
        pasandoPor.add("Abasto");
        
        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen", pasandoPor2));
        
    }
}
