/* 7. Uso de las estructuras de listas provistas por la API de Java. Para resolver este punto cree el
paquete tp1.ejercicio7
a. Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
números a la lista, imprime el contenido de la misma iterando sobre cada elemento.
b. Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué
diferencia encuentra respecto de la implementación? Justifique
c. ¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.?
d. Escriba un método que realice las siguientes acciones:
■ cree una lista que contenga 3 estudiantes
■ genere una nueva lista que sea una copia de la lista del inciso i
■ imprima el contenido de la lista original y el contenido de la nueva lista
■ modifique algún dato de los estudiantes
■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
¿Qué conclusiones obtiene a partir de lo realizado?
■ ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre
ellas?
e. A la lista del punto 7d, agregue un nuevo estudiante. Antes de agregar, verifique que el
estudiante no estaba incluido en la lista.
f. Escriba un método que devuelva verdadero o falso si la secuencia almacenada en la
lista es o no capicúa:
public boolean esCapicua(ArrayList<Integer> lista)
Ejemplo:
● El método devuelve verdadero si la secuencia ingresada es: 2 5 2
● El método devuelve falso si la secuencia ingresada es: 4 5 6 3 4
g. Considere que se aplica la siguiente función de forma recursiva. A partir de un número
n positivo se obtiene una sucesión que termina en 1:
Por ejemplo, para n= 6, se obtiene la siguiente sucesión:
f(6) = 6/2 = 3
f(3) = 3*3 + 1 = 10
f(10) = 10/2 = 5
….
Es decir, la sucesión 6, 3, 10, 5, 16, 8, 4, 2, 1. Para cualquier n con el que se arranque
siempre se llegará al 1.
■ Escriba un programa recursivo que, a partir de un número n, devuelva una lista
con cada miembro de la sucesión.
public class EjercicioSucesion {
public List<Integer> calcularSucesion (int n) {
//código
}}
h. Implemente un método recursivo que invierta el orden de los elementos en un ArrayList.
public void invertirArrayList(ArrayList<Integer> lista)
i. Implemente un método recursivo que calcule la suma de los elementos en un LinkedList.
public int sumarLinkedList(LinkedList<Integer> lista)
j. Implemente el método “combinarOrdenado” que reciba 2 listas de números ordenados y devuelva una nueva lista también ordenada conteniendo los elementos de las 2 listas.
public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,
ArrayList<Integer> lista2); */

package ejercicio7;

import java.util.*;
import java.util.stream.Collectors;

