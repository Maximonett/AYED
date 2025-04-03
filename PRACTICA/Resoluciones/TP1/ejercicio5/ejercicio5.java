/* 5. Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return". */


package ejercicio5;


public class ejercicio5{
	
	public static void main(String[] args) {
		
		
		int[] arreglo1= {6,9,10,8,30,87,1};
		
		
		
		System.out.println(Calculadora.maxMinPromA(arreglo1).toString());
		
		
		
		Datos d=new Datos();
		Calculadora.maxMinPomB(arreglo1, d);
		
		System.out.println(d.toString());

		
		Calculadora.maxMinPromC(arreglo1);
		
		Calculadora.maxMinPromC(arreglo1);
		
		System.out.println(Calculadora.devolverDatos());
	}
	
	
	
}