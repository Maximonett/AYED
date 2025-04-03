package ejercicio7;

import java.util.*;

public class capicua{
	
	
	//1er metodo...
	
	public boolean esCapicua(ArrayList<Integer> lista) {
		
		boolean es=true;
		if (!lista.isEmpty()) {
			
			int pri=0;
			int ult=lista.size()-1;
			
			while ((pri<ult) && es) {
				if (lista.get(pri).equals(lista.get(ult))) {
					pri++;
					ult--;
				}
				else es=false;
			}
		}
		return es;	
	}
	
	//2do metodo recursivo
	
	public static boolean esPalindromo(List<Integer> lista) {
		
		if (lista.isEmpty() || lista.size()==1) return true;
		
		else
			if (!lista.get(0).equals(lista.get(lista.size()-1))) return false;
			else
				return esPalindromo(lista.subList(1, lista.size()-1));
	}
	
	
	//3er metodo 
	
	public boolean esCapicuaRec(ArrayList<Integer> lista, int pri, int ult) {
		if (!lista.isEmpty() && lista.size()>1)
			return esCapicua(lista,0,lista.size()-1);
		return true;
		
	}
	private boolean esCapicua(ArrayList<Integer> lista, int pri, int ult) {
		boolean es=true;
		if (pri<ult)
			if (lista.get(pri).equals(lista.get(ult))) es=esCapicua(lista,pri+1,ult-1);
			else es=false;
		return es;
		
		
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list=new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);
		
		capicua c=new capicua();
		
		
		
		System.out.println("es capicua: " + c.esCapicua(list)) ;
		System.out.println("es capicua: "+ c.esPalindromo(list));
		System.out.println("es capicua: "+c.esCapicuaRec(list,0,list.size()-1));
		
		
		
	}
	
	
	
}