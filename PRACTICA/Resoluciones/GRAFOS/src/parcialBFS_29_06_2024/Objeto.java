package parcialBFS_29_06_2024;

public class Objeto {
	private int cant;
	private boolean popular;
	
	public Objeto() {
	}
	
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant=cant;
	}
	public boolean getPopular() {
		return popular;
	}
	public void setPopular(boolean popular) {
		this.popular=popular;
	}
	
	public String toString() {
		return cant+ " "+ popular;
	}
}
