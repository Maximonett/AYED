package Parcial4;

import Ejercicio1y2.BinaryTree;
import java.util.*;

public class Parcial {
	private List<BinaryTree<Integer>> lis;
	private int cant;
	
	public Parcial(List<BinaryTree<Integer>> lis,int cant) {
		this.lis=lis;
		this.cant=cant;
	}
	
	public List<BinaryTree<Integer>> getList(){
		return lis;
	}
	public void setList(List<BinaryTree<Integer>>lis ) {
		this.lis=lis;
	}
	
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant=cant;
	}
}
