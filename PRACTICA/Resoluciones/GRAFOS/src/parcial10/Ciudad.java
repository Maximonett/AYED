package parcial10;

public class Ciudad {
	private String nombre;
	private String fase;
	
	public Ciudad(String nombre,String fase) {
		this.nombre=nombre;
		this.fase=fase;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase=fase;
	}
	
}
