package VarianteA;

import java.util.Scanner;
import java.util.Random;

public class Spiel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        boolean programmLaeuft = true;

        while (programmLaeuft) {

            System.out.println("1 - Ein neues Spiel starten");
            System.out.println("2 - Programm beenden");

            int eingabe = sc.nextInt();

            if (eingabe == 1) {

                System.out.println("Geben Sie den Namen von Spieler 1 an:");
                String name1 = sc.next();

                System.out.println("Geben Sie den Namen von Spieler 2 an:");
                String name2 = sc.next();

                System.out.println("Wie gross soll das quadratische Spielfeld sein (Seitenlaenge angeben):");
                int n = sc.nextInt();

                Spieler spieler1 = new Spieler(name1);
                Spieler spieler2 = new Spieler(name2);

                Spielfeld feld1 = new Spielfeld(n);
                Spielfeld feld2 = new Spielfeld(n);

                boolean spieler1Dran = true;

                while (!feld1.feldvoll() || !feld2.feldvoll()) {

                    Spieler aktuellerSpieler;
                    Spielfeld aktuellesFeld;

                    if (spieler1Dran) {
                        aktuellerSpieler = spieler1;
                        aktuellesFeld = feld1;
                    } else {
                        aktuellerSpieler = spieler2;
                        aktuellesFeld = feld2;
                    }

                    if (!aktuellesFeld.feldvoll()) {

                        int zahl = rn.nextInt(6) + 1;

                        System.out.println(aktuellerSpieler.getName() + " ist an der Reihe:");
                        System.out.println("Du hast eine " + zahl + " gewuerfelt.");
                        System.out.println("An welche Stelle moechtest du die Zahl schreiben:");
                        System.out.println(aktuellesFeld);

                        boolean gueltig = false;

                        while (!gueltig) {
                            System.out.println("Zeile:");
                            int z = sc.nextInt();

                            System.out.println("Spalte:");
                            int s = sc.nextInt();

                            if (z >= 0 && z < n && s >= 0 && s < n && aktuellesFeld.istFrei(z, s)) {
                                aktuellesFeld.setzeZahl(z, s, zahl);
                                gueltig = true;
                            } else {
                                System.out.println("Falsche Eingabe. Erneut versuchen.");
                            }
                        }
                    }

                    spieler1Dran = !spieler1Dran;
                }

                spieler1.setPunkte(feld1.berechnePunkte());
                spieler2.setPunkte(feld2.berechnePunkte());

                System.out.println(spieler1.getName() + " erreicht " + spieler1.getPunkte() + " Punkte:");
                System.out.println(feld1);

                System.out.println(spieler2.getName() + " erreicht " + spieler2.getPunkte() + " Punkte:");
                System.out.println(feld2);

                if (spieler1.getPunkte() > spieler2.getPunkte()) {
                    System.out.println(spieler1.getName() + " gewinnt.");
                } else if (spieler2.getPunkte() > spieler1.getPunkte()) {
                    System.out.println(spieler2.getName() + " gewinnt.");
                } else {
                    System.out.println("Das Spiel endet unentschieden.");
                }

            } else if (eingabe == 2) {
                System.out.println("Das Programm wird beendet.");
                programmLaeuft = false;
            }
        }

        sc.close();
    }
}