package Ejercicio5;


import Ejercicio1y2.*;
import java.util.*;


public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> unArbol) {
		ab=unArbol;		
	}
	
	
	public int sumaElementosEnProfundidad(int p) {
		
		return (!ab.isEmpty()) ? sumaElementosEnProfundidad(p,ab,0):0;
		
	}
	
	
	private int sumaElementosEnProfundidad(int p,BinaryTree<Integer> ab,int nivelActulal) {
		if (p==nivelActulal) {
			return ab.getData();
		}else {
			
			int suma=0;
			if (ab.hasLeftChild()) suma+=sumaElementosEnProfundidad(p, ab.getLeftChild(), nivelActulal+1);
			if (ab.hasRightChild()) suma+=sumaElementosEnProfundidad(p, ab.getRightChild(), nivelActulal+1);
			return suma;
			
		}
			
	}
	
	public int sumaNivel(int nivel) {
	    if (ab != null && !ab.isEmpty()) {
	        return sumaElementosEnProfundidad(nivel, ab, 0);
	    }
	    return 0;
	}

	
	public static void main (String[] args) {
        System.out.println("Test Profundidad");
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
        System.out.println(prof.sumaElementosEnProfundidad(2));
        System.out.println();
        
        
        System.out.println("Con suma nivel =2");
        System.out.println(prof.sumaNivel(2));
        System.out.println("Con suma nivel =1");
        System.out.println(prof.sumaNivel(1));
        System.out.println("Con suma nivel =0");
        System.out.println(prof.sumaNivel(0));
        
        
	}
}
