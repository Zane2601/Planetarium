package it.unibs.fp.planetarium;

import it.unibs.fp.mylib.InputDati;

public class Luna {
	
	private static final String RICHIESTA_MASSA_CORPO_CELESTE = "Inserisci la massa del corpo celeste: ";
    private static final String RICHIESTA_NOME_CORPO_CELESTE = "Inserisci il nome del corpo celeste: ";
    private static final String LUNA_SOVRAPPOSTA = "Posizione già occupata, inserire altra posizione";
    
	
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
	
/*public static Luna creaLuna(Stella stella) {
        
        String codice = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
        Vettore posizione = null;
        //posizione = Vettore.leggiPosizione();
        
        
        
        
        for (int i = 0; i < Stella.listaPianeti.size(); i++) {
			if (Vettore.isSovrapposto(stella.listaPianeti.get(i).getPosizione(), posizione)) {
				System.out.println(LUNA_SOVRAPPOSTA);
				posizione = Vettore.leggiPosizione();
			}
		}
		
        
        
        
        do {
            posizione = Vettore.leggiPosizione();   
        } while (Vettore.isSovrapposto(stella.getPosizione(), posizione) || Vettore.isStessoPunto(stella, posizione));
       
       
        Double massa = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
        
       
        return new Luna(codice, posizione, massa);
    }*/

@Override
public String toString() {
	return "Luna [codice=" + codice + "]";
}
	


public static Luna cercaLuna(String lunaCercata) {
	Luna luna = null;
	int i = 0;
	
	do {
		if (Pianeta.listaLune.get(i).getCodice().equals(lunaCercata))
			return Pianeta.listaLune.get(i);
		i++;
	} while (i < Stella.listaPianeti.size());

	if (i>Stella.listaPianeti.size())
		System.out.println("Il pianeta cercato non esiste"); 
	
	
			
	return luna;
}
	

public static void eliminaLuna(Luna lunaDaRimuovere) {
	Pianeta.listaLune.remove(lunaDaRimuovere);
}
}
