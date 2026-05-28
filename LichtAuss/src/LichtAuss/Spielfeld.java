package LichtAuss;

/* *********************************************************************************************
Folgen Sie den Todo-Anweisungen in den Kommentaren der einzelnen Methoden!
Fuegen Sie Code, auch neue Attribute, Konstruktoren und Methoden, hinzu!
Aendern Sie vom vorhandenen Code nur die return-Anweisungen von toString() und geloest()
******************************************************************************************** */

import java.util.Random;

public class Spielfeld {
// Folgende zwei Zeilen nicht veraendern
// Verwenden Sie die Attribute in Ihrem Code
private static final int N = 5;
private boolean[][] feld;

Spielfeld(boolean[][] feld) {
	// Dieser Konstruktor ist zu Testzwecken vorhanden.
	// Sie duerfen ihn nicht veraendern und muessen ihn nicht verwenden.
	this.feld = feld;
}

public Spielfeld(int anzahlLampen) {
    feld = new boolean[N][N];

    Random r = new Random();
    int gesetzt = 0;

    while (gesetzt < anzahlLampen) {
        int z = r.nextInt(N);
        int s = r.nextInt(N);

        if (feld[z][s] == false) {
            feld[z][s] = true;
            gesetzt++;
        }
    }
}

public boolean[][] getFeld() {
	// Diese Methode ist zu Testzwecken vorhanden.
	// Sie duerfen sie nicht verändern und muessen sie nicht verwenden.
	return feld;
}

public String toString() {
	// TODO
	 String text = "  1 2 3 4 5\n";

	    for (int i = 0; i < feld.length; i++) {
	        text += (char)('A' + i) + " ";

	        for (int j = 0; j < feld[i].length; j++) {
	            if (feld[i][j]) {
	                text += "* ";
	            } else {
	                text += "O ";
	            }
	        }

	        text += "\n";
	    }
	
	// Gibt einen String zurueck, der das Spielfeld in der Form enthaelt,
	// in der es auf der Konsole ausgegeben werden soll.
	// true wird zu *, false wird zu O (Großbuchstabe O, nicht die Zahl 0)
	// Denken Sie an die Bezeichnungen von Zeilen und Spalten ("1" bis "5" und "A" bis "E")
	return text;
}

public void drueckeSchalter(int z, int s) {
	// TODO

    feld[z][s] = !feld[z][s];

    if (z > 0) {
        feld[z - 1][s] = !feld[z - 1][s];
    }

    if (z < N - 1) {
        feld[z + 1][s] = !feld[z + 1][s];
    }

    if (s > 0) {
        feld[z][s - 1] = !feld[z][s - 1];
    }

    if (s < N - 1) {
        feld[z][s + 1] = !feld[z][s + 1];
    }
	// Schaltet die Lampe [z,s] sowie die Nachbarlampen um
	// Gehen Sie davon aus, dass nur korrekte Werte (0<=z,s<N) uebergeben werden
}

public boolean geloest() {
	// TODO
	for(int i=0; i<feld.length; i++) {
		for (int j=0; j<feld[i].length;j++) {
			if(feld[i][j]==true) {
				return false;
			}
		}
	}
	// Gibt true zurueck, wenn der Level geloest wurde (alle Lampen aus)
	// Sonst false
	return true;
}

}
