package it.unibs.fp.planetarium;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class PlanetariumMain {

	private static final String RICHIESTA_POSIZIONE_CORPO_CELESTE = "Inserisci la poszione del corpo celeste rispetto alla stella (0, 0): ";
	private static final String RICHIESTA_MASSA_CORPO_CELESTE = "Inserisci la massa del corpo celeste: ";
	private static final String RICHIESTA_NOME_CORPO_CELESTE = "Inserisci il nome del corpo celeste: ";
	private static final String BENVENUTO_CREA_LUNA = "Stai per creare una nuova luna";
	private static final String BENVENUTO_CREA_PIANETA = "Stai per creare un nuovo pianeta";
	
	private static final String TITOLO_MENU = "Scegli un'azione";
	private static final String [] VOCI_MENU = {
			"Crea un pianeta",
			"Crea una luna",
			"Elimina un pianeta",
			"Elimina una luna"
	};
	private static final String SALUTO_INIZIALE = "Benvenuto in Planetarium!";

	
	//*************************************************************************************
	public static void main(String[] args) {
		int scelta = 0;
		int i = 0;
		int j = 0;
		
		
		System.out.println(SALUTO_INIZIALE);
		
		Stella sole = Stella.creaSole();
		
		mostraMenu();
	
	
	}
	//**************************************************************************************



	private static void mostraMenu() {
		int scelta;
		MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU);
		
		do {
	
			scelta = menu.scegli();
			switch (scelta) {
			case 1:
				System.out.println(BENVENUTO_CREA_PIANETA);
				creaCorpoCeleste();
				
				break;
			case 2:
				System.out.println(BENVENUTO_CREA_LUNA);
				Stella p = creaCorpoCeleste();
				break;
			case 3:
		//		eliminaPianeta();
				break;
			case 4:
			//	eliminaLuna();
				break;
			default:
				break;
			}
			
		} while (scelta != 0);
	}
	
	
	
	
	
	
	public static Pianeta creaCorpoCeleste() {
		Vettore posizione = null;
		String nomeCorpoCeleste = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
		Double massaCorpoCeleste = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
		
		posizione = leggiPosizione();
		
		return new Pianeta(nomeCorpoCeleste, massaCorpoCeleste, posizione);
	}
	

	public static Vettore leggiPosizione() {
		System.out.println(RICHIESTA_POSIZIONE_CORPO_CELESTE);
		Double x = InputDati.leggiDouble("x = ");
		Double y = InputDati.leggiDouble("y = ");
		return new Vettore(x, y);
	}

}
