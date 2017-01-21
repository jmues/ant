package ant;

public class choose {
	private net netz;
	private location start;
	private locations allowed;
	private double alpha= 1.0;
	private double beta= 5.0;
	private double nenner= 1.0;

	private void calcN() {
		way w;
		this.nenner= 0.0;
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
		initchoose(n, s, al, 1.0, 5.0);
	}
	
	choose( net n, locations al) {
		location s= n.getFirstWay().start();
		initchoose(n,s,al,1.0,5.0);
	}
	public way bestWay() {
		way w;
		if(this.allowed.maxIndex()<0)
			return null;
		double pp[] = new double [this.allowed.maxIndex()+1];
		int i=0;
		for(location l=allowed.first(); l!= null; l= allowed.next()){
			w= this.netz.getWay(start,l);
			if( w!= null){
				pp[i++]=w.calcP(this.alpha, this.beta)/this.nenner;
//				System.out.println("p"+(i-1)+":"+pp[i-1]);
			}
		}
		rnd ppp= new rnd(pp);
		int val= ppp.run()-1;
//		System.out.println("val:"+val);
		return this.netz.getWay(start, this.allowed.get(val));
	}
	
}
