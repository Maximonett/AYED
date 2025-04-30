package Ejercicio8;
/*
 * Escribir en una clase ParcialArboles el método público con la siguiente firma:
public boolean esPrefijo(BinaryT ree<Integer> arbol1, BinaryT ree<Integer> arbol2)
El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide
con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su
estructura
 */


import Ejercicio1y2.*;

public class ParcialArbol {
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1.isEmpty()) return true;
		if(arbol2.isEmpty()) return false;
		
		return esPrefijoHelper(arbol1,arbol2);
		
		
	}
	
	
	private boolean esPrefijoHelper(BinaryTree<Integer> arbol1,BinaryTree<Integer> arbol2) {
		
		if (arbol1.getData()!=arbol2.getData()) return false;
		
		boolean res=true;
		
		if (arbol1.hasLeftChild()) {
			if (arbol2.hasLeftChild()) {
				res=res && esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
			}else return false;
		}
		if (arbol1.hasRightChild()) {
			if (arbol2.hasRightChild()) {
				res=res && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
				
			}else return false;
		}
	
		return res;
	}
	
	
	public static void main (String[] args) {
		
		System.out.println("Test Ejercicio 8");
		
		ParcialArbol pa=new ParcialArbol();
		
		System.out.println("Arbol 1");
		
		BinaryTree<Integer> ab1=new BinaryTree<>(65);
		
		ab1.addLeftChild(new BinaryTree<>(37));
		ab1.addRightChild(new BinaryTree<>(81));
		
		ab1.getLeftChild().addRightChild(new BinaryTree<>(47));
		ab1.getRightChild().addRightChild(new BinaryTree<>(93));

		
		ab1.entreNiveles(0, 2);
		
		System.out.println("Arbol de 2");
		System.out.println();
		BinaryTree<Integer> ab2=new BinaryTree<>(65);
		
		ab2.addLeftChild(new BinaryTree<>(37));
		ab2.addRightChild(new BinaryTree<>(81));
		
		ab2.getLeftChild().addRightChild(new BinaryTree<>(47));
		ab2.getLeftChild().addLeftChild(new BinaryTree<>(22));
		ab2.getRightChild().addRightChild(new BinaryTree<>(93));
		
		ab2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(11));
		ab2.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(29));
		
		ab2.getRightChild().addLeftChild(new BinaryTree<>(76));
		ab2.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(85));
		ab2.getRightChild().getRightChild().addRightChild(new BinaryTree<>(94));
		
		ab2.entreNiveles(0, 3);
		
		System.out.println("El arbol 1 es prefifo de arbol 2: "+ pa.esPrefijo(ab1, ab2));
		
		BinaryTree<Integer> ab3=new BinaryTree<>(65);
		
		ab3.addLeftChild(new BinaryTree<>(37));
		ab3.addRightChild(new BinaryTree<>(81));
		
		ab3.getLeftChild().addRightChild(new BinaryTree<>(47));
		ab3.getLeftChild().addLeftChild(new BinaryTree<>(22));
		ab3.getRightChild().addRightChild(new BinaryTree<>(93));
		
		ab3.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(11));
		ab3.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(20));
		
		ab3.getRightChild().addLeftChild(new BinaryTree<>(76));
		ab3.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(85));
		ab3.getRightChild().getRightChild().addRightChild(new BinaryTree<>(94));
		
		ab3.entreNiveles(0, 3);
		
		System.out.println("El arbol 1 es prefifo de arbol 3: "+ pa.esPrefijo(ab1, ab3));
		
		System.out.println("El arbol 2 es prefifo de arbol 3: "+ pa.esPrefijo(ab2, ab3));
		
		
		
		
		
		
	}
}
