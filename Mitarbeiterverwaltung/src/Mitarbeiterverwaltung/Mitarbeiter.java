package Mitarbeiterverwaltung;

public abstract class  Mitarbeiter {
          private String name;
          private int personalnummer;
          private static int anzahlMitarbeiter;
          
          public Mitarbeiter(String name, int personalnummer, int anzahlMitarbeiter) {
        	  this.name=name;
        	  this.personalnummer=personalnummer;
        	  this.anzahlMitarbeiter=anzahlMitarbeiter;
          }
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPersonalnummer() {
			return personalnummer;
		}
		public abstract double berechneGehalt  ();
          
}
