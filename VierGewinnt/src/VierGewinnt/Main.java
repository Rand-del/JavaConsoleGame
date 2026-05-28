package VierGewinnt;
import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		Spielfeld sp = new Spielfeld (6,7);
		sp.inisi();
		sp.druckSpielfeld();
		
		int eingabe;
		do {
		Scanner sc=new Scanner (System.in);
		System.out.println("\n \n  VIER GEWINNT");
	     System.out.println("1- Ein Spieler\n"
	     		+ "2- Zwei Spieler\n"
	    		 + "3- Programm beenden\n");
	    eingabe=  sc.nextInt();
	     
	     if(eingabe==1) {
	    	 System.out.println("Geben Sie Name des Spieler ein");
	    	 String name1= sc.next();
	    	 Spieler sp1 = new Spieler (name1,1);
	    	 Spieler sp2 = new Spieler ("Computer",2);
	    	 
	    	 }
	     else if (eingabe==2 ) {
    		 System.out.println("Geben Sie Name des erste Spieler ein");
    		 String name1= sc.next();
	    	 Spieler sp1 = new Spieler (name1,1);
    		 System.out.println("Geben Sie Name des zweite Spieler ein");
    		 String name2= sc.next();
    		 Spieler sp2 = new Spieler (name2,2);
	 	} else if (eingabe==3) {
   		 System.out.println("Programm beenden");
	 	} } while(eingabe !=3) ;
	 		
	int s=0;
	int pos=0;
	while(true) {
		if(pos%2==0) {
			do {
				
			}while(sp.setzeSpielsteine(s, sp1.getSpielstein()));
		}
	}
	 	
	 	

	
	

}}
