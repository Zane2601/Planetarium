package it.unibs.fp.planetarium;

public class Vettore {
	
	private int asseX;
	private int asseY;
	
	public Vettore (int asseX, int asseY) {
		this.asseX = asseX;
		this.asseY = asseY;
	}
	
	public int getAsseX() {
		return asseX;
	}
	public int getAsseY() {
		return asseY;
	}
	
	
	/**
	 * 
	 * @param v1 primo punto
	 * @param v2 secondo punto
	 * @return la distanza tra i due punti. Stabilire nel Main una distanza massima oltre la quale non si possono aggiungere lune
	 * 
	 */
	public double controllaDistanza (Vettore v1, Vettore v2) {
		
		return Math.hypot((v2.getAsseX()-v1.getAsseX()), (v2.getAsseY()-v1.getAsseY()));
	}
	
	
	/**
	 * 
	 * @param v1 primo punto
	 * @param v2 secondo punto
	 * @return ritorna Vero se i punti sono sovrapposti. Ritorna Falso se i punti non sono sovrapposti
	 */
	public boolean isSovrapposto (Vettore v1, Vettore v2) {
		if (v1.getAsseX()==v2.getAsseX() && v1.getAsseY()==v2.getAsseY()) {
			return true;
		}else{
			return false;
		}
		
	}

}
