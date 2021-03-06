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
	
	public Pianeta(String _codice, Vettore _posizione, double _massa, ArrayList<Luna> _listaLune) {
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
	
	
	public ArrayList<Luna> getListaLune() {
		return listaLune;
	}
	
	public static void addLuna(Luna luna, Pianeta pianeta) {
		Pianeta.listaLune.add(luna);
	}

	@Override
	public String toString() {
		return "\n[codice = " + codice + "]";
	}

	/*public static Pianeta creaPianeta(Stella stella) {
	       
        String codice = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
        Vettore posizione = null;
        do {
            posizione = Vettore.leggiPosizione();   
        } while (Vettore.isSovrapposto(stella.getPosizione(), posizione));
       
       
        Double massa = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
        ArrayList<Luna> listaLune = new ArrayList<Luna>();
       
        return new Pianeta(codice, posizione, massa, listaLune);
    }*/
	
public static Luna creaLuna(Stella stella) {
        
        String codice = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
        Vettore posizione = null;
        //posizione = Vettore.leggiPosizione();
        
        
        
        
        /*for (int i = 0; i < Stella.listaPianeti.size(); i++) {
			if (Vettore.isSovrapposto(stella.listaPianeti.get(i).getPosizione(), posizione)) {
				System.out.println(LUNA_SOVRAPPOSTA);
				posizione = Vettore.leggiPosizione();
			}
		}*/
		
        
        
        
        do {
            posizione = Vettore.leggiPosizione();   
        } while (Vettore.isSovrapposto(stella.getPosizione(), posizione) || Vettore.isStessoPunto(stella, posizione));
       
       
        Double massa = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
        
       
        return new Luna(codice, posizione, massa);
    }
	
	public static Pianeta cercaPianeta(String pianetaCercato) {
		Pianeta pianeta = null;
		int i = 0;
		
		do {
			if (Stella.listaPianeti.get(i).getCodice().equals(pianetaCercato))
				return Stella.listaPianeti.get(i);
			i++;
		} while (i < Stella.listaPianeti.size());

		 
		return pianeta;
	}
	
	public static void mostraLuna(ArrayList<Luna> listaLune) {	
		System.out.println("Le lune contenute in questo pianeta sono:\n");
		
		
		System.out.println(listaLune);
	}

	
	
	public static void eliminaPianeta(Pianeta pianetaDaRimuovere) {
		Stella.listaPianeti.remove(pianetaDaRimuovere);
	}
}
