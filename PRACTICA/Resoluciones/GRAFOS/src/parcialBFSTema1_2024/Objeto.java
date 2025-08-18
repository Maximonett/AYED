package parcialBFSTema1_2024;

public class Objeto {
	private String nombre;
	private int distancia;
	
	public Objeto(String nombre,int distancia) {
		this.nombre=nombre;
		this.distancia=distancia;
	}
	
	public String getNombre() {
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getDistacia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia=distancia;
	}

	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", distancia=" + distancia + "]";
	}
	
	
	
}
