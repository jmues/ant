package Ant;

public class location {
	private String name;
	double pos[] = { 0.0, 0.0 };

	location(String name) {
		this.name = new String(name);
		pos[0] = pos[1] = 0.0;
	}

	location(String name, double x, double y) {
		this.name = new String(name);
		pos[0] = x;
		pos[1] = y;
	}

	public String getName() {
		return this.name;
	}

	public double getX() {
		return pos[0];
	}

	public double getY() {
		return pos[1];
	}

	public location clone() {
		location ret = new location(this.name, this.getX(), this.getY());
		return ret;
	}
	
	public double distance( location loc) {
		return Math.sqrt(
				Math.pow(this.getX() - loc.getX(), 2) + Math.pow(this.getY() - loc.getY(), 2));
	}
	
	public void print() {
		System.out.println("Name: "+this.name+" x:"+this.pos[0]+" y:"+this.pos[1]);
	}
	
	public boolean equals( Object loc) {
		if( loc== null)
			return false;
		if( loc==this)
			return true;
		if( !this.name.equals(((location)loc).name))
			return false;
		if( this.pos[0]!=((location)loc).pos[0]||this.pos[1]!=((location)loc).pos[1])
			return false;
		return true;
	}
}
