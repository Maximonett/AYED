package parcialDFSIII2024;

import java.util.*;
import adjList.*;
import ejercicio1.*;

public class Parcial {
	public List<Objeto> menosTrasbordo(Graph<String> maps, String origen){
		List<Objeto> lis=new LinkedList<Objeto>();
		if (!maps.isEmpty()) {
			Vertex<String> ori=maps.search(origen);
			if(ori!=null) {
				this.dfs(maps,ori,null,0,lis,new boolean[maps.getSize()]);
			}
		}
		return lis;
	}
	
	private void dfs(Graph<String> maps,Vertex<String> actual,Vertex<String> anterior
			,int trasbordos,List<Objeto> lis, boolean[]marcados) {
		
		marcados[actual.getPosition()]=true;
		List<Edge<String>> ady=maps.getEdges(actual);
		//Si la estacion actual es externa solo tiene un vecino
		if(ady.size()==1 && anterior!=null) {
			lis.add(new Objeto(actual.getData(),trasbordos));
		}
		
		for(Edge<String> e:ady) {
			Vertex<String> sig=e.getTarget();
			if(!marcados[sig.getPosition()]) {
				int nuevosTrasbordos=trasbordos;
				//si la estacion actual es un trasbordo y  no el origen
				if(anterior!=null && ady.size()>2) {  
					nuevosTrasbordos++;
				}
				dfs(maps,sig,actual,nuevosTrasbordos,lis,marcados);
			}
		}
	}
	
	public static void main(String args[]) {
		
		Graph<String> maps =new AdjListGraph<>();
		
		Vertex<String> v1=maps.createVertex("Butantá");
		Vertex<String> v2=maps.createVertex("Pineheiroa");
		Vertex<String> v3=maps.createVertex("Faria Lima");
		Vertex<String> v4=maps.createVertex("Paulista");
		Vertex<String> v5=maps.createVertex("Republica");
		Vertex<String> v6=maps.createVertex("Lux");
		Vertex<String> v7=maps.createVertex("C.Universitaria");
		Vertex<String> v8=maps.createVertex("Villa Lobo");
		Vertex<String> v9=maps.createVertex("Hebraica");
		Vertex<String> v10=maps.createVertex("Cidade Jardin");
		Vertex<String> v11=maps.createVertex("Villa Olimpia");
		Vertex<String> v12=maps.createVertex("Villa Madalena");
		Vertex<String> v13=maps.createVertex("Cinicas");
		Vertex<String> v14=maps.createVertex("Trianon");
		Vertex<String> v15=maps.createVertex("Brigadeiro");
		Vertex<String> v16=maps.createVertex("Armenia");
		Vertex<String> v17=maps.createVertex("Tirandenias");
		Vertex<String> v18=maps.createVertex("Paraiso");
		Vertex<String> v19=maps.createVertex("Saude");
		
		maps.connect(v1, v2);
		maps.connect(v2, v3);
		maps.connect(v3, v4);
		maps.connect(v4, v5);
		maps.connect(v5, v6);
		
		maps.connect(v2, v7);
		maps.connect(v2, v9);
		
		
		maps.connect(v7, v8);
		maps.connect(v9, v10);
		
		maps.connect(v10, v11);
		
		maps.connect(v4, v13);
		maps.connect(v4, v14);
		maps.connect(v14, v15);
		maps.connect(v13, v12);
		
		maps.connect(v5, v17);
		maps.connect(v5, v18);
		maps.connect(v18, v19);
		maps.connect(v17, v16);
		
		
		Parcial p=new Parcial();
		
		System.out.println(p.menosTrasbordo(maps,"Butantá"));
		
		
		
	}
	
	
	
}
