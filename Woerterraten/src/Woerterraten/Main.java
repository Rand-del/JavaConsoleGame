package Woerterraten;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        while (true) {
            System.out.println();
            System.out.println("Bitte wählen Sie aus");
            System.out.println("1 - Ein Spieler");
            System.out.println("2 - Zwei Spieler");
            System.out.println("3 - Programm beenden");

            int wahl = sc.nextInt();
            sc.nextLine(); // <<< ganz wichtig: Eingabezeile leeren >>>

            if (wahl == 3) {
                System.out.println("Auf Wiedersehen!");
                break;
            } 
            else if (wahl == 1) {
                // 🧍 Mensch gegen Computer
                System.out.println("Geben Sie den Namen des Spielers ein:");
                String name0 = sc.nextLine();

                Spieler sp1 = new Spieler(name0, false);
                Spieler sp2 = new Spieler("Computer", true);

                // Mensch wählt Wort
                System.out.println(sp1.getName() + 
                    ", geben Sie Ihr geheimes Wort (8-10 Buchstaben) ein:");
                String wort1 = sc.nextLine();
                sp1.setWort(wort1);

                // Computer wählt zufälliges Wort
                String[] woerter = {"apfel","banane","kirche","orange",
                                    "tomaten","gurken","paprika","zwiebel","zitrone"};
                String zufall = woerter[rd.nextInt(woerter.length)];
                sp2.setWort(zufall);

                // Jetzt erst das Spiel starten ✅
                play(sp1, sp2, sc, rd);
            } 
            else if (wahl == 2) {
                // 👥 Zwei menschliche Spieler
                System.out.println("Erster Spieler: Geben Sie Ihren Namen ein:");
                String name1 = sc.nextLine();
                Spieler sp1 = new Spieler(name1, false);

                System.out.println("Zweiter Spieler: Geben Sie Ihren Namen ein:");
                String name2 = sc.nextLine();
                Spieler sp2 = new Spieler(name2, false);

                System.out.println(sp1.getName() + ", geben Sie Ihr geheimes Wort ein:");
                String wort1 = sc.nextLine();
                sp1.setWort(wort1);

                System.out.println(sp2.getName() + ", geben Sie Ihr geheimes Wort ein:");
                String wort2 = sc.nextLine();
                sp2.setWort(wort2);

                play(sp1, sp2, sc, rd);
            } 
            else {
                System.out.println("Bitte eine Zahl zwischen 1 und 3 eingeben!");
            }
        }

        sc.close();
    }

    // 🔹 Methode für den Spielablauf
    public static void play(Spieler s1, Spieler s2, Scanner sc, Random rd) {
        Spieler aktuell = s1;  // wer gerade rät
        Spieler gegner = s2;
        boolean spielLaeuft = true;

        System.out.println("\n=== Das Spiel beginnt! ===");

        while (spielLaeuft) {
            System.out.println("\nWort von " + gegner.getName() + ": " + gegner.getAktuell());

            char buchstabe;

            // 👉 Unterschied: Mensch oder Computer
            if (aktuell.istComputer()) {
                buchstabe = (char) ('a' + rd.nextInt(26));  // Zufallsbuchstabe a–z
                System.out.println("Computer wählt: " + buchstabe);
            } else {
                System.out.println(aktuell.getName() + ", geben Sie einen Buchstaben ein:");
                buchstabe = sc.nextLine().toLowerCase().charAt(0);
            }

            boolean richtig = gegner.pruefeBuchstabe(buchstabe);

            if (richtig) {
                System.out.println("Der Buchstabe kommt vor!");

                // prüfen, ob das ganze Wort erraten wurde
                if (gegner.getAktuell().equals(gegner.getWort())) {
                    System.out.println("\n" + aktuell.getName() + " hat gewonnen!");
                    System.out.println("Das Wort war: " + gegner.getWort());
                    spielLaeuft = false;
                }
            } else {
                System.out.println("Der Buchstabe kommt nicht vor!");
                // Spieler wechseln
                Spieler temp = aktuell;
                aktuell = gegner;
                gegner = temp;
            }
        }
    }
}
