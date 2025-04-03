package ejercicio7;

import java.util.Objects;

public class Estudiante{
	
	private String apellido;
	private String nombre;
	private String mail;
	private String facultad;
	
	
	
	public Estudiante(String apellido, String nombre, String mail, String facultad) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.mail = mail;
		this.facultad = facultad;
	}
	
	
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}



	@Override
	public String toString() {
		return "Estudiante [apellido=" + apellido + ", nombre=" + nombre + ", mail=" + mail + ", facultad=" + facultad
				+ "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj==null || getClass()!=obj.getClass()) return false;
		
		Estudiante e = (Estudiante) obj; // se castea el objeto estudiante 
		
		return apellido.equals(e.apellido) 
				&& nombre.equals(e.nombre ) 
				&& mail.equals(e.mail) 
				&& facultad.equals(e.facultad);
		
		
		
	}
	
	
	//CUAL ESTA MEJOR USAR EL INSTANCEOF O EL GETCLASS() ?????????????
	
	/*@Override
	public boolean equals(Object obj) {
	    if (obj == null || !(obj instanceof Estudiante)) return false;
	    
	    Estudiante e = (Estudiante) obj;
	    
	    return apellido.equals(e.apellido) 
	            && nombre.equals(e.nombre) 
	            && mail.equals(e.mail) 
	            && facultad.equals(e.facultad);
	}*/

	@Override
	public int hashCode() {
		return Objects.hash(nombre,apellido,mail,facultad);
	}
	
}