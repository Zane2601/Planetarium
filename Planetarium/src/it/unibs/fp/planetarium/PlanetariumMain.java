package it.unibs.fp.planetarium;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class PlanetariumMain {

	private static final String RICHIESTA_MASSA_SOLE = "Inserisci la massa del sole: ";
	private static final String RICHIESTA_NOME_SOLE = "Inserisci il nome del sole: ";
	private static final String BENVENUTO_CREA_SOLE = "Per iniziare, crea il sole del tuo sistema.\n Ne potrai creare solo uno!";
	private static final String TITOLO_MENU = "Scegli un'azione";
	private static final String [] VOCI_MENU = {
			"Crea un pianeta",
			"Crea una luna",
			"Elimina un pianeta",
			"Elimina una luna"
	};
	private static final String SALUTO_INIZIALE = "Benvenuto in Planetarium!";

	public static void main(String[] args) {
		int scelta = 0;
		int i = 0;
		int j = 0;
		Stella sole = creaSole();
		
		System.out.println(SALUTO_INIZIALE);
		
		
		
		
		
		MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU);
		
		do {
	
			scelta = menu.scegli();
			switch (scelta) {
			case 1:
				creaPianeta();
				break;
			case 2:
				creaLuna();
				break;
			case 3:
				eliminaPianeta();
				break;
			case 4:
				eliminaLuna();
				break;
			default:
				break;
			}
			
		} while (scelta != 0);
		
	}
	
	
	public static CorpoCeleste creaSole() {
		System.out.println(BENVENUTO_CREA_SOLE);
		String nomeSole = InputDati.leggiStringa(RICHIESTA_NOME_SOLE);
		Double massaSole = InputDati.leggiDouble(RICHIESTA_MASSA_SOLE);		
	}

}
