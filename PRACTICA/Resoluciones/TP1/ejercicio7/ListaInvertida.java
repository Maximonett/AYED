package ejercicio7;


import java.security.DomainCombiner;
import java.util.*;


public class ListaInvertida{
	
	public static void invertirArrayList(ArrayList<Integer> lista) {
		invertirArrayListRec(lista,0,lista.size()-1);
	
	}
	
	private static void invertirArrayListRec(ArrayList<Integer> lista, int inicio,int fin) {
		if (inicio<fin) {
			
			int temp=inicio;
			
			lista.set(inicio,lista.get(fin));
			lista.set(fin, temp);
			
			invertirArrayListRec(lista, inicio+1, fin-1);
			
		}
	}
		
		
		public static void main  (String[] args) {
			
			ArrayList<Integer> lista=new ArrayList<>();
			
			
			for (int i=0;i<10;i++) 
				lista.add(i);
			
			System.out.println("orden original de la lista");
			
			for (int n:lista)
				System.out.println(n);
			
			invertirArrayList(lista);
			
			System.out.println("Lista invertida");
			
			for (int n:lista)
				System.out.println(n);
			
			
		}
	
	
	
	
}