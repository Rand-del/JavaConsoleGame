package Schazsuche;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UnitTests {
	/*
	 * ************************************************************* 
	 * Tests fuer Klasse Spiel
	 ***************************************************************/

	@Test
	void testCheckEingabeMenu() {
		assertTrue(Spiel.checkEingabeMenu(1));
		assertTrue(Spiel.checkEingabeMenu(2));
		
		for (int i = 0; i < 10; i++) {
			assertFalse(Spiel.checkEingabeMenu(i + 3));
			assertFalse(Spiel.checkEingabeMenu(-i));
		}
	}

	@Test
	void testWeiterspielen() {
		Spiel.spieler1 = new Spieler("Spieler 1", 1);
		Spiel.spieler2 = new Spieler("Spieler 2", 2);
		Spiel.sf = new Spielfeld(5);
		Spiel.spieler1.setPunkte(0);
		Spiel.spieler2.setPunkte(0);
		assertTrue(Spiel.weiterspielen());
		Spiel.spieler1.setPunkte(3);
		Spiel.spieler2.setPunkte(2);
		assertFalse(Spiel.weiterspielen());
		Spiel.spieler1.setPunkte(2);
		Spiel.spieler2.setPunkte(3);
		assertFalse(Spiel.weiterspielen());
		Spiel.spieler1.setPunkte(2);
		Spiel.spieler2.setPunkte(2);
		assertTrue(Spiel.weiterspielen());
		Spiel.sf = new Spielfeld(4);
		Spiel.spieler1.setPunkte(2);
		Spiel.spieler2.setPunkte(2);
		assertFalse(Spiel.weiterspielen());
	}
	@Test
	void testAuswertung() {
		Spiel.spieler1 = new Spieler("Alex", 1);
		Spiel.spieler2 = new Spieler("Toni", 2);
		Spiel.spieler1.setPunkte(3);
		Spiel.spieler2.setPunkte(2);
		String s1 = Spiel.spieler1.getName() + " hat mit " + Spiel.spieler1.getPunkte() + ":" + Spiel.spieler2.getPunkte() + " gewonnen!";
		assertEquals(s1, Spiel.auswertung());
		
		Spiel.spieler1.setPunkte(2);
		Spiel.spieler2.setPunkte(3);
		String s2 = Spiel.spieler2.getName() + " hat mit " + Spiel.spieler2.getPunkte() + ":" + Spiel.spieler1.getPunkte() + " gewonnen!";
		assertEquals(s2, Spiel.auswertung());
		
		Spiel.spieler1.setPunkte(2);
		Spiel.spieler2.setPunkte(2);
		String unentschieden = "Das Spiel endet unentschieden";
		assertEquals(unentschieden, Spiel.auswertung());
	}
	
	/*
	 * 
	 * ************************************************************* 
	 * Test fuer Klasse Spieler
	 *************************************************************/
	@Test
	void testGetNameGetSpielernummer() {
		Spieler s = new Spieler("Alex", 1);
		assertEquals("Alex",s.getName());	
		assertEquals(1,s.getSpielernummer());
		s = new Spieler("Toni", 2);
		assertEquals("Toni",s.getName());	
		assertEquals(2,s.getSpielernummer());
	}
	
	@Test
	void testSetGetPunkte() {
		Spieler s = new Spieler("Test",1);
		s.setPunkte(s.getPunkte() + 1);
		assertEquals(1, s.getPunkte());	
		s.setPunkte(42);
		assertEquals(42, s.getPunkte());	
	}
	
	/*
	 * 
	 * ************************************************************* 
	 * Tests fuer Klasse Spielfeld
	 *************************************************************/
	@Test
	void testKonstruktorUndGetN() {
		for (int n = 2; n < 10; n++) {
			Spielfeld sf = new Spielfeld(n);
			boolean[][] feld = sf.getSchatzkarte();
			int zaehler = 0;
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < n; j++) 
					if (feld[i][j])
						zaehler++;	
			assertEquals(n, zaehler);
			assertEquals(n, sf.getN());
		}
	}
	
	@Test
	void testTreffer() {
		boolean[][] feld = { {true, false, true}, {false, false, false}, {true, false, false} };
		Spielfeld sf = new Spielfeld(feld, new int[3][3]);
		for (int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; j++) 
				assertEquals(feld[i][j], sf.treffer(i,j));
	}
	
	@Test
	void testAngrenzend() {
		boolean[][] feld = { {true, false, true}, {false, false, false}, {true, false, false} };
		Spielfeld sf = new Spielfeld(feld, new int[3][3]);
		assertFalse(sf.angrenzend(0, 0));
		assertTrue(sf.angrenzend(0, 1));
		assertFalse(sf.angrenzend(0, 2));
		assertTrue(sf.angrenzend(1, 0));
		assertFalse(sf.angrenzend(1, 1));
		assertTrue(sf.angrenzend(1, 2));
		assertFalse(sf.angrenzend(2, 0));
		assertTrue(sf.angrenzend(2, 1));
		assertFalse(sf.angrenzend(2, 2));
	}
	
	@Test
	void testDeckeAuf() {
		Spieler s1 = new Spieler("Test",1);
		Spieler s2 = new Spieler("Test",2);
		boolean[][] feld = { {true, false, true}, {false, false, false}, {true, false, false} };
		Spielfeld sf = new Spielfeld(feld, new int[3][3]);
		String schatz = "Schatz gefunden! Punkt fuer " + s1.getName() + "!";
		String schatzAngrenzend = "Ein Schatz befindet sich in mind. einem angrenzenden Feld.";
		String keinSchatz = "Kein Schatz in der Naehe.";
		
		// Zu Beginn alle Stellen unaufgedeckt
		for (int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; j++) 
				assertEquals(0,sf.getOffenesSpielfeld(i,j));
	
		assertEquals(schatz, sf.deckeAuf(0,0,s1));
		assertEquals(1,sf.getOffenesSpielfeld(0,0));
	
		assertEquals(schatzAngrenzend, sf.deckeAuf(1,0,s1));
		assertEquals(-2,sf.getOffenesSpielfeld(1,0));
	
		assertEquals(schatz, sf.deckeAuf(2,0,s2));
		assertEquals(2,sf.getOffenesSpielfeld(2,0));
		
		assertEquals(schatzAngrenzend, sf.deckeAuf(0,1,s1));
		assertEquals(-2,sf.getOffenesSpielfeld(0,1));

		assertEquals(keinSchatz, sf.deckeAuf(1,1,s1));
		assertEquals(-1,sf.getOffenesSpielfeld(1,1));

		assertEquals(schatzAngrenzend, sf.deckeAuf(2,1,s1));
		assertEquals(-2,sf.getOffenesSpielfeld(2,1));

		assertEquals(schatz, sf.deckeAuf(0,2,s2));
		assertEquals(2,sf.getOffenesSpielfeld(0,2));

		assertEquals(schatzAngrenzend, sf.deckeAuf(1,2,s2));
		assertEquals(-2,sf.getOffenesSpielfeld(1,2));

		assertEquals(keinSchatz, sf.deckeAuf(2,2,s2));
		assertEquals(-1,sf.getOffenesSpielfeld(2,2));
		
	}
	
	@Test
	void testGueltigeEingabe() {
		boolean[][] feld = { {true, false, true}, {false, false, false}, {true, false, false} };
		int[][] feldInt = { {1, 0, 0}, {-2, -1, 0}, {2, 0, 0} };
		Spielfeld sf = new Spielfeld(feld, feldInt);
		
		assertFalse(sf.gueltigeEingabe(-1, -1));
		assertFalse(sf.gueltigeEingabe(3, 3));
		assertFalse(sf.gueltigeEingabe(3, -1));
		assertFalse(sf.gueltigeEingabe(-1, 3));
		assertFalse(sf.gueltigeEingabe(2, -1));
		assertFalse(sf.gueltigeEingabe(-1, 2));
		
		assertFalse(sf.gueltigeEingabe(0, 0));
		assertTrue(sf.gueltigeEingabe(0, 1));
		assertTrue(sf.gueltigeEingabe(0, 2));
		assertFalse(sf.gueltigeEingabe(1, 0));
		assertFalse(sf.gueltigeEingabe(1, 1));
		assertTrue(sf.gueltigeEingabe(1, 2));
		assertFalse(sf.gueltigeEingabe(2, 0));
		assertTrue(sf.gueltigeEingabe(2, 1));
		assertTrue(sf.gueltigeEingabe(2, 2));
		
	}

}
	