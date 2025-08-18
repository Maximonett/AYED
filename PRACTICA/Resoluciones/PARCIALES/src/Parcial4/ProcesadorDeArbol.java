package Parcial4;

import Ejercicio1y2.BinaryTree;
import java.util.*;

public class ProcesadorDeArbol {
	private BinaryTree<Integer> ab;
	
	public ProcesadorDeArbol(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public Parcial procesar() {
		int cant=0;
		List<BinaryTree<Integer>> lis=new LinkedList<>(); //defino un lista de arboles
		if (!ab.isEmpty()) cant=procesar(ab,lis); 
		return new Parcial(lis,cant);
	}
	
	
	private int procesar(BinaryTree<Integer> ab,List<BinaryTree<Integer>> lis) {
		int num=ab.getData();
		int cant=0;
		
		if (ab.hasLeftChild()) cant+=procesar(ab.getLeftChild(),lis);
		if(ab.hasRightChild()) cant+=procesar(ab.getRightChild(),lis);
		
		
		if(num%2==1) {
			cant++;
			if((ab.hasLeftChild() && !ab.hasRightChild()) | (ab.hasRightChild() && !ab.hasLeftChild())) lis.add(ab);
		}

		
		return cant;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> ab=new BinaryTree<>(10);
		
		ab.addLeftChild(new BinaryTree<>(6));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(1));
		ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(20));
		
		ab.getLeftChild().addRightChild(new BinaryTree<>(9));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(11));
		
		ab.addRightChild(new BinaryTree<>(2));
		ab.getRightChild().addLeftChild(new BinaryTree<>(8));
		ab.getRightChild().addRightChild(new BinaryTree<>(3));
		ab.getRightChild().getRightChild().addRightChild(new BinaryTree<>(4));
		
		ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(2));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
		
		
		ProcesadorDeArbol p=new ProcesadorDeArbol(ab);
		
		 int cant=p.procesar().getCant();
		 List<BinaryTree<Integer>> lis= p.procesar().getList();
		 
		 System.out.println("La cantidad de nodos impares es: "+cant);
		 System.out.println("Lista de padres con hijos unicos: "+lis);
		 
		
		
		
		
	}

}
