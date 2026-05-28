package Schazsuche;

import java.util.Random;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare der einzelnen Methoden!
 * Fuegen Sie Code, insbesondere weitere Methoden, hinzu!
 * Aendern Sie vom vorhandenen Code nur die return-Anweisungen
 ****************************************************************************************************** */

public class Spielfeld {
	private boolean[][] schatzkarte;
	
	/* Offenes Spielfeld: Bedeutung der Zahlen 
	 * -2: Stelle ist aufgedeckt. Mind. ein Schatz grenzt an.
	 * -1: Stelle ist aufgedeckt. Kein Schatz hier oder angrenzend.
	 * 0: Stelle ist nicht aufgedeckt
	 * 1: Stelle ist aufgedeckt. Spieler 1 hat hier einen Schatz gefunden
	 * 2: Stelle ist aufgedeckt. Spieler 2 hat hier einen Schatz gefunden*/
	private int[][] offenesSpielfeld;
	private static Random rd = new Random();
	private int n;
	
	/* NICHT AENDERN!
	 * Sie koennen diesen Konstruktor verwenden, muessen aber nicht.
	 * Der Konstruktor ist zu Testzwecken vorhanden. */
	public Spielfeld(boolean[][] schatzkarte, int[][] offenesSpielfeld) {
		n = schatzkarte.length;
		this.schatzkarte = schatzkarte;
		this.offenesSpielfeld = offenesSpielfeld;
		initialisiereSpielfeld();
	}
		
	/* Attribut n setzen, Felder erstellen, Spielfeld initialisieren.
	 * Dafuer Methode initialisiereSpielfeld() verwenden.*/
	public Spielfeld(int n) {
		// TODO
		this.n=n;
		schatzkarte = new boolean[n][n];
	    offenesSpielfeld = new int[n][n];
	    initialisiereSpielfeld();
		// Anweisungen hinzufuegen
	}	
	
	
	/* Versteckt n viele Schaetze im Feld schatzkarte.
	 * Die n unterschiedlichen (!) Stellen werden zufaellig ausgewaehlt.*/
	private void initialisiereSpielfeld() {
		// TODO
		int anzahl=0;
		
		while (anzahl<n) {
			int z = rd.nextInt(n);
				int	s = rd.nextInt(n);
					if (schatzkarte[z][s] == false) {
						schatzkarte[z][s] = true;
						anzahl++;
					}
		}
		// Anweisungen hinzufuegen
	}
	
	/* NICHT AENDERN!
	 * Sie koennen diese Methode verwenden, muessen aber nicht.
	 * Die Methode ist zu Testzwecken vorhanden. */
	public boolean[][] getSchatzkarte() {
		return schatzkarte;
	}
	
	/* NICHT AENDERN!
	 * Sie koennen diese Methode verwenden, muessen aber nicht.
	 * Die Methode ist zu Testzwecken vorhanden. */
	public int getOffenesSpielfeld(int zeile, int spalte) {
		return offenesSpielfeld[zeile][spalte];
	}
	
