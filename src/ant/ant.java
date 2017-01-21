package ant;

public class ant {
	
	public static void main(String[] args) {
		int cants=250; // Anzahl der Ameisen
		journey ants[]= new journey[cants]; // Reiseroute für jede Ameise
		locations locs= new locations();    // Die zu besuchenden Orte
		net map= new net(); // Die Landkarte
		
		// Alle Orte anlegen
		locs.add("A",0.0,0.0);
		locs.add("B",10.0,10.0);
		locs.add("C",0.0,10.0);
		locs.add("D",-10.0,10.0);
		locs.add("E",20.0,20.0);
		locs.add("F",10.0,20.0);
		locs.add("G",0.0,20.0);
		locs.add("H",-10.0,20.0);
		locs.add("I",-20.0,20.0);
		locs.add("J",30.0,30.0);
		locs.add("K",20.0,30.0);
		locs.add("L",10.0,30.0);
		locs.add("M",0.0,30.0);
		locs.add("N",-10.0,30.0);
		locs.add("O",-20.0,30.0);
		locs.add("P",-30.0,30.0);
		locs.add("Q",40.0,40.0);
		locs.add("R",30.0,40.0);
		locs.add("S",20.0,40.0);
		locs.add("T",10.0,40.0);
		locs.add("U",0.0,40.0);
		locs.add("V",-10.0,40.0);
		locs.add("W",-20.0,40.0);
		locs.add("X",-30.0,40.0);
		locs.add("Y",-40.0,40.0);
		// Eine Karte aller Verbindungswege erzeugen
		map.calcAllWays(locs);
		map.print();
		double shortest= 1.0E27;
		int shortestIndex= 0;
		double globshortest= 1.0E27;
		int globshortestIndex= 0;
		for( int durchgang=0; durchgang< 1000; durchgang++) {
			shortest= 1.0E27;
			shortestIndex= 0;
			
			// Alle Ameisen nacheinander einen (guten) Weg finden lassen
			for( int i=0;i<ants.length;i++) {
				// i-te Ameise: Erlaubte Orte übergeben
				ants[i]= new journey(locs);
				// i-te Ameise : Eine gute Rundreise erzeugen
				ants[i].calcJourney(map);
				// i-te Ameise: Reise ausdrucken
//				ants[i].print();
				if( ants[i].getLength() <shortest) {
					shortest= ants[i].getLength();
					shortestIndex= i;
				}
			}
			// Suche Ameisen, die alle den besten Weg gelaufen sind
			// Das lohnt aber nicht, weil das kaum vorkommt (Bei 15 Orten schon 15! Wege)
/*			for(int i=0; i<ants.length;i++){
				if(ants[shortestIndex].equals(ants[i]))
					map.signShortest(ants[i]);
			}
*/
			for(int i=0; i<ants.length;i++){
				map.signVerwittert(ants[i]);
				map.signShortest(ants[i]);
			}

			if( ants[shortestIndex].getLength()<globshortest) {
				globshortest= ants[shortestIndex].getLength();
				globshortestIndex= shortestIndex;
				ants[shortestIndex].print();
//				map.signShortest(ants[shortestIndex]);
				System.out.println(durchgang);
			}
//			ants[shortestIndex].print();
//			System.out.println(ants[shortestIndex].getLength());
		}
		System.out.println("Ende");
	}

}
