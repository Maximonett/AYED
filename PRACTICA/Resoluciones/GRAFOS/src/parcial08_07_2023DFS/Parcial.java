package parcial08_07_2023DFS;

import java.util.*;
import adjList.*;
import ejercicio1.*;


public class Parcial {
	public List<String> tactica(Graph<String> jugadores,String arquero,String delantero,double potencia){
		List<String> camino=new LinkedList<>();
		if(!jugadores.isEmpty()) {
			Vertex<String> origen=null;
			Vertex<String> destino=null;
			for (Vertex<String> aux:jugadores.getVertices()) {
				if(aux.getData().equals(arquero)) {
					origen=aux;         
				}
				if(aux.getData().equals(delantero)) {
					destino=aux;
				}
			}
			if(origen!=null && destino!=null) {
				this.dfs(jugadores,origen,destino,camino,new boolean[jugadores.getSize()],0,0,potencia);
			}
		}
		return camino;
	}
	
	private boolean dfs(Graph<String> jugadores,Vertex<String> origen,Vertex<String> destino
			,List<String>camino,boolean[]marcas,int suma,int cant, double potencia) {
		
		marcas[origen.getPosition()]=true;
		camino.add(origen.getData());
		
		if (origen==destino) {
			double promedio=(cant==0) ? 0:(double) suma/cant;
			if(promedio>=potencia)
				return true;
		}else {
			for (Edge<String> ady:jugadores.getEdges(origen)) {
				
				Vertex<String> aux=ady.getTarget();				
				int pos=aux.getPosition();
								
				if(!marcas[pos]) {
					int nuevaSuma=suma+ady.getWeight();
					int nuevaCant=cant+1;
					
					if(this.dfs(jugadores, aux, destino, camino, marcas, nuevaSuma, nuevaCant, potencia)) {
						return true;
					}
				}
			}
		}
		camino.remove(camino.size()-1);
		marcas[origen.getPosition()]=false;
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> jugadores=new AdjListGraph<>();
		
		Vertex<String> arq=jugadores.createVertex("ARQ");
		Vertex<String> def1=jugadores.createVertex("DEF1");
		Vertex<String> def2=jugadores.createVertex("DEF2");
		Vertex<String> mc1=jugadores.createVertex("MC1");
		Vertex<String> mc3=jugadores.createVertex("MC3");
		Vertex<String> del2=jugadores.createVertex("DEL2");
		
		
		jugadores.connect(arq, def1,5);
		jugadores.connect(def1, mc1,5);
		jugadores.connect(mc1, del2,14);
		jugadores.connect(def2, mc3,1);
		jugadores.connect(arq, def2,8);
		jugadores.connect(mc3, del2,18);
		
		Parcial p=new Parcial();
		
		System.out.println(p.tactica(jugadores, "ARQ", "DEL2", 8));
		
	}

}
