package it.unibs.fp.planetarium;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import java.util.ArrayList;

public class PlanetariumMain {

    private static final String RICHIESTA_CREAZIONE_LUNA = "Questo pianeta ha delle lune?";
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
            "Mostra tutte le lune (dovrai selezionare un pianeta)",
            "Mostra il centro di massa del sistema"
    };
    private static final String SALUTO_INIZIALE = "Benvenuto in Planetarium!";

   
    //*************************************************************************************
    public static void main(String[] args) {
       
       
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
                Pianeta p = Pianeta.creaPianeta(sole);
               
               
                //stampa del centro di massa ogni volta, tra pianeta p e sole
                Vettore cdm = Vettore.centroMassa(p.getPosizione(), sole.getPosizione(), p.getMassa(), sole.getMassa());
               
                               
                Stella.addPianeta(p, sole);
                
                boolean sceltaCreaLuna = InputDati.yesOrNo(RICHIESTA_CREAZIONE_LUNA);
                if (sceltaCreaLuna) {
                	Luna.creaLuna(sole);
                	// Vettore cdmGen = Vettore.centroMassa(cdm.get, sole.getPosizione(), p.getMassa(), sole.getMassa());
                }
                
                break;
            
            case 2:
            	Pianeta pianetaDaAssociare = null;
            	
                System.out.println(BENVENUTO_CREA_LUNA);
                String pianetaPerLunaString = InputDati.leggiStringa(RICHIESTA_PIANETA_PER_LUNA);
                pianetaDaAssociare = Pianeta.cercaPianeta(pianetaPerLunaString);
                
               
               Luna l = Luna.creaLuna(sole);
               Pianeta.addLuna(l, pianetaDaAssociare);

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
            	Pianeta pianetaDaAssociareLuna = null;
            	
                String pianetaPerCercaLunaString = InputDati.leggiStringa(RICHIESTA_PIANETA_PER_LUNA);
                pianetaDaAssociareLuna = Pianeta.cercaPianeta(pianetaPerCercaLunaString);
                Pianeta.mostraLuna(pianetaDaAssociareLuna.listaLune);
                    break;
            case 7:
            	// System.out.println("Il centro di massa del sistema �: " + cdm);
            default:
                break;
            }
           
        } while (scelta != 0);
    }
    
    
   
   
    
    
    

}