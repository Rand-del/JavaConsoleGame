package Woerterraten;

public class Spieler {

    // 🔹 Attribute (Eigenschaften des Spielers)
    private String name;        // Name des Spielers
    private String wort;        // Das geheime Wort, das erraten werden muss
    private String aktuell;     // Aktueller Stand des Wortes (mit * für unbekannte Buchstaben)
    private boolean istComputer; // true = Computer, false = Mensch

    // 🔹 Konstruktor – erstellt einen Spieler mit Name und Art (Computer oder Mensch)
    public Spieler(String name, boolean istComputer) {
        this.name = name;               // speichere den Namen
        this.istComputer = istComputer; // speichere, ob Computer oder Mensch
        this.wort = "";                 // Anfangswert: noch kein Wort gesetzt
        this.aktuell = "";              // Anfangswert: noch keine Buchstaben bekannt
    }

    // 🔹 Methode, um das geheime Wort zu setzen
    public void setWort(String wort) {
        // Das eingegebene Wort speichern
        this.wort = wort;
    // Den aktuellen Stand mit Sternchen (*) füllen – gleiche Länge wie das Wort
        this.aktuell = "";
        for (int i = 0; i < wort.length(); i++) {
            this.aktuell += "*";
        }
    }

    // 🔹 Methode zum Überprüfen, ob ein Buchstabe im Wort vorkommt
    // Gibt true zurück, wenn der Buchstabe vorkommt, sonst false
    public boolean pruefeBuchstabe(char buchstabe) {
        boolean gefunden = false;  // Merker, ob der Buchstabe gefunden wurde
        String neu = "";           // Hier speichern wir das neue Wort mit evtl. aufgedeckten Buchstaben

        // Durchlaufe das geheime Wort Buchstabe für Buchstabe
        for (int i = 0; i < wort.length(); i++) {
            // Wenn der aktuelle Buchstabe mit dem geratenen übereinstimmt:
            if (wort.charAt(i) == buchstabe) {
                neu += buchstabe;   // Buchstabe wird aufgedeckt
                gefunden = true;    // wir merken uns: Treffer!
            } else {
                // sonst bleibt der bisherige Stand erhalten (entweder * oder schon gefundener Buchstabe)
                neu += aktuell.charAt(i);
            }
        }

        // Den aktuellen Stand aktualisieren
        this.aktuell = neu;

        // true = Treffer, false = kein Treffer
        return gefunden;
    }

    // 🔹 Getter-Methoden zum Auslesen der Werte
    public String getName() {
        return name;
    }

    public String getWort() {
        return wort;
    }

    public String getAktuell() {
        return aktuell;
    }

    public boolean istComputer() {
        return istComputer;
    }
}

