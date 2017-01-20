package ant;

public class net {
	private ways ways;
	private double length=0;

	net() {
		this.ways = new ways();
		this.length= 0.0;
	}

	public void wayAdd(location start, location end) {
		this.ways.add(start,end);
		this.length+=start.distance(end);
	}

	public void wayAdd(way w) {
		this.ways.add(w);
		this.length+=w.length();
	}
	
	public boolean containsWay(way w) {
		return this.ways.find(w)>=0?true:false;
	}

	public int indexWay(way s) {
		return this.ways.find(s);
	}

	public boolean containsWay(location loc1, location loc2) {
		for (way w=this.ways.first(); w!=null ; w=this.ways.next()) {
			if (w.contains(loc1, loc2))
				return true;
		}
		return false;
	}

	public int indexWay(location loc1, location loc2) {
		for (way w=this.ways.first(); w!=null ; w=this.ways.next()) {
			if (w.containsLoc(loc1, loc2))
				return this.ways.find(w);
			}
		return -1;
	}

	public way getWay(location loc1, location loc2) {
		way ret= null;
		for (way w=this.ways.first(); w!=null ; w=this.ways.next())
			if( (ret= w.dub(loc1, loc2))!=null)
				return ret;
		return null;
	}

	public way getFirstWay(location start) {
		way ret = null;
		ret= this.ways.getFirst(start);
		return ret;
	}

	public way getNextWay(location start) {
		way ret = null;
		ret= this.ways.getNext(start);
		return ret;
	}
	
	public void addAllWays( locations locs) {
		for(int i=0; i<= locs.maxIndex();i++)
			for( int j=i+1;j<=locs.maxIndex();j++)
				this.wayAdd( locs.get(i), locs.get(j));
	}
	
	public void calcAllWays(locations loc) {
		for(int i=0; i<= loc.maxIndex();i++)
			for( int j=i+1;j<=loc.maxIndex();j++)
				this.wayAdd( loc.get(i), loc.get(j));
	}
	
	
	public way getFirstWay() {
		return this.ways.first();
	}
	
	public double getLength() {
		return this.length;
	}
	
	public void signShortest( journey j) {
		for( way w= this.ways.first(); w!= null; w= this.ways.next()) {
			w.pheromonVerwittert(0.9);
			if(j.containsWay(w))
				w.pheromonAdd(1.0/j.getLength());
		}
		
	}
	public void print() {
		System.out.println("Net");
		for( way w= this.ways.first();w!=null;w=this.ways.next()) {
			location s= w.start();
			location e= w.end();
			System.out.print("Start - ");
			s.print();
			System.out.print("End   - ");
			e.print();
			System.out.println("Pheromon "+w.pheromon()+"-----------------");
		}
		System.out.println("Length:"+this.length);
		System.out.println("==========================");
	}
	
	public boolean equals( Object n) {
		boolean ret= false;
		way w= this.ways.first();
		way w1= ((net)n).ways.first(); 
		while( w1!=null&&w!=null&&w.equals(w1)) {
			w= this.ways.next();
			w1= ((net)n).ways.next();
		}
		if( w1== null&& w==null)
			ret= true;
		return ret;
	}
}
