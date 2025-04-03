package ejercicio2;


public class ClaseEje2{
	
	
	
	public static int[] multiplosArrayN(int n){
		int[] arreglo = new int[n]; //declaracion del arreglo
		
		int num=0; // inicializo la variable num
		
		for (int i=0;i<n;i++) {
			arreglo[i]=n + num;
			num+=n;
		}
		
		return arreglo;
		
	}
	
	
	
	
}