package Ant;
import java.util.ArrayList;
import java.util.List;

import Ant.location;

public class locations {
	private List<location> llocation = null;
	private int index=-1;
	private int max= -1;
	
	locations() {
		this.llocation = new ArrayList<location>();
		this.index= 0;
		this.max= -1;
	}

	public void add( location loc) {
		this.llocation.add(loc);
		this.max++;
	}

	public void add( String name, double start, double end) {
		location loc= new location(name, start, end);
		this.add(loc);
	}
	
	public int maxIndex(){
		return this.max;
	}
	
	public location first() {
		this.index= 0;
		if( this.max>=0)
			return this.llocation.get(this.index);
		return null;
	}
	
	public int firstIndex() {
		this.index= 0;
		if( this.max>=0)
			return this.index;
		return -1;
	}
	
	public location next() {
		if( this.index< this.max)
			return this.llocation.get(++this.index);
		return null;
	}
	
	public int nextIndex() {
		if( this.index< this.max)
			return ++this.index;
		return -1;
	}
	
	
	private boolean checkidx(int idx) {
		return idx>=0&&idx<=this.max;
	}
	
	public location get( int idx) {
		if(checkidx(idx))
			return this.llocation.get(idx);
		return null;
	}
	
	public void del(int idx) {
		if(checkidx(idx)){
			if( this.index== this.max--)
				this.index--;
			this.llocation.remove(idx);
		}	
	}
	public int find(location loc) {
		return this.llocation.indexOf(loc);
	}
	
	public locations clone() {
		locations ret= new locations();
		for(location l= this.first();l!= null;l=this.next())
			ret.add( l.clone());
		return ret;
	}
	
}
