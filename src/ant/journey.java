package ant;

public class journey extends net{
	private locations allowed;
	
	journey() {
		this.allowed= new locations();
	}
	
	journey( locations allowed) {
		this.allowed= allowed.clone();
	}
	
	public void calcJourney(net map) {
		this.allowed.del(this.allowed.firstIndex());
		choose cs= new choose(map,allowed);
		way w= cs.bestWay();		
		while( w!= null) {
			this.wayAdd(w);
			this.allowed.del(allowed.find(w.end()));
			cs= new choose(map,w.end(),this.allowed);
			w= cs.bestWay();
		}
	}
	public void print() {
		System.out.println("Journey");
		super.print();
	}
}
