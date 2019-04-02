package it.unibs.fp.planetarium;

import java.util.LinkedList;

import it.unibs.fp.mylib.InputDati;

public class Stella {
	
	private static final String RICHIESTA_MASSA_SOLE = "Inserisci la massa del sole: ";
	private static final String RICHIESTA_NOME_SOLE = "\nInserisci il nome del sole: ";
	private static final String BENVENUTO_CREA_SOLE = "Per iniziare, crea il sole del tuo sistema.\n\tNe potrai creare solo uno!";
	
	
	
	private String codice;
	private Vettore posizione = new Vettore(0,0);
	private double massa;
	private LinkedList pianeta[];
	
	public Stella(String _codice, double _massa, Vettore _posizione) {
		this.codice = _codice;
		this.massa = _massa;
		this.posizione = _posizione;
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
	
	public static Stella creaSole() {
		System.out.println(BENVENUTO_CREA_SOLE);
		String nomeSole = InputDati.leggiStringa(RICHIESTA_NOME_SOLE);
		Double massaSole = InputDati.leggiDouble(RICHIESTA_MASSA_SOLE);
		Vettore posizione = new Vettore(0,0);
		return new Stella(nomeSole, massaSole, posizione);
	}

}

