package MemorySpiel;

public class Spieler {
 private String name;
 private int punkte=0;
 
         public Spieler(String name) {
        	 this.name=name;
        	 
         }

		public String getName() {
			return name;
		}


	

		public int getPunkte() {
			return punkte;
		}

		public void setPunkte(int punkte) {
			this.punkte +=1;
		}
         
         
         
}

