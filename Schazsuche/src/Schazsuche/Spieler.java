package Schazsuche;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare!
 * Fuegen Sie Code hinzu!
 * Aendern Sie vom vorhandenen Code nur return-Anweisungen!
 ****************************************************************************************************** */

public class Spieler {

	/* Legen Sie Objektattribute an.
	 * 
	 * Wenden Sie das Geheimnisprinzip an. */
	// 
	
    private String name;
    private int punkte;
    private int spnr;
	
	/* Vervollstaendigen Sie den Konstruktor. 
	 * Alle Attribute brauchen einen sinnvollen Startwert.*/
	public Spieler(String name, int spnr) {
		// TODO
		// Anweisungen hinzufuegen
		this.name=name;
		this.spnr=spnr;
		this.punkte=0;
	}	
	
	/* Vervollstaendigen Sie die Getter- und Setter-Methoden */
	
	public String getName() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return name;
	}
	
	public int getSpielernummer() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return spnr;
	}
		
	public void setPunkte(int punkte) {
		// TODO
		// Anweisung(en) hinzufuegen 
		this.punkte=punkte;
	}
	
	public int getPunkte() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return punkte;
	}
	
}
