package it.unibs.fp.planetarium;

public class Luna {
	
	private String codice;
	private double posizione;
	private double massa;
	
	public Luna(String _codice, double _posizione, double _massa) {
		this.codice = _codice;
		this.posizione = _posizione;
		this.massa = _massa;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public double getPosizione() {
		return posizione;
	}
	
	public double getMassa() {
		return massa;
	}
	

}
