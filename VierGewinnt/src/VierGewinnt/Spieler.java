package VierGewinnt;

public class Spieler {
  private String name ;
  private int spielstein;
  
   public Spieler (String name, int spielstein) {
	   this.name=name;
	   this.spielstein=spielstein;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getSpielstein() {
	return spielstein;
}

public void setSpielstein(int spielstein) {
	this.spielstein = spielstein;
}
   
}
