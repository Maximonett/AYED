package parcialBFSTema1_2024;

import ejercicio1.*;
import Ejercicio3.Queue;
import adjList.*;
import java.util.*;


public class Parcial {
	public List<Objeto> invitacionMasterClass(Graph<String>red,String usuario, int distancia,int limite){
		List<Objeto> lis=new LinkedList<>();
		if(!red.isEmpty()) {
			Vertex<String> origen=red.search(usuario);
			if(origen!=null) {
				this.bfs(red,origen,lis,distancia,limite);
			}
		}
		return lis;
	}
	
	private void bfs(Graph<String> red,Vertex<String> origen,List<Objeto> lis,int distancia,int limite) {
		
		/*  
			int grado = 0;
			lis.add(new Objeto(origen.getData(), 0)); // el que invita se agrega 
			cant = 1;
		 */
		
		int grado=1; // nivel de profundidad,indica la distacia desde el origen
		int cant=0; //cantidad de personas en la lista de invitados, con esto freno cuando llego al limite
		
		boolean[]marcas=new boolean[red.getSize()];
		// en BFS no es obligatorio que este afuera, pero para DFS siempre afuera en el metodo publico
		marcas[origen.getPosition()]=true; //marco el origen 
		Queue<Vertex<String>> cola= new Queue<Vertex<String>>(); 
		cola.enqueue(origen);
		cola.enqueue(null);//encolo el marcador de nivel en el origen
		while(!cola.isEmpty() && cant<limite && grado<=distancia) {
			Vertex<String> aux=cola.dequeue();
			if(aux!=null) {
				for (Edge<String> ady:red.getEdges(aux)) {
					Vertex<String>v=ady.getTarget();
					int pos=v.getPosition();
					if (!marcas[pos]) {   
						marcas[pos]=true; // se lo marca
						cola.enqueue(v);	// se lo encola
						lis.add(new Objeto(v.getData(),grado)); // y se agrega a la lista
						cant++;//se cuenta 
					}
				}
			}else if(!cola.isEmpty()) {
				grado++;//se avanza un grado
				cola.enqueue(null);//marca el nuevo nivel
			}
		}
	}
	
    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lionel");
        Vertex<String> v2 = grafo.createVertex("Rodrigo");
        Vertex<String> v3 = grafo.createVertex("Ángel");
        Vertex<String> v4 = grafo.createVertex("Emiliano");
        Vertex<String> v5 = grafo.createVertex("Julián");
        Vertex<String> v6 = grafo.createVertex("Diego");
        Vertex<String> v7 = grafo.createVertex("Lautaro");
        Vertex<String> v8 = grafo.createVertex("Enzo");
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        
        grafo.connect(v1, v3);
        grafo.connect(v3, v1);
        
        grafo.connect(v2, v4);
        grafo.connect(v4, v2);
        
        grafo.connect(v2, v5);
        grafo.connect(v5, v2);
        
        grafo.connect(v3, v5);
        grafo.connect(v5, v3);
        
        grafo.connect(v3, v6);
        grafo.connect(v6, v3);
        
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        grafo.connect(v6, v8);
        grafo.connect(v8, v6);
        
        grafo.connect(v4, v8);
        grafo.connect(v8, v4);
        
        grafo.connect(v4, v7);
        grafo.connect(v7, v4);
        
        Parcial p = new Parcial();
        
        System.out.println(p.invitacionMasterClass(grafo, "Lionel", 2, 4));
        System.out.println(p.invitacionMasterClass(grafo, "Juancito", 1, 2));
    }
	
}
