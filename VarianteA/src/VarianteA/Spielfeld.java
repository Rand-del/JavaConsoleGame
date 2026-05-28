package VarianteA;

public class Spielfeld {
   private int [][] feld;
   private int n;
   
    public Spielfeld(int n) {
    	this.feld=new int [n][n];
    	this.n=n;
    }

	public int[][] getFeld() {
		return feld;
	}

	public void setFeld(int[][] feld) {
		this.feld = feld;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
    
	public boolean istFrei(int z, int s) {
		if(feld[z][s]==0) {
			return true;
		}
		return false;
	}
	public void setzeZahl(int z, int s, int zahl) {
		feld[z][s]=zahl;
	}
	
	public boolean feldvoll() {
		for(int i=0;i<feld.length;i++) {
			for( int j=0;j<feld[i].length;j++) {
				if(feld[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int diagonalSumme() {
		int sum=0;
		for(int i=0;i<feld.length;i++) {
			sum+= feld[i][i];
			}
		return sum;
	}
	
	public int zeilenPunkte() {
	    int punkte = 0;

	    for(int i = 0; i < feld.length; i++) {

	        int zsumme = 0;

	        for(int j = 0; j < feld[i].length; j++) {

	            zsumme += feld[i][j];
	        }

	        if(zsumme >= 2 * n) {

	            punkte++;
	        }
	    }

	    return punkte;
	}
	
	public int spaltenPunkte() {
		int punkte=0;
		 for(int i = 0; i < feld.length; i++) {

		        int ssumme = 0;

		        for(int j = 0; j < feld[i].length; j++) {

		            ssumme += feld[j][i];
		        }

		        if(ssumme <= 4 * n) {

		            punkte++;
		        }
		    }

		    return punkte;
	}
    
	
	public int berechnePunkte() {
		
		return zeilenPunkte()+spaltenPunkte();
		
	}
	public String toString() {
		String text="";
		for (int i = 0; i < feld.length; i++) {
	        for (int j = 0; j < feld[i].length; j++) {
	            text += feld[i][j] + " ";
	        }
	        text += "\n";
	    }
		return text;
	}
}

