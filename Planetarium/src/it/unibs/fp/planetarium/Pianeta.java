package it.unibs.fp.planetarium;

import java.util.LinkedList;

public class Pianeta {
	
	private String codice;
	private double posizione;
	private double massa;
	private LinkedList Luna[];
	
	public Pianeta(String _codice, double _posizione, double _massa) {
		this.codice=_codice;
		this.posizione=_posizione;
		this.massa=_massa;
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
	
	public LinkedList[] getLune(){
		return Luna;
	}

}
