package ejercicio3;

public class Profesor{
	private String nombre="sin definir";
	private String apellido="sin definir";
	private int edad=0;
	private String email="sin definir";
	private String catedra="sin definir";
	private String titulo="sin definir";
	private String facultad="sin definir";
	
	public Profesor() {
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String tusDatos() {
		String aux= "Nombre: "+ getNombre() +"\n"+
					"Apellido: "+getApellido()+"\n"+
					"Edad: "+getEdad()+"\n"+
					"Correo Electronico: "+getEmail()+"\n"+
					"Catedra: "+getCatedra()+"\n"+
					"Titulo: "+getTitulo()+"\n"+
					"Facultad: "+getFacultad()+"\n";
		
		return aux;
						
	}
	
	
	
	
	
	
}