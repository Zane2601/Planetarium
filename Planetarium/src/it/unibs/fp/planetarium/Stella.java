package it.unibs.fp.planetarium;

import java.util.LinkedList;

public class Stella {
	
	
	
	private String codice;
	private static Vettore posizione = new Vettore(0,0);
	private double massa;
	private LinkedList pianeta[];
	
	public Stella(String _codice, double _massa) {
		this.codice = _codice;
		this.massa = _massa;
	}
	
	public String getCodice(){
		return codice;
	}
	
	public double getMassa() {
		return massa;
	}
	
	public LinkedList[] getPianeti() {
		return pianeta;
	}
	
	public void addpianeta() {
		
	}

}
