package Parcial3;

import Ejercicio1y2.BinaryTree;


public class ParcialArboles {
	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public Boolean isTwoTree(int num) {
	    BinaryTree<Integer> arb = buscar(ab, num);
	    if (arb == null) return false;
	    return isTwoTree(arb);
	}

	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int num) {
	    if (ab == null) return null;
	    if (ab.getData() == num) return ab;

	    BinaryTree<Integer> res = null;
	    if (ab.hasLeftChild()) {
	        res = buscar(ab.getLeftChild(), num);
	        if (res != null) return res;
	    }
	    if (ab.hasRightChild()) {
	        res = buscar(ab.getRightChild(), num);
	        if (res != null) return res;
	    }
	    return null;
	}

	
	private Boolean isTwoTree(BinaryTree<Integer> ab) {
		int ramIzq=-1;
		int ramDer=-1;
		if (ab.hasLeftChild()) ramIzq=contarDosHijos(ab.getLeftChild());
		if (ab.hasRightChild()) ramDer=contarDosHijos(ab.getRightChild());
		return ramIzq==ramDer;
	}
	
	private int contarDosHijos(BinaryTree<Integer> ab) {
		int cant=0;
		if (ab.hasLeftChild() && ab.hasRightChild()) cant++;
		if(ab.hasLeftChild()) cant+=contarDosHijos(ab.getLeftChild());
		if(ab.hasRightChild()) cant+=contarDosHijos(ab.getRightChild());
		return cant;
	}
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> ab=new BinaryTree<>(2);
		ab.addLeftChild(new BinaryTree<Integer>(7));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(23));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
		
		ab.getLeftChild().addRightChild(new BinaryTree<>(6));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
		ab.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
		ab.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(16));
		
		ab.addRightChild(new BinaryTree<Integer>(-5));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(4));
		ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(18));
		ab.getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<>(8));
		ab.getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTree<>(24));
		ab.entreNiveles(0, 4);
		
		ParcialArboles parc=new ParcialArboles(ab);
		
		System.out.println("Resultado: "+parc.isTwoTree(2));
		System.out.println("Resultado: "+parc.isTwoTree(7));
		System.out.println("Resultado: "+parc.isTwoTree(-3));
		System.out.println("Resultado: "+parc.isTwoTree(4));
		System.out.println("Resultado: "+parc.isTwoTree(55));
	}
}