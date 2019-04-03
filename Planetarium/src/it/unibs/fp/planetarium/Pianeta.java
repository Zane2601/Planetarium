package it.unibs.fp.planetarium;


import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Pianeta {
	
	private static final String RICHIESTA_MASSA_CORPO_CELESTE = "Inserisci la massa del corpo celeste: ";
    private static final String RICHIESTA_NOME_CORPO_CELESTE = "Inserisci il nome del corpo celeste: ";
    
	
	private String codice;
	private Vettore posizione;
	private Double massa;
	public static ArrayList<Luna> listaLune = new ArrayList<Luna>();
	
	public Pianeta(String _codice, Vettore _posizione, double _massa, ArrayList _listaLune) {
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
	
	
	public ArrayList getPianeti() {
		return listaLune;
	}
	
	public static void addLuna(Luna luna, Pianeta pianeta) {
		Pianeta.listaLune.add(luna);
	}

	@Override
	public String toString() {
		return "\n[codice = " + codice + "]";
	}

	public static Pianeta creaPianeta(Stella stella) {
	       
        String codice = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
        Vettore posizione = null;
        do {
            posizione = Vettore.leggiPosizione();   
        } while (Vettore.isSovrapposto(stella.getPosizione(), posizione));
       
       
        Double massa = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
        ArrayList listaLune = new ArrayList<Luna>();
       
        return new Pianeta(codice, posizione, massa, listaLune);
    }

	
}
