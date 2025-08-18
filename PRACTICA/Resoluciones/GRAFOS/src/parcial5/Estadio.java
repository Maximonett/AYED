package parcial5;

public class Estadio {
	private String ciudad;
	private String nombre;
	
	
	public Estadio(String ciudad,String nombre) {
		this.ciudad=ciudad;
		this.nombre=nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad=ciudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
}
