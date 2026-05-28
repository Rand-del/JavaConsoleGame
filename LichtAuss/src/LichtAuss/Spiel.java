package LichtAuss;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen in den Kommentaren der einzelnen Methoden!
 * Fuegen Sie Code, auch neue Attribute und Methoden, hinzu!
 * Aendern Sie vom vorhandenen Code nur die return-Anweisungen von testeEingabe() und berechneIndizes()
 ****************************************************************************************************** */

import java.util.Scanner;

public class Spiel {

	public static void main(String[] args) {
		System.out.println("Herzlich willkommen zu \"Licht aus!\"");
		int level=1;
		boolean spiel=true;
		// TODO
		Spielfeld sf = new Spielfeld(level + 4);
		Scanner sc=new Scanner(System.in);
		while(spiel) {
			int versuche=0;
			System.out.println("Das ist Level:"+level);
			System.out.println("Dies ist das Spielfeld:");
			  while (!sf.geloest()) {

		            System.out.println(sf);

		            System.out.println("Schalterposition (XL = Level neustarten; XX = Programm beenden)?");

		            String s = sc.nextLine();

		            while (!testeEingabe(s)) {
		                s = sc.nextLine();
		            }

		            switch (s) {

		                case "XX":
		                    spiel = false;
		                    break;

		                case "XL":
		                    sf = new Spielfeld(level + 4);

		                    System.out.println("Das ist Level " + level);
		                    System.out.println("Dies ist das Spielfeld:");
		                    break;

		                default:

		                    int[] indizes = berechneIndizes(s);

		                    sf.drueckeSchalter(indizes[0], indizes[1]);

		                    versuche++;
		            }

		            if (!spiel) {
		                break;
		            }
		        }

		        if (spiel) {

		            System.out.println(sf);

		            System.out.println("Du hast das Raetsel mit "
		                    + versuche + " Versuchen geloest.");

		            level++;
		        }
		    }

		    System.out.println("Du hast das Spiel beendet.");
		    System.out.println("Auf Wiedersehen!");

		    sc.close();
		}
		// main() vervollstaendigen
		// testEingabe() und berechneIndizes() verwenden
		// toString(), drueckeSchalter() und geloest() aus Klasse Spielfeld verwenden
		// weitere eigene Methoden schreiben und verwenden
	 

	public static boolean testeEingabe(String s) {
		// TODO
		switch(s) {
		case "A1":
		case "A2":
		case "A3":
		case "A4":
		case "A5":
			
		case "B1":
		case "B2":
		case "B3":
		case "B4":
		case "B5":
			
		case "C1":
		case "C2":
		case "C3":
		case "C4":
		case "C5":
			
		case "D1":
		case "D2":
		case "D3":
		case "D4":
		case "D5":
			
		case "E1":
		case "E2":
		case "E3":
		case "E4":
		case "E5":
			
		case "XX":
		case "XL":
			
			return true;
		
		}return false;
		// Gibt true zurueck, wenn s ein gueltiger Eingabestring ist
		// true bei "A1" bis "E5" sowie "XL"/"XX"
		// Sonst false
	}

	public static int[] berechneIndizes(String s) {
		// TODO
		int zeile=0;
		int spalte=0;
		switch(s) {
		case "A1":
			zeile=0;
			spalte=0;
			break;
		case "A2":
			zeile=0;
			spalte=1;
			break;
		case "A3":
			zeile=0;
			spalte=2;
			break;
		case "A4":
			zeile=0;
			spalte=3;
			break;
		case "A5":
			zeile=0;
			spalte=4;
			break;
			
		case "B1":
			zeile=1;
			spalte=0;
			break;
		case "B2":
			zeile=1;
			spalte=1;
			break;
		case "B3":
			zeile=1;
			spalte=2;
			break;
		case "B4":
			zeile=1;
			spalte=3;
			break;
		case "B5":
			zeile=1;
			spalte=4;
			break;
			
		case "C1":
			zeile=2;
			spalte=0;
			break;
		case "C2":
			zeile=2;
			spalte=1;
			break;
		case "C3":
			zeile=2;
			spalte=2;
			break;
		case "C4":
			zeile=2;
			spalte=3;
			break;
		case "C5":
			zeile=2;
			spalte=4;
			break;
			
		case "D1":
			zeile=3;
			spalte=0;
			break;
		case "D2":
			zeile=3;
			spalte=1;
			break;
		case "D3":
			zeile=3;
			spalte=2;
			break;
		case "D4":
			zeile=3;
			spalte=3;
			break;
		case "D5":
			zeile=3;
			spalte=4;
			break;
			
		case "E1":
			zeile=4;
			spalte=0;
			break;
		case "E2":
			zeile=4;
			spalte=1;
			break;
		case "E3":
			zeile=4;
			spalte=2;
			break;
		case "E4":
			zeile=4;
			spalte=3;
			break;
		case "E5":
			zeile=4;
			spalte=4;
				break;
			
		}
		int []erg= {zeile,spalte};
		
		// Gehen Sie davon aus, dass der String s eine erlaubte Eingabe ist
		// Rueckgabe: int-Feld mit 2 Eintraegen - jeweils eine Zahl zwischen 0 und 4
		return erg;
	}
}