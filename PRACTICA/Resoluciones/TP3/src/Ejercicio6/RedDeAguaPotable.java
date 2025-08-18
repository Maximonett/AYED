/* Ejercicio 6
Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo
sucesivamente hasta llegar a cada una de las casas.
Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo
con las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas. Es
decir, si un caño maestro recibe 1000 litros y tiene por ejemplo 4 bifurcaciones se divide en 4 partes
iguales, donde cada división tendrá un caudal de 250 litros.
Luego, si una de esas divisiones se vuelve a dividir, por ej. en 5 partes, cada una tendrá un caudal de
50 litros y así sucesivamente hasta llegar a un lugar sin bifurcaciones.
Se debe implementar una clase RedDeAguaPotable que contenga el método con la siguiente firma:
public double minimoCaudal(double caudal)
que calcule el caudal de cada nodo y determine cuál es el caudal mínimo que recibe una casa. Asuma
que la estructura de caños de la red está representada por una variable de instancia de la clase
RedAguaPotable y que es un GeneralTree<Character>.
Extendiendo el ejemplo en el siguiente gráfico, al llamar al método minimoCaudal con un valor de
1000.0 debería retornar 25.0 */



package Ejercicio6;


import java.util.*;
import Ejercicio1y2y3y5.*;

public class RedDeAguaPotable {
	private GeneralTree<Character> ab;
	
	
	public RedDeAguaPotable(GeneralTree<Character> ab) {
		this.ab=ab;
	}
	
	
	public double minimoCaudal(double caudal) {
		if (ab.isEmpty()) return 0;
		return (!ab.isLeaf() ? minimoCaudal(ab,caudal):caudal);
	}
	
	private double minimoCaudal(GeneralTree<Character> ab,double caudal) {
		
		if (ab.isLeaf()) return caudal;
		
		double cantPorCaudal=caudal/ab.getChildren().size();
		double caudalMin=Double.MAX_VALUE;
		for (GeneralTree<Character> h: ab.getChildren()) {
			double caudalHijo=minimoCaudal(h,cantPorCaudal);
			caudalMin=Math.min(caudalMin,caudalHijo);
			
		}
		return caudalMin;	
	}
	
	
	public void imprimirPorNiveles() {
	    if (ab == null || ab.isEmpty()) return;

	    List<GeneralTree<Character>> cola = new LinkedList<>();
	    cola.add(ab);

	    while (!cola.isEmpty()) {
	        int nivelActual = cola.size();  // cantidad de nodos en este nivel

	        // Imprimir todos los nodos de este nivel
	        for (int i = 0; i < nivelActual; i++) {
	            GeneralTree<Character> nodo = cola.remove(0); // 👈 en vez de poll()

	            System.out.print(nodo.getData() + " ");

	            // Agregar hijos del nodo a la cola
	            for (GeneralTree<Character> hijo : nodo.getChildren()) {
	                cola.add(hijo);
	            }
	        }
	        System.out.println(); // Salto de línea al terminar el nivel
	    }
	}


	
	
	
	
	public static void main (String[] args) {
	    // Nodo hoja 'B'
	    GeneralTree<Character> ab1 = new GeneralTree<Character>('B');  // AB1
	    
	    // Lista de hijos para nodo 'G'
	    List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
	    subChildren1.add(new GeneralTree<Character>('L'));  // Hijo 'L'
	    
	    // Nodo 'G' con hijo 'L'
	    GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
	    
	    // Lista de hijos para nodo 'C'
	    List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
	    subChildren2.add(new GeneralTree<Character>('F'));  // Hijo 'F'
	    subChildren2.add(subAb1);                           // Hijo 'G' (que tiene a 'L')
	    
	    // Nodo 'C' con hijos 'F' y 'G'
	    GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2); //AB"
	    
	    // Lista de hijos para nodo 'J'
	    List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
	    subChildren3.add(new GeneralTree<Character>('M'));  // Hijo 'M'
	    subChildren3.add(new GeneralTree<Character>('N'));  // Hijo 'N'
	    
	    // Nodo 'J' con hijos 'M' y 'N'
	    GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
	    
	    // Lista de hijos para nodo 'D'
	    List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
	    subChildren4.add(new GeneralTree<Character>('H'));  // Hijo 'H'
	    subChildren4.add(new GeneralTree<Character>('I'));  // Hijo 'I'
	    subChildren4.add(subAb2);                           // Hijo 'J' (que tiene 'M' y 'N')
	    subChildren4.add(new GeneralTree<Character>('K'));  // Hijo 'K'
	    subChildren4.add(new GeneralTree<Character>('P'));  // Hijo 'P'
	    
	    // Nodo 'D' con hijos 'H', 'I', 'J', 'K', 'P'
	    GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);     
	    
	    // Nodo hoja 'E'
	    GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
	    
	    // Lista de hijos para la raíz 'A'
	    List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
	    arbol.add(ab1);  // Hijo 'B'
	    arbol.add(ab2);  // Hijo 'C'
	    arbol.add(ab3);  // Hijo 'D'
	    arbol.add(ab4);  // Hijo 'E'
	    
	    // Nodo raíz 'A' con hijos 'B', 'C', 'D', 'E'
	    GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
	    
	    // Se crea la red de agua con la estructura del árbol
	    RedDeAguaPotable red = new RedDeAguaPotable(ab);
	    
	    // Se calcula y muestra el caudal mínimo que llega a una casa (nodo hoja)
	    System.out.println("Caudal minimo que recibe una casa: " + red.minimoCaudal(1000.0));
	    
	    red.imprimirPorNiveles();
	    
	    
	}
  
	
	
}



