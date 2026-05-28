package FindTheNumber;
import java.util.Scanner;
import java.util.Random;
public class findedaszahl {
	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Random rd = new Random();

	        int[] felder = new int[10];  // 🔹 مصفوفة فيها 10 خانات
	        for (int i = 0; i < felder.length; i++) {
	            felder[i] = i + 1; // نملأ المصفوفة بالأرقام 1..10
	        }

	        // 🔹 الكمبيوتر يختار خانة عشوائية
	        int geheimIndex = rd.nextInt(felder.length);
	        int geheimZahl = felder[geheimIndex];

	        System.out.println("Willkommen zum Spiel 'Find the Number'!");
	        System.out.println("Ich habe eine Zahl zwischen 1 und 10 versteckt. Erraten Sie den Index (0-9)!");

	        boolean gefunden = false;
	        int versuche = 0;

	        while (!gefunden) {
	            System.out.print("Ihr Tipp (Index 0–9): ");
	            int tipp = sc.nextInt();
	            versuche++;

	            if (tipp == geheimIndex) {
	                System.out.println("🎉 Richtig! Die Zahl war " + geheimZahl + ".");
	                System.out.println("Sie haben " + versuche + " Versuche gebraucht.");
	                gefunden = true;
	            } else {
	                System.out.println("❌ Falsch! Versuchen Sie es nochmal.");
	            }
	        }

	        sc.close();
	    }
	}
