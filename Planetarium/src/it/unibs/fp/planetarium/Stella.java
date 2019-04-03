package it.unibs.fp.planetarium;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Stella {
	
	private static final String RICHIESTA_MASSA_SOLE = "Inserisci la massa della stella: ";
	private static final String RICHIESTA_NOME_SOLE = "\nInserisci il nome della stella: ";
	private static final String BENVENUTO_CREA_SOLE = "Per iniziare, crea la stella del tuo sistema.\n\tNe potrai creare solo una!";
	
	
	
	private String codice;
	private Vettore posizione = new Vettore(0,0);
	private double massa;
	public static ArrayList<Pianeta> listaPianeti = new ArrayList<Pianeta>();
	
	
	public Stella(String _codice, double _massa, Vettore _posizione, ArrayList _listaPianeti) {
		this.codice = _codice;
		this.massa = _massa;
		this.posizione = _posizione;
		this.listaPianeti = _listaPianeti;
	}
	
	public String getCodice(){
		return codice;
	}
	
	public double getMassa() {
		return massa;
	}
	
	public Vettore getPosizione() {
		return posizione;
	}
	
	public ArrayList getPianeti() {
		return listaPianeti;
	}
	
	
	public static void addPianeta(Pianeta pianeta, Stella stella) {
		Stella.listaPianeti.add(pianeta);
	}
	
	public static Stella creaSole() {
		System.out.println(BENVENUTO_CREA_SOLE);
		String nomeSole = InputDati.leggiStringa(RICHIESTA_NOME_SOLE);
		Double massaSole = InputDati.leggiDouble(RICHIESTA_MASSA_SOLE);
		Vettore posizione = new Vettore(0,0);
		ArrayList listaPianeti = new ArrayList<>();
		return new Stella(nomeSole, massaSole, posizione, listaPianeti);
	}
	
	public static void mostraPianeti(ArrayList list) {	
		System.out.println("I pianeti contenuti in questo sistema sono:\n");
		System.out.println(list);
	}

	
	

}