public class TestArrayList{
	public static void main(String[] args) {
		
		
	
	
	//Inciso A
	
	List<Integer> listaNum1 = new ArrayList<>();
	
	
	//agrego manualmente 
	
	listaNum1.add(18); 
	listaNum1.add(23);
	listaNum1.add(45);
	
	
	// PASO LOS VALORES DE ARGUMENTO STRING A INTEGER POR PARSEINT 
	for (String strNum:args) {
		
		listaNum1.add(Integer.parseInt(strNum));
		
	}
	
	
	//IMPRIMO  
	
	System.out.println("La lista de numeros ArrayList");
	
	
	for (Integer num:listaNum1) {
		
		System.out.println(num+" ");
	}
	
	//INCISO B 
    //La diferencia esta en el acceso a esos numeros, en el ArrayList es directo mientras que en la lista enlazada el acceso es mas ineficiente ya que se debe recorrer de forma secuncial
    //Ademas ArrayList necesita un espacio continuo de memoria para guardar datos mientras que LinkedList enlaza nodos con punteros y no requiere espacio continuo de memoria
    
	List <Integer> listaNums = new LinkedList <Integer>();
	
	//agrego manualmente 
	
	listaNums.add(3);
	listaNums.add(9);
	listaNums.add(29);
	
	
	// PASO LOS VALORES DE ARGUMENTO STRING A INTEGER POR PARSEINT 
    
    for(int i =0; i < args.length; i++)
        listaNums.add(Integer.parseInt(args[i]));
    System.out.println("Elementos insertados: " + listaNums.size());


  //IMPRIMO  EJERCICIO C......
    
    
    System.out.println("La lista de numeros LinkedList");
    
    for (Integer num:listaNums) {
    	System.out.println(num+" ");
    }
    
    Iterator <Integer> it= listaNums.iterator();
    while (it.hasNext())
    	System.out.println(it.next());
    
    System.out.println("-----------------------");
    
    for(int i=0; i<listaNum1.size();i++) 
    	System.out.println("Num "+listaNums.get(i));
    
    
    //INCISO D
    
    List<Estudiante> listEst =new ArrayList<>();
    
    
    Estudiante e1= new Estudiante("Simonetti", "Maximo", "ejemplo1@gmail.com","Informatica");
    Estudiante e2= new Estudiante("Gomez", "Juan", "ejemplo2@gmail.com","Informatica");
    Estudiante e3= new Estudiante("Simonetti", "Maximo", "ejemplo1@gmail.com","Informatica");
    Estudiante e4= new Estudiante("Garcia","Rogelio","ejemplo5@gmail.com","Exactas");
    
    
    
    listEst.add(e1);
    listEst.add(e2);
    listEst.add(e3);
    
    for (Estudiante est: listEst) {
    	System.out.println(est.toString());
    }

    System.out.println(e1.equals(e2)); //false
    System.out.println(e1.equals(e3)); //true
    
    
    //SE PUEDE COPIAR DE ARRAYLIST A LINKEDIST??????
    
    List<Estudiante> listaDeEstudiantesCopiados= new LinkedList(listEst);
    System.out.println("----------------");
    System.out.println("Estudiantes copiados");
    System.out.println("----------------");
    
    for (Estudiante est:listaDeEstudiantesCopiados) {
    	System.out.println(est.toString());
    }
    System.out.println("----------------");
    System.out.println("Copia con addAll");
    System.out.println("----------------");
    
    List<Estudiante> copia= new LinkedList<>();
    	copia.addAll(listEst);
    	
    	
    
    for (Estudiante est: copia) {
    	
    	System.out.println(est.toString());
    }
    	
    System.out.println("----------------");
    System.out.println("Copia con Inmutable COPYOF");
    System.out.println("----------------");
    
    List<Estudiante> copia2 = List.copyOf(listEst);	
    
    Iterator<Estudiante> ite = copia2.iterator();
    	while (ite.hasNext())
    		System.out.println(ite.next());
    
    
    		
    System.out.println("----------------");
    System.out.println("Copia con Collect");
    System.out.println("----------------");
    
    List<Estudiante> copia3 = copia2.stream().collect(Collectors.toList());
    
    Iterator<Estudiante> ite2=copia3.iterator();
    
    while(ite2.hasNext()) 
    	System.out.println(ite2.next());

    
    
}
    
    
    public static void agregarEstudianteSiNoExiste(List<Estudiante> listEst,Estudiante e4 ) {
    	boolean existe=false;
        
        for (Estudiante e:listEst) {
        	
        	if (e4.equals(e)){
        		existe=true;
        		break;
        	}
        }
        if (!existe) {
        	listEst.add(e4);
        	System.out.println("Estudiante agregado correctamente");
        }else {
        	System.out.println("El estudiante ya se encuentra en la lista");
        }
    	
    }
    
    
    public	static void agregarEstudianteSiNoExisteConSet(List<Estudiante> listEst, Estudiante e4) {
		Set<Estudiante> setEstudiante= new HashSet<>(listEst);
		
		if (!setEstudiante.contains(e4)) {
			listEst.add(e4);
			System.out.println("Estudiante agregado");
		}else {			
			System.out.println("El estudiante ya se encuentra en la lista");
		}
		
		
	}
    	
    
    

	
	
	

	
	
}