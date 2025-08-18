/* Ejercicio 9 
Implemente en la clase ParcialArboles el método:
public static boolean esDeSeleccion (GeneralTree<Integer> arbol)
que devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es.
Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos */

package Ejercicio9;

import java.util.LinkedList;
import java.util.List;

import Ejercicio1y2y3y5.GeneralTree;
import ejercicio8.Queue;

public class ParcialArboles {
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> q =new Queue<>();
		
		boolean ok= true; // se considera que un arbol vacio devolvera true
		if (!arbol.isEmpty()) {
			q.enqueue(arbol);
			while(!q.isEmpty()) {
				GeneralTree<Integer> aux= q.dequeue();
				int min=Integer.MAX_VALUE;
				for (GeneralTree<Integer> h:aux.getChildren()) {
					q.enqueue(h);
					min=Math.min(min, h.getData());
					
				}
				if (!aux.isLeaf() && aux.getData() != min)ok=false;
			
			}			
			return ok;
		}
		return true;
	}
	
	public static void main(String[]args) {
		
		List<GeneralTree<Integer>> subchildren1=new LinkedList<>();
		subchildren1.add(new GeneralTree<>(35));
		GeneralTree<Integer> subAb1=new GeneralTree<>(35,subchildren1);
		
		List<GeneralTree<Integer>> subChildren2=new LinkedList<>();
		subChildren2.add(subAb1);
		GeneralTree<Integer> subAb2=new GeneralTree<>(35,subChildren2);
		
		List<GeneralTree<Integer>> subChildren3= new LinkedList<>();
		subChildren3.add(new GeneralTree<>(35));
		subChildren3.add(new GeneralTree<>(83));
		subChildren3.add(new GeneralTree<>(90));
		subChildren3.add(new GeneralTree<>(33));
		GeneralTree<Integer> subA3= new GeneralTree<>(33,subChildren3);
		
		List<GeneralTree<Integer>> subChildren4=new LinkedList<>();
		subChildren4.add(new GeneralTree<>(14));
		subChildren4.add(new GeneralTree<>(12));
		subChildren4.add(subA3);
		
		GeneralTree<Integer> subA4 =new GeneralTree<>(12,subChildren4);
		
		List<GeneralTree<Integer>> subChildren5=new LinkedList<>();
		
		subChildren5.add(subA4);
		subChildren5.add(subAb2);
		
		GeneralTree<Integer> subA5=new GeneralTree<>(12,subChildren5);
		
		List<GeneralTree<Integer>> subChildren6=new LinkedList<>();
		subChildren6.add(new GeneralTree<>(25));
		GeneralTree<Integer> subA6=new GeneralTree<>(25,subChildren6);
		
		
		List<GeneralTree<Integer>> subChildren7=new LinkedList<>();
		subChildren7.add(subA5);
		subChildren7.add(subA6);
		
		GeneralTree<Integer> raiz=new GeneralTree<>(12,subChildren7);
		
		ParcialArboles pa= new ParcialArboles();
		
		System.out.println(pa.esDeSeleccion(raiz));
		
		
		
	}
		
		
	
	
	
}
