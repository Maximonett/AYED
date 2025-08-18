/* Ejercicio 4
El esquema de comunicación de una empresa está organizado en una estructura jerárquica, en donde
cada nodo envía el mensaje a sus descendientes. Cada nodo posee el tiempo que tarda en transmitir el
mensaje. 
Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. Por
lo tanto, debe devolver 16.
a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.
El recorrido que utilizare para resolver el problema va a ser por niveles, ya que puedo sumar y calcular el promedio de un nivel,
y compararlo con un maximo. Y asi obtener el promMax haciendo comparaciones.
b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol)
Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada y que contiene
la identificación de la misma representada con un String y una tardanza de transmisión de mensajes
interna representada con int. */ 



package Ejercicio4;

import ejercicio8.*;
import ejercicio8.Queue;
import Ejercicio1y2y3y5.GeneralTree;
import java.util.*;


public class AnalizadorArbol {
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
	    if (arbol == null || arbol.isEmpty()) return 0;
	    return devolverMaximoPromedioHelper(arbol); 

	}
	
	private double devolverMaximoPromedioHelper(GeneralTree<AreaEmpresa> arbol) {
	    double max = -1; // Almacena el mayor promedio encontrado hasta el momento
	    double suma = 0; // Acumula las tardanzas de un nivel
	    int cantNodos = 0; // Cuenta cuántos nodos hay en el nivel actual

	    GeneralTree<AreaEmpresa> ab;
	    Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();

	    // Se encola el nodo raíz
	    cola.enqueue(arbol);
	    // Usamos null como marcador de fin de nivel
	    cola.enqueue(null);

	    // Recorremos el árbol por niveles
	    while (!cola.isEmpty()) {
	        ab = cola.dequeue(); // Extraemos un nodo de la cola

	        if (ab != null) {
	            // Acumulamos los valores del nodo actual
	            cantNodos++;
	            suma += ab.getData().getTardanza();

	            // Encolamos todos los hijos del nodo actual
	            for (GeneralTree<AreaEmpresa> child : ab.getChildren()) {
	                cola.enqueue(child);
	            }

	        } else if (!cola.isEmpty()) {
	            // Terminamos un nivel (encontramos el marcador null)
	            double promedio = suma / cantNodos;
	            max = Math.max(max, promedio); // Comparamos con el máximo

	            // Reiniciamos acumuladores para el siguiente nivel
	            suma = 0;
	            cantNodos = 0;

	            // Volvemos a poner un marcador para el próximo nivel
	            cola.enqueue(null);
	        }
	    }

	    // Al salir del bucle, aún puede quedar un nivel sin procesar
	    if (cantNodos > 0) {
	        double promedio = suma / cantNodos;
	        max = Math.max(max, promedio);
	    }

	    return max; // Devolvemos el mayor promedio encontrado
	}

	
	
	public static void main(String[] args) {
		
		List<GeneralTree<AreaEmpresa>> children1=new LinkedList<>();
		children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
		children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
		children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
		GeneralTree<AreaEmpresa> a1=new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13),children1);
		
		List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>(); 
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
        
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
        
        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
        
        AnalizadorArbol arb = new AnalizadorArbol();
        
        System.out.println("El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devolverMaximoPromedio(a));
    }
		
	
	
	
	
}





