package parcial_14_06_25;

import java.util.*;
import ejercicio1.*;
import adjList.*;



public class ParcialGrafo {
	public List<String> rutaOptimaDistribucion(Graph<String> reino,String castillo,String aldea,int maxPociones){
		List<String>mejorRuta=new LinkedList<String>();
		if(!reino.isEmpty()) {
			Vertex vOrigen=reino.search(castillo);
			Vertex vDestino=reino.search(aldea);
			if(vOrigen!=null && vDestino!=null) {
				boolean [] visitados=new boolean[reino.getSize()];
				List<String> actual=new LinkedList<String>();
				this.dfs(reino,vOrigen,vDestino,maxPociones,0,visitados,actual,mejorRuta);
			}
		}	
		return mejorRuta;
	}
	/* IGUAL METODO PERO IMPLEMENTADO DE OTRA FORMA
	public List<String> rutaOptimaDistribucion(Graph<String> reino,String castillo,String aldea,int maxPociones){
		List<String>mejorRuta=new LinkedList<String>();
		if(!reino.isEmpty()) {
			Vertex origen=null;
			Vertex destino=null;
			for (Vertex<String> aux:reino.getVertices()) {
				if (aux.getData().equals(castillo)) {
					origen=aux;
				}
				if (aux.getData().equals(aldea)) {
					destino=aux;
				}
			}
			if(origen!=null && destino!=null) {
				boolean [] visitados=new boolean[reino.getSize()];
				List<String> actual=new LinkedList<String>();
				this.dfs(reino,origen,destino,maxPociones,0,visitados,actual,mejorRuta);
			}
		}	
		return mejorRuta;
	}
	*/
	
	
	
	
	private void dfs(Graph<String> reino,Vertex<String> actual,Vertex<String> destino,int maxPociones
			,int pocionesUsadas,boolean[]visitados,List<String> caminoActual,List<String>mejorRuta) {
		
		visitados[actual.getPosition()]=true;
		caminoActual.add(actual.getData());
		
		if(actual==destino && pocionesUsadas<=maxPociones) {
			//Si es el mas largo de los caminos
			if(caminoActual.size()> mejorRuta.size()) {
				mejorRuta.clear();
				mejorRuta.addAll(new LinkedList<String>(caminoActual));
			}	
		}else {
			for(Edge<String>ady:reino.getEdges(actual)) {
				Vertex<String> sig=ady.getTarget();
				int peso=ady.getWeight();
				if(!visitados[sig.getPosition()] && pocionesUsadas+peso<=maxPociones) {
					this.dfs(reino, sig, destino, maxPociones, pocionesUsadas+peso, visitados, caminoActual, mejorRuta);
				}
			}
		}
		visitados[actual.getPosition()]=false;
		caminoActual.remove(caminoActual.size()-1);
	}
	
	public static void main(String args[]) {
		
		Graph<String> grafo=new AdjListGraph<>();
		
		Vertex<String> v1=grafo.createVertex("Castillo");
		Vertex<String> v2=grafo.createVertex("Cueva Encantada");
		Vertex<String> v3=grafo.createVertex("Desfiladero de los Vientos");
		Vertex<String> v4=grafo.createVertex("Aldea del Lago");
		Vertex<String> v5=grafo.createVertex("Cruce norte");
		Vertex<String> v6=grafo.createVertex("Bosque Sombrio");
		Vertex<String> v7=grafo.createVertex("Campamento de Druidas");
		Vertex<String> v8=grafo.createVertex("Aldea");
		
		grafo.connect(v1, v5,10);
		grafo.connect(v1, v6,20);
		grafo.connect(v1, v4,15);
		grafo.connect(v1, v2,8);
		grafo.connect(v5, v6,5);
		grafo.connect(v6, v7,3);
		grafo.connect(v6, v4,5);
		grafo.connect(v4, v2,50);
		grafo.connect(v4, v3,30);
		grafo.connect(v2, v3,45);
		grafo.connect(v7, v3,7);
		grafo.connect(v3, v8,15);
		grafo.connect(v7, v8,35);
		
		
		ParcialGrafo p=new ParcialGrafo();
		
		System.out.println(p.rutaOptimaDistribucion(grafo, "Castillo", "Aldea", 70));
		
	}
	
}
