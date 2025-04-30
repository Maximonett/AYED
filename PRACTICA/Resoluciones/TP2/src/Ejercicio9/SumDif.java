package Ejercicio9;

public class SumDif {
	private int sum;
	private int dif;
	
	
	public SumDif(int sum,int dif) {
		this.sum=sum;
		this.dif=dif;
	}
	
	public int getSum() {
		return sum;
	}
	
	public int getDif() {
		return dif;
	}
	
	public void setSum() {
		this.sum=sum;
	}
	
	public void setDif() {
		this.dif=dif;
	}
	
	@Override
	public String toString() {
		return "Sum= "+ sum + " Dif= "+dif;
	}
	
}
