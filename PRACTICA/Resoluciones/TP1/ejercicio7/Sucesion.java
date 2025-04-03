package ejercicio7;

import java.util.*;



public class Sucesion{
	
	public List<Integer> calcularSucesion(int n){
		
		List<Integer> lista = new ArrayList<>();
		calcularSucesionRec(n,lista);
		return lista;
	}	
		
	private void calcularSucesionRec(int n,List<Integer> lista) {
		lista.add(n);
		
		if (n==1) return;
		
		if(n% 2==0)
			calcularSucesionRec(n/2,lista);
		else
			calcularSucesionRec(3*n+1,lista);
		
	}	
		
	
	public static void main(String[] args) {
		
		Sucesion s=new Sucesion();
		
		System.out.println(s.calcularSucesion(20));
		
		
		
	}	
	
}