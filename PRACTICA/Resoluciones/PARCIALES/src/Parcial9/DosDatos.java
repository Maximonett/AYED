package Parcial9;

public class DosDatos {
	private int suma;
	private int dif;
	
	
	public DosDatos(int suma, int dif) {
		this.suma = suma;
		this.dif = dif;
	}
	
	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma=suma;
	}
	public int getDif() {
		return dif;
	}
	public void setDif(int dif) {
		this.dif=dif;
	}
	
	@Override
    public String toString() {
        return "(" + suma + ", " + dif + ")";
    }
}
