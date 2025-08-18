package Parcial2;

/*
 * Su tarea es la siguiente:
1. Escribir una clase llamada ProcesadorDeArbol
2. La clase ProcesadorDeArbol contiene UNA ÚNICA variable de instancia 
de tipo ArbolBinario de valores numéricos 
(no puede agregar más variables a esta clase).
3. La clase ProcesadorDeArbol contiene UN MÉTODO PÚBLICO llamado "procesar", 
que usa la variable definida en el punto anterior, recorre el árbol de manera 
recursiva, usando un recorrido
preorden y devuelve 2 valores:
• una LISTA con todos aquellos ÁRBOLES que cumplen con la siguiente condición: tienen
2 hijos y el valor del dato es par.
• la cantidad de valores pares en el árbol
public ???? procesar() (:..)

A modo de ejemplo, aplicando el método procesar() al siguiente árbol binario, el método retorna una lista de árboles que se encuentran marcados (coloreados con gris) en el gráfico y el valor 7 como la cantidad de

valores pares.
 * */

import java.util.*;



import Ejercicio1y2.BinaryTree;


public class ProcesadorDeArbol {
	private BinaryTree<Integer> arb;
	
	public ProcesadorDeArbol(BinaryTree<Integer> arb) {
		this.arb=arb;
	}	
	public Parcial procesar() {
		int cant=0;
		List<BinaryTree<Integer>> lis=new LinkedList<BinaryTree<Integer>>();
		if (!arb.isEmpty()) cant=procesar(arb,lis);
		return new Parcial(lis,cant);
	}
		
	
	private int procesar(BinaryTree<Integer> arb,List<BinaryTree<Integer>>lis) {
		int num=arb.getData();
		int cant=0;
		if (num%2==0) {
			cant++;
			if (arb.hasLeftChild() && arb.hasRightChild()) lis.add(arb);
		}
			
		if (arb.hasLeftChild()) cant+=procesar(arb.getLeftChild(),lis);
		if (arb.hasRightChild()) cant+=procesar(arb.getRightChild(),lis);
		return cant;
	}
	
		
	public static void main(String[] args) {
		
		BinaryTree<Integer> ab=new BinaryTree<Integer>(10);
		ab.addLeftChild(new BinaryTree<Integer>(6));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(20));
		
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(9));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(11));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(5));
		
		ab.addRightChild(new BinaryTree<Integer>(2));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(2));
		ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
		
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(3));
		
		
		
		
		ProcesadorDeArbol p=new ProcesadorDeArbol(ab);
		Parcial p1= p.procesar();
		
		System.out.println("Lista de Pares:");
		System.out.println(p1.getList());
		System.out.println("Cantidad de Pares:");
		System.out.println(p1.getCant());
		
		
		
		
	}
}
