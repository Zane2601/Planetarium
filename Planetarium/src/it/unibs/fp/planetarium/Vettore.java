package it.unibs.fp.planetarium;

public class Vettore {
	
	private double asseX;
	private double asseY;
	
	public Vettore (double asseX, double asseY) {
		this.asseX = asseX;
		this.asseY = asseY;
	}
	
	public double getAsseX() {
		return asseX;
	}
	public double getAsseY() {
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
	
	
	@Override
	public String toString() {
		return "Vettore [asseX=" + asseX + ", asseY=" + asseY + "]";
	}

	/**
	 * 
	 * @param v1 primo punto
	 * @param v2 secondo punto
	 * @return ritorna Vero se i punti sono sovrapposti. Ritorna Falso se i punti non sono sovrapposti
	 */
	public static boolean isSovrapposto (Vettore v1, Vettore v2) {
		if (v1.getAsseX()==v2.getAsseX() && v1.getAsseY()==v2.getAsseY()) {
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param v1 posizione del primo corpo celeste o del centro di massa calcolato precedentemente
	 * @param v2 posizione secondo corpo celeste
	 * @param massa1 
	 * @param massa2
	 * @return ritorna la posizione del centro di massa
	 */
	public static Vettore centroMassa (Vettore v1, Vettore v2, double massa1, double massa2) {
		double asseX;
		double asseY;
		
		asseX = (massa1 * v1.getAsseX() + massa2 * v2.getAsseX())/(massa1+massa2);
		asseY = (massa1 * v1.getAsseY() + massa2 * v2.getAsseY())/(massa1+massa2);
		
		Vettore posCentroMassa = new Vettore (asseX, asseY);
		
		return posCentroMassa;
		
	}

}
