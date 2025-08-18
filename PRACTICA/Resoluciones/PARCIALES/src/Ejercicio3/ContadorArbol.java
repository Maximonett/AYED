package Ejercicio3;

import java.util.*;
import Ejercicio1y2.BinaryTree;
import Ejercicio3.Queue;
import Ejercicio3.*;


public class ContadorArbol {
	private BinaryTree<Integer> a;
	
	public ContadorArbol(BinaryTree<Integer> unArbol){
		a=unArbol;
		
	}
	
	public List<Integer> numerosParesPre(){
		List<Integer> l=new LinkedList<Integer>();
		if (!a.isEmpty()) this.nParesPre(l,a);
		return l;
		
	}
	
	
	private void nParesPre(List<Integer> l, BinaryTree<Integer> a) {
		
		if (a.getData()%2==0) l.add(a.getData());
		if (a.hasLeftChild()) nParesPre(l,a.getLeftChild());
		if (a.hasRightChild()) nParesPre(l,a.getRightChild());
	}
	
	public List<Integer> numerosParesIn() {
		List<Integer> l= new LinkedList<Integer>();
		if (!a.isEmpty()) this.nParesIn(l,a);
		return l;
	}
	
	private void nParesIn(List<Integer> l,BinaryTree<Integer> a) {
		if (a.hasLeftChild()) nParesIn(l,a.getLeftChild());
		if (a.getData()%2==0) l.add(a.getData());
		if (a.hasRightChild()) nParesIn(l, a.getRightChild());		
	}
	
	
	public List<Integer> numerosParesPost(){
		List<Integer> l=new LinkedList<Integer>();
		if (!a.isEmpty()) this.nParesPost(l,a);
		return l;
	}
	
	private void nParesPost(List<Integer> l, BinaryTree<Integer> a) {
		if (a.hasLeftChild()) nParesPost(l,a.getLeftChild());
		if (a.hasRightChild()) nParesPost(l,a.getRightChild());
		if (a.getData()%2==0) l.add(a.getData());
	}
	
	
	private void printLevelTraversal() {
		BinaryTree<Integer> ab=null;
		Queue<BinaryTree<Integer>> cola=new Queue<BinaryTree<Integer>>();
		
		cola.enqueue(a); //Agrega a la cola la raíz del árbol
		cola.enqueue(null);//Se agrega un marcador especial (null) para indicar el fin del primer nivel.
		while (!cola.isEmpty()) {
			ab=cola.dequeue();//saca el primer elemento de la cola y lo guarda en ab
			if (ab !=null) { //si no es el marcador de fin de nivel
				System.out.println(ab.getData()+" | ");
				if (ab.hasLeftChild()) cola.enqueue(ab.getLeftChild());
				if (ab.hasRightChild()) cola.enqueue(ab.getRightChild());									
			}else if (cola.isEmpty()){
				System.out.println();
				cola.enqueue(null);
			}
			
		}
	}
	
	
	public static void main(String arg[]) {
		
		
		
		
		BinaryTree<Integer> ab= new BinaryTree<Integer>(4);
		
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(6));
		
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
		
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
		
		
		
		
		ContadorArbol c= new ContadorArbol(ab);
		
		System.out.println("Imprimir por nivel");
		System.out.println();
		c.printLevelTraversal();
		
		System.out.println("---------------------------");
		System.out.println("Test numeros pares");
		System.out.println("---------------------------");
		List<Integer> lisIN =c.numerosParesIn();
		System.out.println("Numero pares INORDEN");
		System.out.println(lisIN);
		
		List<Integer> lisPost=c.numerosParesPost();
		System.out.println("Numeros pares Post");
		System.out.println(lisPost);
		
		List<Integer> lisPre=c.numerosParesPre();
		System.out.println("Numeros pares Pre");
		System.out.println(lisPre);
		
		System.out.println("Imrime de menor a mayor metodo 'imprimirArbol()' ");
		System.out.println();
		ab.imprimirArbol();
		
		
	}
	
}
