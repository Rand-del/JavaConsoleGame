package VierGewinnt;

public class Spielfeld {
 
	private int [][] feld;
	private int z;
	private int s;
	
	public Spielfeld(int z, int s) {
		this.z = z;
		this.s = s;
		feld = new int [z][s];
		inisi();
	}
	 public void inisi() {
		 for (int i=0; i<feld.length;i++) {
			 for (int j=0; j<feld [i].length;j++) {
				 feld[i][j]=0;
			 }
		 }
	 }
	
	 public void druckSpielfeld() {
		 System.out.println("\nVIER GEWINNT");
		 for (int i=0; i<feld.length;i++) {
			 System.out.print((i+1)+" | ");
			 for (int j=0; j<feld [i].length;j++) {
				 System.out.print(feld[i][j]+" | ");
			 }
			 System.out.println();
		 }
		 System.out.println("  - - - - - - - - - - - - - - -");
		 for (int i=0; i<feld[0].length;i++) {
			System.out.print ("   "+(i));
		 }
	 }
	 
	 public boolean setzeSpielsteine(int s, int nummer) {
		 if ( s<0 || s>=s){
			 System.out.println("Geben Sie gültige Spalte ein");
			 return false;
			 }
			for(int i=z-1; i>=0;i--) {
					 if (feld[i][s]==0) {
						 feld[i][s]=nummer;
						 return true;
					 }
			} System.out.println("Diese Spalte ist schon voll ! \n Bitte wählen Sie eine andere !");
			return false;
		 }
	      
	 public boolean testeSieg( int nummer) {
		 
		 for (int i=0;i<z;i++) {
			 for (int j=0; j<s-3;j++) {
				 if(feld[i][j]==nummer&&feld[i][j+1]==nummer&&feld[i][j+2]==nummer&&feld[i][j+3]==nummer) {
					 return true;
				 }
			 }
		 }
		 for (int i=0;i<z-3;i++) {
			 for (int j=0; j<s;j++) {
				 if(feld[i][j]==nummer&&feld[i+1][j]==nummer&&feld[i+2][j]==nummer&&feld[i+3][j]==nummer) {
					 return true;
				 }
			 }
		 }
		 //Diagonal von oben links nach unten rechts
		 
		 for (int i=0;i<z-3;i++) {
			 for (int j=0; j<s-3;j++) {
				 if(feld[i][j]==nummer&&feld[i+1][j+1]==nummer&&feld[i+2][j+2]==nummer&&feld[i+3][j+3]==nummer) {
					 return true;
				 }
			 }
		 }
		 //Diagonal von unten links nach oben rechts
		 
		 for (int i=z-1;i>=3;i--) {
			 for (int j=0; j<s-3;j++) {
				 if(feld[i][j]==nummer&&feld[i-1][j+1]==nummer&&feld[i-2][j+2]==nummer&&feld[i-3][j+3]==nummer) {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 public boolean istUnentschieden() {
		 for(int i=0;i<z;i++) {
			 for(int j=0;j<s;j++) {
				 if(feld[i][j]==0) {
					 return false;
				 }
			 } 
		 }return true;
	 }
	 }
	 
