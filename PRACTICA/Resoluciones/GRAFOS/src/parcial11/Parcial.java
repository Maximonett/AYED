package parcial11;

import java.util.*;
import ejercicio1.*;
import parcial1.Ciudad;
import adjList.*;


public class Parcial {
	public List<String> rutaMasSegura(Graph<Calle>city){
		List<String> camino=new LinkedList<String>();
		if(!city.isEmpty()) {
			Vertex origen=null;
			Vertex destino=null;
			for (Vertex<Calle> v:city.getVertices()) {
				if(v.getData().getNombre().equals("Casa del Intendente")) {
					origen=v;
				}
				if(v.getData().getNombre().equals("Municipalidad")) {
					destino=v;
				}
			}
			if(origen!=null && destino!= null) {
				this.dfs(city,origen,destino,camino,new boolean[city.getSize()]);
			}	
		}
		return camino;
	}
	
	private boolean dfs(Graph<Calle>city,Vertex<Calle> origen,Vertex<Calle> destino
			,List<String>camino,boolean[]marcas) {
		boolean encontre=false;
		marcas[origen.getPosition()]=true;
		camino.add(origen.getData().getNombre());
		
		if (origen==destino) {
			return true;
		}else {
			for (Edge<Calle> ady: city.getEdges(origen)) {
				Vertex<Calle> aux=ady.getTarget();
				int pos=aux.getPosition();
				if(!marcas[pos]&& !aux.getData().getMafiosa()) {
					encontre=this.dfs(city, aux, destino, camino, marcas);
					if(encontre) break;
				}
			}
		}
		if (!encontre) camino.remove(camino.size()-1); 
		marcas[origen.getPosition()]=false;
		return encontre;
	}
    public static void main(String args[]) {
        Graph<Calle> grafo = new AdjListGraph<Calle>();
        Vertex<Calle> v1 = grafo.createVertex(new Calle("Casa del Intendente", false));
        Vertex<Calle> v2 = grafo.createVertex(new Calle("Calle 58", false));
        Vertex<Calle> v3 = grafo.createVertex(new Calle("Avenida Bengochea", true));
        Vertex<Calle> v4 = grafo.createVertex(new Calle("El Palomar", false));
        Vertex<Calle> v5 = grafo.createVertex(new Calle("Municipalidad", false));
        Vertex<Calle> v6 = grafo.createVertex(new Calle("Uruguay 121", false));
        
        grafo.connect(v1, v2, 1);
        grafo.connect(v2, v1, 1);
        grafo.connect(v1, v3, 0);
        grafo.connect(v3, v1, 0);
        grafo.connect(v1, v4, 0);
        grafo.connect(v4, v1, 0);
        grafo.connect(v2, v5, 1);
        grafo.connect(v5, v2, 1);
        grafo.connect(v3, v5, 1);
        grafo.connect(v5, v3, 1);
        grafo.connect(v4, v6, 0);
        grafo.connect(v6, v4, 0);
        grafo.connect(v6, v5, 0);
        grafo.connect(v5, v6, 0);
        
        Parcial p = new Parcial();
        
        System.out.println(p.rutaMasSegura(grafo));
    }
	
}
