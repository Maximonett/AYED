package Ejercicio7;


/*
 * Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo
BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:
public boolean isLeftTree (int num)
El método devuelve true si el subárbol cuya raíz es “num”
, tiene en su subárbol izquierdo una
cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
contrario. Consideraciones:
● Si “num” no se encuentra en el árbol, devuelve false.
● Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay
-1 árboles con único hijo.
 * 
 */

import Ejercicio1y2.*;

public class ParcialArboles {

	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> ab) {
		this.ab=ab;
		
	}
	
	public BinaryTree<Integer> getAb(){
		return ab;
	}
	
	private int contarHijoUnico(BinaryTree<Integer> arb) {
		int cant=0;
		if(arb.hasLeftChild()) cant+=contarHijoUnico(arb.getLeftChild());
		
		if (arb.hasRightChild()) cant+= contarHijoUnico(arb.getRightChild());
		
		if ((arb.hasLeftChild() && !arb.hasRightChild()) || (arb.hasRightChild() && !arb.hasLeftChild())) cant++;
		
		return cant;
		
	}
	
	private boolean isLeftTree(BinaryTree<Integer> arb) {
		int RamaIzq=-1;
		int RamaDer=-1;
		if (arb.hasLeftChild()) RamaIzq= contarHijoUnico(arb.getLeftChild());
		if (arb.hasRightChild()) RamaDer=contarHijoUnico(arb.getRightChild());
		
		return RamaIzq>RamaDer;
		
	}
	
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int num){
		
		if (ab.getData()==num) return ab;
		
		BinaryTree<Integer> res=null;
		
		if (ab.hasLeftChild()) {
			res=buscar(ab.getLeftChild(),num);
			if ((res!=null) && (!res.isEmpty())) return res;
		}
		if (ab.hasRightChild()) {
			res=buscar(ab.getRightChild(), num);
			if ((res!=null) && (!res.isEmpty())) return res;
		}
		
		return new BinaryTree<>(); //Devuleve vacio si no se encuentra
	}
	
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> arb= buscar(ab,num);
		return (!arb.isEmpty()) ? isLeftTree(arb):false;
						
	}
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> ab=new BinaryTree<>(2);
		
		ab.addLeftChild(new BinaryTree<>(7));
		ab.addRightChild(new BinaryTree<>(-5));
		
		ab.getLeftChild().addLeftChild(new BinaryTree<>(23));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
		
		ab.getLeftChild().addRightChild(new BinaryTree<>(6));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(11));
		
		ab.getRightChild().addLeftChild(new BinaryTree<>(19));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
		ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(18));
	
		ab.imprimirArbol();
		
		ab.entreNiveles(0, 4);
		

		ParcialArboles pa=new ParcialArboles(ab);
		
		System.out.println("Resultado: " + pa.isLeftTree(7));
		System.out.println("Resultado: " + pa.isLeftTree(2));
		System.out.println("Resultado: " + pa.isLeftTree(-5));
		System.out.println("Resultado: " + pa.isLeftTree(19));
		System.out.println("Resultado: " + pa.isLeftTree(-3));
	}
	
	
	
}
