package Parcial5;


import Ejercicio1y2.BinaryTree;
import Ejercicio3.Queue;

public class NivelArbol {
	private BinaryTree<Integer> ab;
	
	public NivelArbol(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	
	//MEJOR METODO
	
	public BinaryTree<Integer> minEnNivelAB(int n){
		BinaryTree<Integer> res=null;
		if (!ab.isEmpty()) {
			Queue<BinaryTree<Integer>> cola=new Queue<BinaryTree<Integer>>();
			int nivelActual=0;
			int min=Integer.MAX_VALUE;
			cola.enqueue(ab);
			while(!cola.isEmpty() && nivelActual<=n) {
				int i=cola.size();
				for (int j=0;j<i;j++) {
					BinaryTree<Integer> aux=cola.dequeue();
					if ((nivelActual==n)&&(aux.isLeaf())&& aux.getData()<min) {
						min=aux.getData();
						res=aux;
					}
					if (aux.hasLeftChild()) cola.enqueue(aux.getLeftChild());
					if (aux.hasRightChild()) cola.enqueue(aux.getRightChild());
				}
				nivelActual++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(4));
        
        NivelArbol a = new NivelArbol(ab);

        BinaryTree<Integer> res;

        res = a.minEnNivelAB(1);
        System.out.println(res != null ? res.getData() : "null");

        res = a.minEnNivelAB(2);
        System.out.println(res != null ? res.getData() : "null");

        res = a.minEnNivelAB(3);
        System.out.println(res != null ? res.getData() : "null");
        
        
    }

}
