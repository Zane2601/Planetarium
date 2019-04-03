package it.unibs.fp.planetarium;

import java.util.ArrayList;
import java.util.LinkedList;

import it.unibs.fp.mylib.InputDati;

public class Vettore {
	
	private static final String RICHIESTA_POSIZIONE_CORPO_CELESTE = "Inserisci la posizione del corpo celeste rispetto alla stella (0, 0): ";
    private static final String CORPO_CELESTE_SOVRAPPOSTO = "Posizione già occupata, inserire altra posizione";

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
	public static double controllaDistanza (Vettore v1, Vettore v2) {
		
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
	
	public static boolean isStessoPunto (Stella stella, Vettore pos) {
		for (int i = 0; i < Stella.listaPianeti.size(); i++) {
			if (Vettore.isSovrapposto(stella.listaPianeti.get(i).getPosizione(), pos)) {
				System.out.println(CORPO_CELESTE_SOVRAPPOSTO);
				//pos = Vettore.leggiPosizione();
				return true;
			}else {
				return false;
			}
		}
		return false;
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
	
	public static Vettore leggiPosizione() {
        System.out.println(RICHIESTA_POSIZIONE_CORPO_CELESTE);
        Double x = InputDati.leggiDouble("x = ");
        Double y = InputDati.leggiDouble("y = ");
        return new Vettore(x, y);
        
        
    }
	
	
	
	public static Vettore centroMassa (Stella stella) {
		double asseX;
		double asseY;
		double massaTot = stella.getMassa();
		double prodottoTotMassaAsseX = 0;
		double prodottoTotMassaAsseY = 0;
		ArrayList<Pianeta> pianetiList = stella.listaPianeti;
		
		//calcola la massa totale
		for (int i = 0; i < pianetiList.size(); i++) {
			ArrayList<Luna> luneList = stella.listaPianeti.get(i).listaLune;
			for (int j = 0; j < luneList.size(); j++) {
				massaTot = massaTot + luneList.get(j).getMassa();
				}
			massaTot = massaTot + pianetiList.get(i).getMassa();
		}
		
		for (int i = 0; i < pianetiList.size(); i++) {
			ArrayList<Luna> luneList = stella.listaPianeti.get(i).listaLune;
			for (int j = 0; j < luneList.size(); j++) {
				
				prodottoTotMassaAsseX = prodottoTotMassaAsseX + luneList.get(j).getPosizione().getAsseX() * luneList.get(j).getMassa();
				prodottoTotMassaAsseY = prodottoTotMassaAsseY + luneList.get(j).getPosizione().getAsseY() * luneList.get(j).getMassa();

			}
			
			prodottoTotMassaAsseX = prodottoTotMassaAsseX + pianetiList.get(i).getPosizione().getAsseX() * pianetiList.get(i).getMassa();
			prodottoTotMassaAsseY = prodottoTotMassaAsseY + pianetiList.get(i).getPosizione().getAsseY() * pianetiList.get(i).getMassa();

		}
		
		asseX = prodottoTotMassaAsseX / massaTot;
		asseY = prodottoTotMassaAsseY / massaTot;
		
		Vettore posCentroMassa = new Vettore (asseX, asseY);
		
		return posCentroMassa;
		
	}
	

}
