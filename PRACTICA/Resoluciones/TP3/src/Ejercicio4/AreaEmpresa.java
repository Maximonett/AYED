package Ejercicio4;

public class AreaEmpresa {
	private String identificacion;
	private int tardanza;
	
	public AreaEmpresa(String id,int tard) {
		this.identificacion=id;
		this.tardanza=tard;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	
	public void setIdentificacion(String identificaion) {
		this.identificacion=identificaion;
	}
	
	public int getTardanza() {
		return tardanza;
	}
	
	public void setTardanza(int tardanza) {
		this.tardanza=tardanza;
	}
	
	
	
}
