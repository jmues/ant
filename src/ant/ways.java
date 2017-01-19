package ant;

import java.util.ArrayList;
import java.util.List;

public class ways {
	private List<way> lway = null;
	private int index= -1;
	private int max =-1;
	
	ways() {
		lway = new ArrayList<way>();
		index=-1;
		max=-1;
	}
	
	public void add( way w) {
		this.lway.add(w);
		this.max++;
	}

	public void add( location start, location end) {
		this.lway.add(new way(start, end));
		this.max++;
	}
		
	public way first() {
		this.index= 0;
		if( this.max>=0)
			return this.lway.get(this.index);
		return null;
	}
	public int firstIndex() {
		this.index= 0;
		if( this.max>=0)
			return this.index;
		return -1;
	}
	
	public way next() {
		if( this.index< this.max)
			return this.lway.get(++this.index);
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
	
	public way get( int idx) {
		if(checkidx(idx))
			return this.lway.get(idx);
		return null;
	}
	
	public void del(int idx) {
		if(checkidx(idx)){
			if( this.index== this.max--)
				this.index--;
			this.lway.remove(idx);
		}	
	}
	
	public int find(way w) {
		return this.lway.indexOf(w);
	}

	
	public way getFirst(location start) {
		way ret= null;
		for( this.index=0; this.index<= this.max; this.index++)
			if((ret= this.lway.get(this.index).dub(start))!=null)
				return ret;
		return null;
	}

	public way getNext(location start) {
		way ret= null;
		for( ++this.index; this.index<= this.max; this.index++) {
			if((ret= this.lway.get(this.index).dub(start))!=null)
				return ret;
		}
		return null;
	}
}
