package Parcial9;

import Ejercicio1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	public BinaryTree<DosDatos> sumaAndDif(BinaryTree<Integer> arbol){
		BinaryTree<DosDatos> nuevoAb=new BinaryTree<DosDatos>();
		
		if(!arbol.isEmpty()) {
			this.crear(this.arbol,nuevoAb,0);
		}
		return nuevoAb;
	}
	
	private void crear(BinaryTree<Integer> ab,BinaryTree<DosDatos> nuevoArbol, int num) {
		int datoOriginal=ab.getData();
		
		int suma=num+datoOriginal;
		int dif=datoOriginal-num;
		
		DosDatos dato=new DosDatos(suma,dif);
		nuevoArbol.setData(dato);//muy importantes guardar los datos
		
		if (ab.hasLeftChild()) {
			nuevoArbol.addLeftChild(new BinaryTree<>());
			
			this.crear(ab.getLeftChild(), nuevoArbol.getLeftChild(),datoOriginal);
			
		}
		if (ab.hasRightChild()) {
			nuevoArbol.addRightChild(new BinaryTree<>());
			this.crear(ab.getRightChild(), nuevoArbol.getRightChild(),datoOriginal);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> ab=new BinaryTree<>(20);
		
		ab.addLeftChild(new BinaryTree<>(5));
		ab.getLeftChild().addLeftChild(new BinaryTree<>(-5));
		ab.getLeftChild().addRightChild(new BinaryTree<>(10));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(1));
		
		ab.addRightChild(new BinaryTree<>(30));
		ab.getRightChild().addLeftChild(new BinaryTree<>(50));
		ab.getRightChild().addRightChild(new BinaryTree<>(-9));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
		ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<>(6));
		
		ParcialArboles p=new ParcialArboles(ab);
		
		
		BinaryTree<DosDatos> respuesta= p.sumaAndDif(ab);
		
		
		
		respuesta.entreNiveles(0, 4);
		
		
		
		
		
		
		
		
		
	}
	
}
