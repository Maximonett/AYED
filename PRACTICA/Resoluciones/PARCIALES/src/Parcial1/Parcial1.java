package Parcial1;

import Ejercicio1y2.BinaryTree;
/*
 * Implemente en la clase Parcial, que tiene como variable de instancia un 
 * ArbolBinario<Integer», el método:
resolver(int k): boolean que devuelve true si el árbol es monodistante de mandato 
k y false en caso contrario.
Un árbol binario de enteros es monodistante de mandato k si la suma de los valores 
de los nodos ‹ cada camino que va desde la raíz a una hoja es igual a k. Realice un 
recorrido en preorden.
Ejemplo: para el siguiente árbol
- esMonodistante(8) devuelve true, porque todos los caminos desde la raíz hasta 
las hojas suman valor 8.
 * */



public class Parcial1 {
	private BinaryTree<Integer> arb;
	
	public Parcial1(BinaryTree<Integer> arb) {
		this.arb=arb;
	}
	
	public boolean resolver(int k) {
		return resolver(arb,k,0);
		
	}
	
	private boolean resolver(BinaryTree<Integer> arb,int k, int suma) {
		suma+=arb.getData();
		
		if (arb.isLeaf()) {
			return (suma==k);
		}else {
			boolean ok=true;
			if (arb.hasLeftChild()) ok=ok && resolver(arb.getLeftChild(),k,suma);
			if (arb.hasRightChild()) ok=ok && resolver(arb.getRightChild(),k,suma);
			return ok;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> ab= new BinaryTree<>(1);
		ab.addLeftChild(new BinaryTree<>(3));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(3));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(1));
		
		ab.addRightChild(new BinaryTree<>(4));
		ab.getRightChild().addLeftChild(new BinaryTree<>(1));
		ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(2));
		ab.getRightChild().addRightChild(new BinaryTree<>(3));
		
		Parcial1 a= new Parcial1(ab);
		
		System.out.println(a.resolver(8));
		
		
	}

}
