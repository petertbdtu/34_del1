package cdio1;

public class Terning {

	private int værdi;
	public int kast() {
		return this.værdi=(int)(Math.random()*6.0)+1;
	}
	public int getVærdi() {
		return this.værdi;
	}
	public String toString() {
		return "Øjneværdi: " + værdi;
	}
}
