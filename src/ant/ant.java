package ant;

public class ant {
	
	public static void main(String[] args) {
		int cants=10; // Anzahl der Ameisen
		journey ants[]= new journey[cants]; // Reiseroute für jede Ameise
		locations locs= new locations();    // Die zu besuchenden Orte
		net map= new net(); // Die Landkarte
		
		// Alle Orte anlegen
		locs.add("A",0.0,0.0);
		locs.add("B",10.0,10.0);
		locs.add("C",10.0,0.0);
		locs.add("D",0.0,10.0);
		locs.add("D",5.0,5.0);

		// Eine Karte aller Verbindungswege erzeugen
		map.calcAllWays(locs);
		map.print();
		
		// Alle Ameisen nacheinander einen (guten) Weg finden lassen
		for( int i=0;i<ants.length;i++) {
			// i-te Ameise: Erlaubte Orte übergebens
			ants[i]= new journey(locs);
			// i-te Ameise : Eine gute Rundreise erzeugen
			ants[i].calcJourney(map);
			// i-te Ameise: Reise ausdrucken
			ants[i].print();
		}
	}

}
