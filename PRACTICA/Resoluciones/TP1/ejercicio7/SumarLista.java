package ejercicio7;


import java.util.*;



public class SumarLista{
	
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		
		if (lista.isEmpty()) return 0;
		
		return sumarListaRec(lista,0,lista.size()-1);
	}	
		
	public static int sumarListaRec(LinkedList<Integer> lista,int inicio,int fin) {
		
		if (inicio>fin)return 0; //Caso base: si el indice inicial es mayor la suma es cero
		
		return lista.get(inicio) +sumarListaRec(lista,inicio+1,fin) ;
	}
		
	
	
	public static void main (String[] args) {
			
		LinkedList<Integer> lista=new LinkedList<>();
		
		for (int i=0;i<10;i++) {
			lista.add(i);
			
		}
		
		System.out.println("La Lista es: ");
		
		for (int i:lista)
			System.out.println(i);

		System.out.println("----------------------------");
		System.out.println("LA SUMA DE LA LISTA ES DE: ");
		System.out.println(sumarLinkedList(lista));
		
		
		
			
			
	}
		
	
	
	
}