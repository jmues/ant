package ant;

public class way {
	private location start = null;
	private location end = null;
	private double length = 0.0;
	private double pheromon = 0.0;

	way(location start, location end) {
		this.start = start;
		this.end = end;
		this.length = this.lengthCalc();
		this.pheromon = 1.0;
	}
	way(location start, location end, double p) {
		this.start = start;
		this.end = end;
		this.length = this.lengthCalc();
		this.pheromon = p;
	}
	
	public way copy() {
		return new way(this.start,this.end, this.pheromon);
	}
	public way copyrev() {
		return new way(this.end,this.start, this.pheromon);
	}
	
	public location start() {
		return this.start;
	}

	public location end() {
		return this.end;
	}

	public double length() {
		return this.length;
	}

	public double pheromon() {
		return this.pheromon;
	}

	private double lengthCalc() {
		return this.start.distance(this.end);
	}
	
	public double addN(double n, double a, double b) {
		if(length==0)
			length= lengthCalc();
		if(length==0)
			return n;
		n+= Math.pow(1.0/length,a)*Math.pow(pheromon,b);
		return n;
	}

	public double calcP(double a, double b) {
		if(length==0)
			length= lengthCalc();
		if(length==0)
			return 0;
		double n= Math.pow(1.0/length,a)*Math.pow(pheromon,b);
		return n;
	}

	public void print(){
		System.out.print("way Start:");
		this.start.print();
		System.out.print("way End  :");
		this.end.print();
		System.out.println("way length:"+this.length+" pheromon: "+this.pheromon);
		System.out.println("---------------------");
	}
	
	public boolean containsLocStart( location loc)
	{
		if( this.start.equals(loc))
			return true;
		return false;
	}
	public boolean containsLocEnd( location loc)
	{
		if( this.end.equals(loc))
			return true;
		return false;
	}
	public boolean containsLoc( location loc)
	{
		if( this.containsLocStart(loc))
			return true;
		if( this.containsLocEnd(loc))
			return true;
		return false;
	}
	public boolean containsLoc(location loc1, location loc2) {
		if( containsLoc(loc1)&&containsLoc(loc2))
			return true;
		return false;
	}
	public boolean contains(location start, location end) {
		if( containsLocStart(start)&&containsLocEnd(end))
			return true;
		return false;
	}
	
	public way dub(location start, location end) {
		if( this.containsLocStart(start)) {
			if( this.containsLocEnd(end))
				return this.copy();
		}
		else if( this.containsLocStart(end))
			if( this.containsLocEnd(start))
				return this.copyrev();
		return null;
}
	public way dub(location start) {
		if( this.containsLocStart(start))
			return this.copy();
		if( this.containsLocEnd(start))
			return this.copyrev();
		return null;
	}
	
}
