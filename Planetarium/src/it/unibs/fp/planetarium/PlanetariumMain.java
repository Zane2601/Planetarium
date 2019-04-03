package it.unibs.fp.planetarium;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import java.util.LinkedList;

public class PlanetariumMain {
	//ccommento prova

    private static final String RICHIESTA_PIANETA_PER_LUNA = "A quale pianeta vuoi assegnare la luna che stai per creare?";
	private static final String RICHIESTA_POSIZIONE_CORPO_CELESTE = "Inserisci la posizione del corpo celeste rispetto alla stella (0, 0): ";
    private static final String RICHIESTA_MASSA_CORPO_CELESTE = "Inserisci la massa del corpo celeste: ";
    private static final String RICHIESTA_NOME_CORPO_CELESTE = "Inserisci il nome del corpo celeste: ";
    private static final String BENVENUTO_CREA_LUNA = "Stai per creare una nuova luna";
    private static final String BENVENUTO_CREA_PIANETA = "Stai per creare un nuovo pianeta";
   
    private static final String TITOLO_MENU = "Scegli un'azione";
    private static final String [] VOCI_MENU = {
            "Crea un pianeta",
            "Crea una luna",
            "Elimina un pianeta",
            "Elimina una luna",
            "Mostra tutti i pianeti",
            "Mostra tutte le lune (dovrai selezionare un pianeta)"
    };
    private static final String SALUTO_INIZIALE = "Benvenuto in Planetarium!";

   
    //*************************************************************************************
    public static void main(String[] args) {
        int scelta = 0;
        int i = 0;
        int j = 0;
       
       
        System.out.println(SALUTO_INIZIALE);
       
        Stella sole = Stella.creaSole();
       
        mostraMenu(sole);
   
   
    }
    //**************************************************************************************



    private static void mostraMenu(Stella sole) {
        int scelta;
        MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU);
       
        do {
   
            scelta = menu.scegli();
            switch (scelta) {
            case 1:
                System.out.println(BENVENUTO_CREA_PIANETA);
                Pianeta p = creaPianeta(sole);
               
               
                //stampa del centro di massa ogni volta, tra pianeta p e sole
                Vettore cdm = Vettore.centroMassa(p.getPosizione(), sole.getPosizione(), p.getMassa(), sole.getMassa());
                System.out.println("Il centro di massa del sistema è: " +cdm);
               
                Stella.addPianeta(p, sole);
                break;
            
            case 2:
                System.out.println(BENVENUTO_CREA_LUNA);
                String pianetaPerLunaString = InputDati.leggiStringa(RICHIESTA_PIANETA_PER_LUNA);

               
                Luna l = creaLuna(sole);
                //Luna.addLuna(l, pianetaPerLuna);
                break;
            case 3:
            //    eliminaPianeta();
                break;
            case 4:
            //    eliminaLuna();
                break;
            case 5:
            	Stella.mostraPianeti(sole.listaPianeti);
                    break;
            case 6:
                //    eliminaLuna();
                    break;
            default:
                break;
            }
           
        } while (scelta != 0);
    }
   
   
   
   
   
   
    public static Pianeta creaPianeta(Stella stella) {
       
        String codice = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
        Vettore posizione = null;
        do {
            posizione = leggiPosizione();   
        } while (Vettore.isSovrapposto(stella.getPosizione(), posizione));
       
       
        Double massa = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
        LinkedList listaLune = new LinkedList<>();
       
        return new Pianeta(codice, posizione, massa, listaLune);
    }
   
   
    public static Luna creaLuna(Stella stella) {
        
        String codice = InputDati.leggiStringa(RICHIESTA_NOME_CORPO_CELESTE);
        Vettore posizione = null;
        do {
            posizione = leggiPosizione();   
        } while (Vettore.isSovrapposto(stella.getPosizione(), posizione));
       
       
        Double massa = InputDati.leggiDouble(RICHIESTA_MASSA_CORPO_CELESTE);
       
       
        return new Luna(codice, posizione, massa);
    }
    
    

    

    public static Vettore leggiPosizione() {
        System.out.println(RICHIESTA_POSIZIONE_CORPO_CELESTE);
        Double x = InputDati.leggiDouble("x = ");
        Double y = InputDati.leggiDouble("y = ");
        return new Vettore(x, y);
    }

}