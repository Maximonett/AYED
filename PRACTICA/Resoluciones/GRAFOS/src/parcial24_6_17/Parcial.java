package parcial24_6_17;

import Ejercicio3.*;
import ejercicio1.*;
import java.util.*;
import adjList.*;


public class Parcial {
	public List<String> caminoDistanciaMaximo(Graph<String> ciudades,String origen
			,String destino,int distanciaMaxima){
		List<String> camino=new LinkedList<String>();
		if(!ciudades.isEmpty()) {
			Vertex<String> v1=null;
			Vertex<String> v2=null;
			for (Vertex<String> aux:ciudades.getVertices()) {
				if (aux.getData().equals(origen)) {
					v1=aux;
				}
				if(aux.getData().equals(destino)) {
					v2=aux;
				}
			}
			if(v1!=null && v2!=null) {
				this.dfs(ciudades,v1,v2,camino,new boolean[ciudades.getSize()],distanciaMaxima);
		    }
		} 
		return camino;
	}
	
	public boolean dfs(Graph<String>ciudades,Vertex<String> v1,Vertex<String>v2
			,List<String>camino,boolean[]marcas,int distanciaMaxima) {
		boolean encontre=false;
		marcas[v1.getPosition()]=true;
		camino.add(v1.getData());
		if(v1==v2) {
			return true;
		}else {
			for (Edge<String> ady:ciudades.getEdges(v1)) {
				Vertex<String> aux=ady.getTarget();
				int pos=aux.getPosition();
				int peso=ady.getWeight();
				if(!marcas[pos] && ady.getWeight()<=distanciaMaxima) {
					encontre=this.dfs(ciudades, aux, v2, camino, marcas, distanciaMaxima-peso);
					if(encontre) break;
				}
			}
			if(!encontre) {
				marcas[v1.getPosition()]=false;
				camino.remove(camino.size()-1);
			}
		}
		return encontre;
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		
		Graph<String> ciudades=new AdjListGraph<>();
		
		Vertex<String> v1=ciudades.createVertex("Rio Cuarto");
		Vertex<String> v2=ciudades.createVertex("Villa Maria");
		Vertex<String> v3=ciudades.createVertex("Villa Gral. Belgrano");
		Vertex<String> v4=ciudades.createVertex("Cruz del Eje");
		Vertex<String> v5=ciudades.createVertex("Jesus Maria");
		Vertex<String> v6=ciudades.createVertex("Cordoba");
		
		ciudades.connect(v1, v2,70);
		ciudades.connect(v1, v3,50);
		ciudades.connect(v3, v4,85);
		ciudades.connect(v2, v5,60);
		ciudades.connect(v4, v6,60);
		ciudades.connect(v5, v6,90);
		
		
		Parcial p=new Parcial();
		
		System.out.println(p.caminoDistanciaMaximo(ciudades, "Rio Cuarto", "Cordoba", 195));
		System.out.println(p.caminoDistanciaMaximo(ciudades, "Rio Cuarto", "Cruz del Eje", 135));
	}
}




