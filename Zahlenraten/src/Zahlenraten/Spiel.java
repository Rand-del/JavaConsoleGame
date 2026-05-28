package Zahlenraten;
import java.util.Scanner;
import java.util.Random;
public class Spiel {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		Random rd=new Random();
		System.out.println("Zahlenraten\n"
				+ "1- Ein Spieler\n"
				+ "2-Zwei Spieler\n"
				+ "3-Programm beenden\n");
		int runde=1;
        int eingabe=sc.nextInt();
        
			if(eingabe ==1) {
			    System.out.print("Geben Sie den Namen des Spielers ein:");
			    String name = sc.next();

			    Spieler sp = new Spieler(name);
			    Spieler computer = new Spieler("Computer");
			    
			    while(sp.getPunkte()<5 && computer.getPunkte()<5) {
			        int a = rd.nextInt(101);
					int b = rd.nextInt(101);
					int min;
					int max;
					if (a < b) {
					    min = a;
					    max = b;
					} else {
					    min = b;
					    max = a;
					}
					int zahl=rd.nextInt(101);
					System.out.println("Rund "+runde+":\n");
					System.out.println("Die Zahlen sind "+min+" und "+max+" .\n");
					System.out.println(sp.getName()+" ist an der Reihe ");
					System.out.println("Waehlen Sie aus. Die naechste Zahl ist ...\n"
							+ "0: kleiner als "+min+ " .\n"
							+ "1: genau "+min+".\n"
							+ "2: zwischen "+min+" und "+max+" .\n"
							+ "3: genau " +max+ " .\n"
							+ "4: größer als "+max+" .");
					int spauswahl=sc.nextInt();
					System.out.println(computer.getName()+" ist an der Reihe \n");
					int auswahlcomputer=rd.nextInt(5);
					System.out.println("Die Auswahl des Computers ist \n"+auswahlcomputer);
					System.out.println("Die dritte Zahl lautet \n "+zahl);
					if (spauswahl == 0 && zahl < min) {
					    sp.setPunkte(sp.getPunkte() + 2);
					} else if (spauswahl == 1 && zahl == min) {
					    sp.setPunkte(sp.getPunkte() + 1);
					} else if (spauswahl == 2 && min < zahl && zahl < max) {
					    sp.setPunkte(sp.getPunkte() + 2);
					} else if (spauswahl == 3 && zahl == max) {
					    sp.setPunkte(sp.getPunkte() + 1);
					} else if (spauswahl == 4 && zahl > max) {
					    sp.setPunkte(sp.getPunkte() + 2);
					}
					if (auswahlcomputer == 0 && zahl < min) {
					    computer.setPunkte(computer.getPunkte() + 2);
					} else if (auswahlcomputer == 1 && zahl == min) {
					    computer.setPunkte(computer.getPunkte() + 1);
					} else if (auswahlcomputer == 2 && min < zahl && zahl < max) {
					    computer.setPunkte(computer.getPunkte() + 2);
					} else if (auswahlcomputer == 3 && zahl == max) {
					    computer.setPunkte(computer.getPunkte() + 1);
					} else if (auswahlcomputer == 4 && zahl > max) {
					    computer.setPunkte(computer.getPunkte() + 2);
					}
					    System.out.println(sp.getName() + ": " + sp.getPunkte());
					    System.out.println(computer.getName() + ": " + computer.getPunkte());

					    runde++;
			    }if(sp.getPunkte()>computer.getPunkte()){
					System.out.println(sp.getName()+"hat gewonnen");
				}else {
					System.out.println(computer.getName()+"hat gewonnen");
				}
			    

				
				
			} else if(eingabe==2) {
				System.out.println("Geben Sie den Namen des ersten Spielers ein:");
				String name1=sc.next();
				System.out.println("Geben Sie den Namen des zweiten Spielers ein:");
				String name2=sc.next();
				Spieler sp1=new Spieler(name1);
				Spieler sp2=new Spieler(name2);
				
				while(sp1.getPunkte()<5 && sp2.getPunkte()<5) {
					 int a = rd.nextInt(101);
						int b = rd.nextInt(101);
						int min;
						int max;
						if (a < b) {
						    min = a;
						    max = b;
						} else {
						    min = b;
						    max = a;
						}
						int zahl=rd.nextInt(101);
					System.out.println("Rund "+runde+":\n");
					System.out.println("Die Zahlen sind "+min+" und "+max+" .\n");
					System.out.println(sp1.getName()+" ist an der Reihe ");
					System.out.println("Waehlen Sie aus. Die naechste Zahl ist ...\n"
							+ "0: kleiner als "+min+ " .\n"
							+ "1: genau "+min+".\n"
							+ "2: zwischen "+min+" und "+max+" .\n"
							+ "3: genau " +max+ " .\n"
							+ "4: größer als "+max+" .");
					int sp1auswahl=sc.nextInt();
					System.out.println(sp2.getName()+" ist an der Reihe \n");
					System.out.println("Waehlen Sie aus. Die naechste Zahl ist ...\n"
							+ "0: kleiner als "+min+ " .\n"
							+ "1: genau "+min+".\n"
							+ "2: zwischen "+min+" und "+max+" .\n"
							+ "3: genau " +max+ " .\n"
							+ "4: größer als "+max+" .");
					int sp2auswahl=sc.nextInt();
					System.out.println("Die dritte Zahl lautet \n "+zahl);
					if (sp1auswahl == 0 && zahl < min) {
					    sp1.setPunkte(sp1.getPunkte() + 2);
					} else if (sp1auswahl == 1 && zahl == min) {
					    sp1.setPunkte(sp1.getPunkte() + 1);
					} else if (sp1auswahl == 2 && min < zahl && zahl < max) {
					    sp1.setPunkte(sp1.getPunkte() + 2);
					} else if (sp1auswahl == 3 && zahl == max) {
					    sp1.setPunkte(sp1.getPunkte() + 1);
					} else if (sp1auswahl == 4 && zahl > max) {
					    sp1.setPunkte(sp1.getPunkte() + 2);
					}
					if (sp2auswahl == 0 && zahl < min) {
					    sp2.setPunkte(sp2.getPunkte() + 2);
					} else if (sp2auswahl == 1 && zahl == min) {
					    sp2.setPunkte(sp2.getPunkte() + 1);
					} else if (sp2auswahl == 2 && min < zahl && zahl < max) {
					    sp2.setPunkte(sp2.getPunkte() + 2);
					} else if (sp2auswahl == 3 && zahl == max) {
					    sp2.setPunkte(sp2.getPunkte() + 1);
					} else if (sp2auswahl == 4 && zahl > max) {
					    sp2.setPunkte(sp2.getPunkte() + 2);
					}
					    System.out.println(sp1.getName() + ": " + sp1.getPunkte());
					    System.out.println(sp2.getName() + ": " + sp2.getPunkte());

					    runde++;
			    }if(sp1.getPunkte()>sp2.getPunkte()){
					System.out.println(sp1.getName()+"hat gewonnen");
				}else {
					System.out.println(sp2.getName()+"hat gewonnen");
					
				}
						
				
			} else if(eingabe==3) {
				System.out.println("Programm wird beendet3");
			} else {
				System.out.println("Ungueltigen eingabe");
			}
		}

	}


