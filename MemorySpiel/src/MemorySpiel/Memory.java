package MemorySpiel;
import java.util.Random;
public class Memory {
	
           char[][]versteckt;
           char [][]gezeigt;
           
           public Memory () {
        	   this.versteckt= new char [4][6];
        	   this.gezeigt= new char [4][6];
           }
     public void ini () {
    	  for(int i=0;i<gezeigt.length;i++) {
              for(int j=0;j<gezeigt[i].length;j++) {
                  gezeigt[i][j]='-';
              }
     }
     }
     
     public void ausgabe(char[][]feld) {
         for(int i=0;i<feld.length;i++) {
             for(int j=0;j<feld[i].length;j++) {
                 System.out.print(feld[i][j]+" \t");
             }System.out.println();
         }
         }
}
