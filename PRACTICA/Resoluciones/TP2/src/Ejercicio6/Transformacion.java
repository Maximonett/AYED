package Ejercicio6;

/*Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros.*/


import Ejercicio1y2.*;
import Ejercicio5.ProfundidadDeArbolBinario;

import java.util.*;


public class Transformacion {
	private BinaryTree<Integer> ab;

	public Transformacion(BinaryTree<Integer> unArbol) {
		this.ab = unArbol;
	}
	
	
	public BinaryTree<Integer> getAb(){
		
		return ab;
		
	}
	
	public BinaryTree<Integer> suma(){
		suma(ab);
		return ab;
		
	}
	
	private int suma(BinaryTree<Integer> ab) {
	    int sum = 0; // Inicializa la variable que almacenará la suma de los valores de los subárboles

	    if (ab.isLeaf()) { // Si el nodo es una hoja (no tiene hijos)
	        sum = ab.getData(); // Guarda el valor actual del nodo hoja
	        ab.setData(0); // Reemplaza el valor del nodo por 0 como indica el enunciado
	        return sum; // Retorna el valor original del nodo hoja
	    }

	    if (ab.hasLeftChild()) { // Si el nodo tiene hijo izquierdo
	        sum += suma(ab.getLeftChild()); // Llama recursivamente a suma() con el hijo izquierdo y acumula la suma
	    }

	    if (ab.hasRightChild()) { // Si el nodo tiene hijo derecho
	        sum += suma(ab.getRightChild()); // Llama recursivamente a suma() con el hijo derecho y acumula la suma
	    }

	    int actual = ab.getData(); // Guarda el valor actual del nodo (antes de modificarlo)

	    ab.setData(sum); // Reemplaza el valor del nodo por la suma de sus subárboles izquierdo y derecho

	    return actual + sum; // Retorna la suma total del subárbol, incluyendo el valor original del nodo
	}

	
	//SUMA NODOS DE CUALQUIER ARBOL
	
	public static int sumaNodos(BinaryTree<Integer> ab) {
		if (ab ==null || ab.isEmpty()) return 0 ;
		
		int suma=ab.getData();
		
		if (ab.hasLeftChild()) {
			suma+=sumaNodos(ab.getLeftChild());
		} 
		if (ab.hasRightChild()) {
			suma+=sumaNodos(ab.getRightChild());
		}
		
		return suma;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("----------Tramformacion----------");
		
		BinaryTree<Integer> ab=new BinaryTree<>(4);
		
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(6));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
		
		ab.imprimirArbol();
		
		System.out.println("La suma de todos los nodos ");
		System.out.println(sumaNodos(ab));
		
		
		
		Transformacion trans= new Transformacion(ab);
		trans.suma();
	
		System.out.println("Arbol Tranformado");
		trans.getAb().imprimirArbol();
		
		System.out.println();
		System.out.println("Suma tranformado: ");
		System.out.println(trans.suma(ab));
		
	}
	
}
