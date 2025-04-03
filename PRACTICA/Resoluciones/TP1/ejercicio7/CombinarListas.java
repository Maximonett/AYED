package ejercicio7;


import java.lang.reflect.Array;
import java.util.*;


public class CombinarListas{
	
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
		
		ArrayList<Integer> resultado=new ArrayList<>();
		
		int i=0; int j=0;
		//Combinar listas manteniendo el orden
		
		while (i<lista1.size() && j<lista2.size()) {
			
			if (lista1.get(i)<=lista2.get(j)) {
				resultado.add(lista1.get(i));
				i++;
			}else {
				resultado.add(lista2.get(j));
				j++;
			}
		}
		//Agregar elementos restantes de la lista 1
		
		while (i<lista1.size()) {
			resultado.add(lista1.get(i));
			i++;
		}
		
		//Agregar elementos restantes de la lista 2
		while (j<lista2.size()) {
			resultado.add(lista2.get(j));
			j++;
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> lista1= new ArrayList<>();
		
		lista1.add(1);
		lista1.add(4);
		lista1.add(7);
		lista1.add(20);
		
		ArrayList<Integer> lista2=new ArrayList<>();
		
		lista2.add(5);
		lista2.add(8);
		lista2.add(17);
		lista2.add(21);
		lista2.add(32);
		lista2.add(40);
		
		ArrayList<Integer> resultado= combinarOrdenado(lista1,lista2);
		System.out.println(resultado);
		
	}
	
}