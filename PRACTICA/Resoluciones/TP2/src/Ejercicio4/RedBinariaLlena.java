/* Ejercicio 4 
Una red binaria es una red que posee una topología de árbol binario lleno.
Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34
(Si hay más de un máximo retorne el último valor hallado).
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.
a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
problema.
La estrategia a seguir es recorrido en profundidad ya que se debe recorrer todo el camino del arbol hasta cada hoja.
b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int */



package Ejercicio4;

import java.util.*;
import Ejercicio1y2.BinaryTree;


public class RedBinariaLlena {
	BinaryTree<Integer> red;

	public RedBinariaLlena(BinaryTree<Integer> unArbolLleno) {
		this.red = unArbolLleno;
	}
	
	
	public int retardoReenvio() {
		
		return (!red.isEmpty()) ? retardoReenvio(red): 0;
	}
	
	
	private int retardoReenvio(BinaryTree<Integer> red) {
		
		int redHI=0;
		int redHD=0;
		
		if (red.hasLeftChild()) redHI=retardoReenvio(red.getLeftChild());
		
		if (red.hasRightChild()) redHD=retardoReenvio(red.getRightChild());
		
		return Math.max(redHI, redHD)+ red.getData();
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Test mayor retardo");
		
		BinaryTree<Integer> ab=new BinaryTree<>(4);
		
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(6));
		
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
		
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
		
		
		RedBinariaLlena red= new RedBinariaLlena(ab);
		
		
		System.out.println("El mayor retardo posible es "+red.retardoReenvio()+" segundos.");
		
		
		
		
		
	}
	
	
	
}
