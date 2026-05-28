package Schazsuche;

import java.util.Scanner;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare!
 * Fuegen Sie Code hinzu!
 * Aendern Sie vom vorhandenen Code nur return-Anweisungen!
 ****************************************************************************************************** */

public class Spiel {
	
	/* Verwenden Sie unbedingt diese Klassenattribute in den Methoden der Klasse! */
	private static Scanner sc = new Scanner(System.in);
	public static Spieler spieler1, spieler2;
	public static Spielfeld sf;
	// Die Eingaben der Spieler werden in folgenden beiden Klassenattributen gespeichert
	public static int zeile = -1; 
	public static int spalte = -1;

	public static void main(String[] args) {
		System.out.println("Herzlich Willkommen zur Schatzsuche");
		int eingabe;
		boolean weiter = true;
		do {
			eingabe = menu();
			if (eingabe == 1) {
				System.out.print("Name Spieler 1: ");
				String name1 = sc.next();

				System.out.print("Name Spieler 2: ");
				String name2 = sc.next();

				System.out.print("Groesse Spielfeld: ");
				int n = sc.nextInt();

				spieler1 = new Spieler(name1, 1);
				spieler2 = new Spieler(name2, 2);
				sf = new Spielfeld(n);
				/* Namen der Spieler und Groesse des Spielfelds einlesen
				 * Sie duerfen von korrekten Eingaben ausgehen
				 * Konstruktoren fuer spieler1, spieler2 und sf aufrufen */
				// TODO				
				// Anweisungen hinzufuegen  
				
				// Folgende Zeile NICHT entfernen oder aendern!
				spielen();
			}
			if (eingabe == 2) {
				weiter = false;			
			}

		} while (weiter);

		sc.close();
	}
	
	/* Fragt solange nach einer Menu-Eingabe bis eine erlaubte Zahl eingegeben wird 
	 * Methode checkEingabeMenu() verwenden */
	public static int menu() {
		// TODO
		while (true) {
	        System.out.println("1 - Spielen");
	        System.out.println("2 - Programm beenden");

	        int eingabe = sc.nextInt();

	        if (checkEingabeMenu(eingabe)) {
	            return eingabe;
	        }

	        System.out.println("Bitte wiederholen");
	    }
		// ggf Anweisungen hinzufuegen  
		
		// unbedingt return-Anweisung aendern
	
	}

	/* Gibt bei Eingabe von 1 oder 2 true zurueck
	 * Sonst false */
	public static boolean checkEingabeMenu(int eingabe) {
		// TODO
		if(eingabe==1|| eingabe==2) {
			return true;
		}
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return false;
	}
	
	/* Diese Methode NICHT AENDERN! */
	public static void spielen() {
		do {
			spielerSpielt(spieler1);
			if (weiterspielen())
				spielerSpielt(spieler2);			
		} while (weiterspielen());	
		
		System.out.println(sf);
		System.out.println(auswertung());		
	}
	
	/* Spielfeld ausgeben, Eingabe fuer Spieler s aufrufen, Spielfeld aufdecken,
	 * solange weitergespielt wird und Spieler s einen Treffer erzielt.
	 * Methoden eingabe(), weiterspielen() und treffer() verwenden */
	public static void spielerSpielt(Spieler s) {
		// TODO
		boolean nochmal = true;

	    while (weiterspielen() && nochmal) {

	        System.out.println(sf);

	        eingabe(s);

	        System.out.println(sf.deckeAuf(zeile, spalte, s));

	        if (sf.treffer(zeile, spalte)) {
	            nochmal = true;
	        } else {
	            nochmal = false;
	        }
	    }
		
		// Anweisungen hinzufuegen  
	}
	
	/* Der Spieler wird solange nach einer Eingabe von Zeile und Spalte gefragt, 
	 * bis eine gültige Eingabe erfolgt (siehe Methode gueltigeEingabe()). 
	 * Die Klassenattribute zeile und spalte werden gesetzt. */
	public static void eingabe(Spieler s) {	
		// TODO	
		 while (true) {

		        System.out.println(s.getName() + " ist dran.");

		        System.out.print("Zeile: ");
		        int z = sc.nextInt();

		        System.out.print("Spalte: ");
		        int sp = sc.nextInt();

		        if (sf.gueltigeEingabe(z, sp)) {
		            zeile = z;
		            spalte = sp;
		            return;
		        }

		        System.out.println("Ungueltige Eingabe!");
		    }
		// Anweisungen hinzufuegen  
	}
	
	/* Gibt true zurück, wenn noch nicht alle Schätze gefunden wurden, false sonst. 
	 * Beachten Sie hierzu die Punkte der Spieler sowie die Anzahl der Schätze.*/
	public static boolean weiterspielen() {
		// TODO
		  int gefunden = spieler1.getPunkte() + spieler2.getPunkte();

		    if (gefunden < sf.getN()) {
		        return true;
		    }
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return false;
	}
	
	/* Gibt einen String zurueck mit der Info, wie das Spiel ausging.
	 * Unbedingt einen der Strings s1, s2, unentschieden zurueckgeben, je nach Spielausgang.
	 * Keine eigenen Rueckgabe-Strings erstellen! */
	public static String auswertung() {	
		/* Geben Sie unbedingt einen dieser Strings zurueck.
		 * Keine eigenen Rueckgabe-Strings erstellen! */ 
		String s1 = spieler1.getName() + " hat mit " + spieler1.getPunkte() + ":" + spieler2.getPunkte() + " gewonnen!";
		String s2 = spieler2.getName() + " hat mit " + spieler2.getPunkte() + ":" + spieler1.getPunkte() + " gewonnen!";
		String unentschieden = "Das Spiel endet unentschieden";
				
		// TODO
		if(spieler1.getPunkte()>spieler2.getPunkte()) {
			return s1;
		}else if(spieler1.getPunkte()<spieler2.getPunkte()) {
			return s2;
		}else {
			return unentschieden;
		}
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
	
	}
}
