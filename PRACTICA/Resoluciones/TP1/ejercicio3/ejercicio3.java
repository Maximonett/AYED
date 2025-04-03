
/*
Creación de instancias mediante el uso del operador new
a. Cree una clase llamada Estudiante con los atributos especificados abajo y
sus correspondientes métodos getters y setters
 nombre
 apellido
 comision
 email
 direccion
b. Cree una clase llamada Profesor con los atributos especificados abajo y sus
correspondientes métodos getters y setters
 nombre
 apellido
 edad
 email
 catedra
 titulo
 facultad
c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante
y en la clase Profesor, que retornen un String con los datos de los atributos
de las mismas. Para acceder a los valores de los atributos utilice los getters
previamente definidos.
d. Escriba una clase llamada Test con el método main, el cual cree un arreglo
con 5 objetos Estudiante, otro arreglo con 4 objetos Profesor, y luego
recorra ambos arreglos imprimiendo los valores obtenidos mediante el
método tusDatos(). Recuerde asignar los valores de los atributos de los
objetos Estudiante y Profesor invocando los respectivos métodos setters.

*/
package ejercicio3;

import java.util.Random;

/*Test*/

public class ejercicio3{
	public static void main(String[] args) {
			
		
		Estudiante[] arregloE = new Estudiante[5];
		
		Profesor[] arregloP= new Profesor[4];
		
		for (int i=0;i<arregloE.length;i++) {
			arregloE[i] =new Estudiante(); //creo la instancia
			
			arregloE[i].setNombre("Estudiante "+(i+1));
			arregloE[i].setApellido("Apellido "+(i+1));
			arregloE[i].setComision(i+1);
			arregloE[i].setEmail("estudiante"+(i+1)+"hotmail.com");
			arregloE[i].setDireccion("direccion del estudiante"+(i+1));
		}
		
		
		for (int i=0;i<arregloP.length;i++) {
			arregloP[i]= new Profesor();//creo la instancia
			
			Random ran =new Random();
			int edadRandom=ran.nextInt(60)+25; //rango de 25 a 85 años
			arregloP[i].setNombre("Profesor "+(i+1));
			arregloP[i].setApellido("Apellido "+(i+1));
			arregloP[i].setEdad(edadRandom);
			arregloP[i].setEmail("profesor"+(i+1)+"@gmail.com");
			arregloP[i].setCatedra("Catedra "+(i+1));
			arregloP[i].setFacultad("Informatica");
			arregloP[i].setTitulo("IT");
		}
		
		System.out.println("Datos de los Estudiantes");
		
		for (int i=0;i<arregloE.length;i++) {
			System.err.println(arregloE[i].tusDatos());
		}
		
		System.out.println("Datos de los Profesores");
		
		for (int i=0; i<arregloP.length;i++) {
			System.out.println(arregloP[i].tusDatos());
		}
		
	}
	
	
	
}