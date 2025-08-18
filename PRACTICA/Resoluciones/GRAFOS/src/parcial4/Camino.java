package parcial4;

import java.util.*;

public class Camino {
	private List<String> lis;
	private int cuadras;
	
	public Camino (List<String> lis,int cuadras) {
		this.lis=lis;
		this.cuadras=cuadras;
	}
	
	public String toString() {
		return lis +" = "+ cuadras + " caudras.";
	}
	
}
