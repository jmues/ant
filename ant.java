package Ant;

public class ant {
	static void fill_equal (double p[]) {
		for( int i=0; i<p.length;i++)
			p[i]=1.0/p.length;
	}

	static void fill_1 (double p[]) {
		p[0]=1.0/(2.0*p.length);
		double delta= 1.0/(2.0*(p.length-1));
		for( int i=1; i<p.length;i++)
			p[i]=p[0]+delta;
	}

	static void initcount( int c[]){
		for( int i=0; i<c.length;i++)
			c[i]=0;
	}
	
	public static void main(String[] args) {
		int cants=10; // Anzahl der Ameisen
		journey ants[]= new journey[cants]; // Reiseroute für jede Ameise
		locations locs= new locations(); // Die zu beuchenden Orte
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
		
		// Alle Ameisen nacheinander einen guten Weg finden lassen
		for( int i=0;i<ants.length;i++) {
			// i-te Ameise: Erlaubte Orte übergebens
			ants[i]= new journey(locs);
			// i-te Ameise : Eine gute Rundreise erzeugen
			ants[i].calcJourney(map);
			// i-te Ameise: Reise ausdrucken
			ants[i].print();
		}
	}
/* 	Test rnd
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ps[] = new double[10];
		fill_equal(ps);
		int count[]= new int[ps.length];
		initcount( count);
		rnd p= new rnd( ps);
		if( p.ok()) {
			System.out.println("p ist ok");
			double m=0.0;
			int n= 10000;
			int val;
			for( int i= 1; i<n;i++) {
				val= p.run();
				m+= (double)val;
				System.out.println(val);
				count[val-1]++;
			}
			System.out.println("Mittelwert "+ m/n);
			for( int i=0;i<count.length;i++)
				System.out.println("Wert "+(i+1)+" "+count[i]+" mal. p="+(double)count[i]/n);
		}
		else
			System.out.println("p not ok");

	}
*/
}
