/* Ejercicio 7
Dada una clase Caminos que contiene una variable de instancia de tipo GeneralTree de números
enteros, implemente un método que retorne el camino a la hoja más lejana. En el caso de haber
más de un camino máximo retorne el primero que encuentre.
El método debe tener la siguiente firma: public List<Integer> caminoAHojaMasLejana ()
Por ejemplo, para el siguiente árbol, la lista a retornar seria: 12, 17, 6, 1 de longitud 3
(Los caminos 12, 15, 14, 16 y 12, 15, 14, 7 son también máximos, pero se pide el primero). */


package Ejercicio7;


import java.util.*;
import Ejercicio1y2y3y5.GeneralTree;
import Ejercicio6.*;

public class Caminos {
	private GeneralTree<Integer> ab;
		
	
	public Caminos(GeneralTree<Integer> ab) {
		this.ab=ab;
	}
	
	public List<Integer> caminoAhojaMasLejana(){
		List<Integer> camAct=new LinkedList<>();
		List<Integer> camMax=new LinkedList<>();
		
		if (!ab.isEmpty()) caminoHelper(ab,camAct,camMax);
		return camMax;
	}
	
	private void caminoHelper(GeneralTree<Integer> a, List<Integer> camAct,List<Integer> camMax) {
		camAct.add(a.getData());
		if(!a.isLeaf()) {
			for (GeneralTree<Integer> h:a.getChildren()) {
				caminoHelper(h, camAct, camMax);
			}
		
		}else if (camAct.size()>camMax.size()){
			camMax.removeAll(camMax);
			camMax.addAll(camAct);
		}
		camAct.remove(camAct.size()-1);
		
	}
	
	public static void main(String[]args) {
		List<GeneralTree<Integer>> subchildren1=new LinkedList<>();
		subchildren1.add(new GeneralTree<>(1));
		GeneralTree<Integer> subA=new GeneralTree<>(6,subchildren1);
		
		List<GeneralTree<Integer>> subchildren2=new LinkedList<>();
		subchildren2.add(new GeneralTree<>(16));
		subchildren2.add(new GeneralTree<>(7));
		GeneralTree<Integer> subB=new GeneralTree<>(14,subchildren2);
		
		List<GeneralTree<Integer>> subchildren3=new LinkedList<>();
		subchildren3.add(new GeneralTree<>(10));
		subchildren3.add(subA);
		GeneralTree<Integer> subC=new GeneralTree<>(17,subchildren3);
		
		List<GeneralTree<Integer>> subchildren4=new LinkedList<>();
		subchildren4.add(subB);
		subchildren4.add(new GeneralTree<>(18));
		
		GeneralTree<Integer> subD=new GeneralTree<>(15,subchildren4);
		
		List<GeneralTree<Integer>> subchildren5=new LinkedList<>();
		subchildren5.add(subC);		
		subchildren5.add(subD);
		
		List<GeneralTree<Integer>> subchildren6=new LinkedList<>();
		subchildren6.add(new GeneralTree<>(8));
		
		GeneralTree<Integer> subE= new GeneralTree<>(9,subchildren6);
		
		
		subchildren5.add(subE);
		
		
		GeneralTree<Integer> a= new GeneralTree<>(12,subchildren5);
		
		
		Caminos cam= new Caminos(a);
		System.out.println("Camino a hoja mas lejana: "+ cam.caminoAhojaMasLejana());
		
	
		
		
	}
	
}
