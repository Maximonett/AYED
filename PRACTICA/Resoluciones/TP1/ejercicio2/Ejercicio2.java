/* 2. Escriba un método de clase que dado un número n devuelva un nuevo 
 * arreglo de tamaño n con los n primeros múltiplos enteros de n 
 * mayores o iguales que 1. 
 * Ejemplo: f(5) = [5; 10; 15; 20; 25]; 
 * f(k) = {n*k donde k : 1..k} 
 * Agregue al programa la posibilidad de probar con distintos valores 
 * de n ingresandolos por teclado, mediante el uso de System.in. 
 * La clase Scanner permite leer de forma sencilla valores de entrada. */

package ejercicio2;

import java.util.Scanner;

public class Ejercicio2{
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in); //creo un objeto Scanner
		
		System.out.println("Ingrese un numero entero: "); 
		
		int num= s.nextInt();
		
		
		int[] a =ClaseEje2.multiplosArrayN(num);
		
		for (int i=0;i<a.length;i++) {
			System.err.print(a[i]+ "|");
			
		}
		
		s.close(); //cierro el Scanner para no tener advertencias 
		
		
	}
	
	
}