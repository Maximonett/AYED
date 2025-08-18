package EjesParciales;

import Ejercicio1y2.BinaryTree;

public class Eje4<T> {

	public void traverse(BinaryTree<T> a) {
	    if (!a.isEmpty()) {
	        System.out.println(a.getData()); // (1) imprimir al entrar al nodo

	        if (a.hasLeftChild())
	            traverse(a.getLeftChild());

	        if (a.hasRightChild()) {
	            traverse(a.getRightChild());
	        
	        System.out.println(a.getData()); // (2) imprimir de nuevo al padre
	        }
	    }
	}

	
}

//Arbol en Por niveles

/*
 *         C
 * 
 *  A            E
 * 
 *     B      D     F 
 */




 //orden de impresion es C A B A E D F E C 