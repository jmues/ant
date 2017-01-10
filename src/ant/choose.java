package ant;

public class choose {
	private net netz;
	private location start;
	private locations allowed;
	private double alpha= 0.5;
	private double beta= 0.5;
	private double nenner= 1.0;

	private void calcN() {
		way w;
		nenner= 0.0;
		for(location l=allowed.first(); l!= null; l= allowed.next()){
			w= this.netz.getWay(start,l);
			this.nenner= w.addN(this.nenner,this.alpha,this.beta);
		}
	}
	
	private void initchoose( net n, location s, locations al, double a, double b) {
		this.netz= n;
		this.alpha= a;
		this.beta= b; 
		this.start= s;
		this.allowed= al;
		this.calcN();
	}
	
	choose( net n, location s, locations al) {
		initchoose(n, s, al, 0.5, 0.5);
	}
	
	choose( net n, locations al) {
		location s= n.getFirstWay().start();
		initchoose(n,s,al,0.5,0.5);
	}
	public way bestWay() {
		//way max= null;
		way w;
		//double p=0.0;
		//double p1;
		if(this.allowed.maxIndex()<0)
			return null;
		double pp[] = new double [this.allowed.maxIndex()+1];
		int i=0;
		for(location l=allowed.first(); l!= null; l= allowed.next()){
			w= this.netz.getWay(start,l);
			/*if((w!=null) && (p1=w.calcP(alpha, beta)/nenner)>=p) {
				p=p1;
				max= w; */
			if( w!= null){
				pp[i++]=w.calcP(alpha, beta)/nenner;
			}
		}
		rnd ppp= new rnd(pp);
		int val= ppp.run()-1;
		return this.netz.getWay(start, this.allowed.get(val));
//		return max;
	}
}
