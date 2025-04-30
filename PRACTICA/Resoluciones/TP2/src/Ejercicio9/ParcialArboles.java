package Ejercicio9;

/*
 * Escribir en una clase ParcialArboles el método público con la siguiente firma:
public BinaryT ree<?> sumAndDif(BinaryT ree<Integer> arbol)
El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada
nodo dos tipos de información:
● La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.
● La diferencia entre el número almacenado en el nodo original y el número almacenado en el
nodo padre.
 */

import Ejercicio1y2.*;

public class ParcialArboles {
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<SumDif> arbolSD=new BinaryTree<>();
		if (!arbol.isEmpty()) {
			this.sumAndDif(arbol,arbolSD,0,0);
		}
		return arbolSD;
	}
		
	private void sumAndDif(BinaryTree<Integer> arbol,BinaryTree<SumDif>arbolSD,int sum,int padre) {
		int datoActual=arbol.getData();
		SumDif sad=new SumDif(datoActual+sum,datoActual-padre);
		arbolSD.setData(sad);
		if (arbol.hasLeftChild()) {
			arbolSD.addLeftChild(new BinaryTree<SumDif>());
			sumAndDif(arbol.getLeftChild(),arbolSD.getLeftChild(),sum+datoActual,datoActual);
		}
		if (arbol.hasRightChild()) {
			arbolSD.addRightChild(new BinaryTree<SumDif>());
			sumAndDif(arbol.getRightChild(),arbolSD.getRightChild(),sum+datoActual,datoActual);
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("etst ejercicio 9");
		System.out.println();
		
		BinaryTree<Integer> ab=new BinaryTree<>(20);
		ab.addLeftChild(new BinaryTree<>(5));
		ab.addRightChild(new BinaryTree<>(30));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(-5));
		ab.getLeftChild().addRightChild(new BinaryTree<>(10));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(1));
		
		ab.getRightChild().addLeftChild(new BinaryTree<>(50));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
		
		ab.getRightChild().addRightChild(new BinaryTree<>(-9));
		
		
		System.out.println("Arbol de integer");
		ab.entreNiveles(0, 3);
		
		
		ParcialArboles pa=new ParcialArboles();
		
		pa.sumAndDif(ab).entreNiveles(0, 3); 
		
			
		
		
	}
	
}