	/* Getter-Methode fuer Attribut n */
	public int getN() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return n;
	}
	
	/* Gibt true zurueck, wenn es sich um eine gueltige Eingabe handelt, false sonst.
	 * Gueltig bedeuetet, dass es sich um existierende Koordinaten handelt
	 * und dass das offene Spielfeld an der Stelle eine 0 enthaelt.*/
	public boolean gueltigeEingabe(int zeile, int spalte) {
		// TODO

	    if (zeile >= 0 && zeile < n &&
	        spalte >= 0 && spalte < n &&
	        offenesSpielfeld[zeile][spalte] == 0) {

	        return true;
	    }

	
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return false;
	}
	
	/* Gibt true zurueck, wenn sich an der Stelle (zeile,spalte) ein Schatz befindet,
	 * false sonst.
	 * Es ist sichergestellt, dass die Methode nur mit gueltigen Werten aufgerufen wird. */
	public boolean treffer(int zeile, int spalte) {
		// TODO
		if(schatzkarte[zeile][spalte]==true) {
			return true;
		}
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return false;
	}
	
	/* Gibt true zurueck, wenn sich angrenzend (darunter, darueber, rechts, links) 
	 * der Stelle (zeile, spalte) ein Schatz befindet,
	 * false sonst. 
	 * Es ist sichergestellt, dass die Methode nur mit gueltigen Werten aufgerufen wird. */
	public boolean angrenzend(int zeile, int spalte) {
		// TODO
		 if (zeile > 0 && schatzkarte[zeile - 1][spalte]) {
		        return true;
		    }

		    if (zeile < n - 1 && schatzkarte[zeile + 1][spalte]) {
		        return true;
		    }

		    if (spalte > 0 && schatzkarte[zeile][spalte - 1]) {
		        return true;
		    }

		    if (spalte < n - 1 && schatzkarte[zeile][spalte + 1]) {
		        return true;
		    }
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return false;		
	}
	
	/* Deckt eine Stelle im Spielfeld auf. 
	 * Es ist bereits sichergestellt, dass Zeile und Spalte gueltige Eingaben sind.
	 * Die Stelle enthaelt einen Schatz, es befindet sich mind. ein Schatz angrenzend oder 
	 * es befindet sich kein Schatz in der Naehe.
	 * Gibt den passenden String zurueck UND
	 * aendert offenesSpielfeld an einer Stelle. 
	 * Methoden treffer() und angrenzend() verwenden. */
	public String deckeAuf(int zeile, int spalte, Spieler s) {
		/* Geben Sie unbedingt einen dieser Strings zurueck.
		 * Keine eigenen Rueckgabe-Strings erstellen! */ 
		String schatz = "Schatz gefunden! Punkt fuer " + s.getName() + "!";
		String schatzAngrenzend = "Ein Schatz befindet sich in mind. einem angrenzenden Feld.";
		String keinSchatz = "Kein Schatz in der Naehe.";
		
		// TODO
		if(treffer(zeile,spalte)){
			offenesSpielfeld[zeile][spalte] = s.getSpielernummer();
			 s.setPunkte(s.getPunkte() + 1);
			    return schatz;
		}else if (angrenzend(zeile, spalte)) {
		    offenesSpielfeld[zeile][spalte] = -2;
		    return schatzAngrenzend;
		} else {
		    offenesSpielfeld[zeile][spalte] = -1;
		    return keinSchatz;
		}
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern	
		
	}
	
	/* Gibt einen String zurueck, der das Feld offenesSpielfeld 
	 * gemaess den Vorgaben fuer die Ausgabe auf der Konsole uebersetzt.
	 * Denken Sie daran, die Zeilen- und Spaltennummern (je 0 bis n-1) einzufuegen.
	 * Die Darstellung von offenesSpielfeld ist wie folgt:
	 * -2 wird zu '?', -1 wird zu 'X', 0 wird zu '_', 1 wird zu 'S1', 2 wird zu 'S2' */
	public String toString() {
		// TODO
		 String text = "  ";

		    for (int i = 0; i < n; i++) {
		        text += i + " ";
		    }

		    text += "\n";

		    for (int i = 0; i < n; i++) {
		        text += i + " ";

		        for (int j = 0; j < n; j++) {
		            if (offenesSpielfeld[i][j] == -2) {
		                text += "? ";
		            } else if (offenesSpielfeld[i][j] == -1) {
		                text += "X ";
		            } else if (offenesSpielfeld[i][j] == 0) {
		                text += "_ ";
		            } else if (offenesSpielfeld[i][j] == 1) {
		                text += "S1 ";
		            } else if (offenesSpielfeld[i][j] == 2) {
		                text += "S2 ";
		            }
		        }

		        text += "\n";
		    }

		    return text;
		}}