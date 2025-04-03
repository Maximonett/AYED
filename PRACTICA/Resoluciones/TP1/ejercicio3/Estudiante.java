package ejercicio3;


public class Estudiante{
	private String nombre="sin definir";
	private String apellido="sin definir";
	private int comision=0;
	private String email="sin definir";
	private String direccion="sin definir";
	
	
	public Estudiante() {
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getComision() {
		return comision;
	}


	public void setComision(int comision) {
		this.comision = comision;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	public String tusDatos() {
		String aux= "Nombre: "+ this.nombre +"\n"+
					"Apellido: "+this.apellido+"\n"+
					"Nº de Comision: "+getComision()+"\n"+
					"Correo electronico: "+getEmail()+"\n"+
					"Dirección: "+getDireccion()+"\n";
		
		return aux;
						
	}
	
	
	
	
}