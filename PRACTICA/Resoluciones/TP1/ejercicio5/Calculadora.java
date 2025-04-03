package ejercicio5;


public class Calculadora{
	
	private static Datos d;
	
	public Calculadora(){
		
	}
	
	//paso por return 
	
	public static Datos maxMinPromA(int[] arreglo) {
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		double sum=0;
		
		for (int num:arreglo) {
			if (num>max) max=num;
			if (num<min) min=num;
			sum+=num;
		}
		
		Datos obj=new Datos(max,min,sum/arreglo.length);
		return obj;
	}
	
	
	//paso por parametro de otro tipo que no se arreglo
	
	public static void maxMinPomB(int[] arreglo,Datos d) {
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		double sum=0;
		
		for (int num:arreglo) {
			
			if (num>max) max=num;
			if (num<min) min=num;
			sum+=num;
		}
		
		d.setMax(max);
		d.setMin(min);
		d.setProm(sum/arreglo.length);
		
	}
	
	//sin parametros ni la sentencia return
	
	public static void maxMinPromC(int[] arreglo) {
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		double sum=0;
		
		for (int num:arreglo){
			
			if (num>max) max=num;
			if (num<min) min=num;
			sum+=num;
			
		}
		
		d=new Datos();
		d.setMax(max);
		d.setMin(min);
		d.setProm(sum/arreglo.length);
		
	}
	
	public static Datos devolverDatos() {
		return d;
		
	}
	
	
	
	
	
}