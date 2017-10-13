package cdio1;


public class Spiller {
	String navn;
	int point;
	
	public Spiller(String navn ) {
		this.navn = navn;
		point = 0;
	}
	
	public String getSpiller() {
		return navn;
	}
	
	public String toString() {
		return navn;
	}
	
	public void addPoint(int gain) {
		point += gain;
	}
	
	public void nulstilPoint() {
		point = 0;
	}
	
	public int getPoint() {
		return point;
	}
	
}
