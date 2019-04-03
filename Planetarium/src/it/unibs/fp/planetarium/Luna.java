package it.unibs.fp.planetarium;

public class Luna {
	
	private String codice;
	private Vettore posizione;
	private double massa;
	
	public Luna(String _codice, Vettore _posizione, double _massa) {
		this.codice = _codice;
		this.posizione = _posizione;
		this.massa = _massa;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public Vettore getPosizione() {
		return posizione;
	}
	
	public double getMassa() {
		return massa;
	}
	

}
