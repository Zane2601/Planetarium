package it.unibs.fp.planetarium;


import java.util.LinkedList;

public class Pianeta {
	
	private String codice;
	private Vettore posizione;
	private Double massa;
	public static LinkedList<Luna> listaLune = new LinkedList<Luna>();
	
	public Pianeta(String _codice, Vettore _posizione, double _massa, LinkedList _listaLune) {
		this.codice= _codice;
		this.posizione = _posizione;
		this.massa=_massa;
		this.listaLune = _listaLune;
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
	
	
	public LinkedList getPianeti() {
		return listaLune;
	}
	
	public static void addLuna(Luna luna, Pianeta pianeta) {
		Pianeta.listaLune.addLast(luna);
	}

	@Override
	public String toString() {
		return "\n[codice = " + codice + "]";
	}

	

	
}
