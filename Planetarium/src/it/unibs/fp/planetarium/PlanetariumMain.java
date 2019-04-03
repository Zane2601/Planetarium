package it.unibs.fp.planetarium;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import java.util.ArrayList;

public class PlanetariumMain {

    private static final String RICHIESTA_PIANETA_ELIMINA = "Inserisci il pianeta da eliminare: ";
	private static final String PIANETA_NON_TROVATO_MOSTRA = "Il pianeta non esiste. Non puoi mostrare le sue lune!";
	private static final String RICHIESTA_PIANETA_MOSTRA_LUNE = "Di quale pianeta vuoi visualizzare le lune? ";
	private static final String RICHIESTA_MOSTRA_LUNE = "Stai per visualizzare le lune di un pianeta";
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
            "Mostra il centro di massa del sistema",
            "Cerca un pianeta"
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
                	Luna l1 = Luna.creaLuna(sole);
                	Pianeta.addLuna(l1, p);
                	p = null;
                	// Vettore cdmGen = Vettore.centroMassa(cdm.get, sole.getPosizione(), p.getMassa(), sole.getMassa());
                }
                
                break;
            
            case 2:
            	Pianeta pianetaDaAssociare = null;
            	String pianetaPerLunaString = null;
            	
                System.out.println(BENVENUTO_CREA_LUNA);
                pianetaPerLunaString = InputDati.leggiStringa(RICHIESTA_PIANETA_PER_LUNA);
                pianetaDaAssociare = Pianeta.cercaPianeta(pianetaPerLunaString);
                
                
                
                if (pianetaDaAssociare != null) {
                	System.out.println("Puoi creare la luna");
        			Luna l = Luna.creaLuna(sole);
        			Pianeta.addLuna(l, pianetaDaAssociare);
                	
                		}else {
                			System.out.println("Non puoi creare una luna per questo pianeta inesistente");
                		}
                
                
                
                break;
            case 3:
            	Pianeta pianetaDaEliminare = null;
            	
                
                String pianetaDaEliminareString = InputDati.leggiStringa(RICHIESTA_PIANETA_ELIMINA);
                pianetaDaEliminare = Pianeta.cercaPianeta(pianetaDaEliminareString);
                
                
                
                if (pianetaDaEliminare != null) {
                	Pianeta.eliminaPianeta(pianetaDaEliminare);
                	System.out.println("Il pianeta " + pianetaDaEliminareString + " è stato eliminato correttamente");
                		}else {
                			System.out.println("Il pianeta non esiste. Non puoi eliminare un pianeta inesistente");
                		}
                break;
            case 4:
            	Luna lunaDaEliminare = null;
            	Pianeta pianetaDaCuiEliminare = null;
            	
                
                String pianetaDaCuiEliminareString = InputDati.leggiStringa("Inserisci il pianeta da cui vuoi rimuovere una luna: ");
                pianetaDaCuiEliminare = Pianeta.cercaPianeta(pianetaDaCuiEliminareString);
                
                String lunaDaEliminareString = InputDati.leggiStringa("Inserisci la luna che vuoi rimuovere una luna: ");
                lunaDaEliminare = Luna.cercaLuna(lunaDaEliminareString);
                
                if (lunaDaEliminare != null) {
                	Luna.eliminaLuna(lunaDaEliminare);
                	System.out.println("Il satellite " + lunaDaEliminareString + " è stato eliminato correttamente");
                		}else {
                			System.out.println("La luna non esiste. Non puoi eliminare una luna inesistente");
                		}
                break;
            case 5:
            	Stella.mostraPianeti(sole.listaPianeti);
                    break;
            case 6:
            	Pianeta pianetaDaAssociareMostra = null;
            	String pianetaPerLunaMostraString = null;
            	
                System.out.println(RICHIESTA_MOSTRA_LUNE);
                pianetaPerLunaMostraString = InputDati.leggiStringa(RICHIESTA_PIANETA_MOSTRA_LUNE);
                pianetaDaAssociareMostra = Pianeta.cercaPianeta(pianetaPerLunaMostraString);
            	
                if (pianetaDaAssociareMostra != null) {
                	Pianeta.mostraLuna(pianetaDaAssociareMostra.listaLune);
                	
                		}else {
                			System.out.println(PIANETA_NON_TROVATO_MOSTRA);
                		}
            	
                
                    break;
            case 7:
            	// System.out.println("Il centro di massa del sistema ï¿½: " + cdm);
            	break;
            
            case 8:
            	Pianeta pianetaDaCercare = null;
            	String pianetaDaCercareString = null;
            	
                
                pianetaDaCercareString = InputDati.leggiStringa("Inserisci il pianeta da cercare: ");
                pianetaDaCercare = Pianeta.cercaPianeta(pianetaDaCercareString);
                
                
                
                if (pianetaDaCercare != null) {
                	System.out.println("Il pianeta esiste");
        
                		}else {
                			System.out.println("Il pianeta non esiste");
                		}
                
            	break;
            default:
                break;
            }
           
        } while (scelta != 0);
    }
}