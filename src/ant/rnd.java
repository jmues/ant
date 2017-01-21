package ant;
import java.util.Random;

public class rnd {
	private double p[]= null;
	private double range[][]= null;
	private double eps=0.0001;
	
	rnd(double p1[]) {
		double sum=0.0;
		this.p= new double [p1.length];
		for (int i=0; i<p.length; i++) {
			this.p[i]=p1[i];
			sum+= p1[i];
		}
		if(!check()) {
			p=null;
			return ;
		}
		range= new double[p1.length][2];
		double prev=0.0;
		for( int i=0;i<p.length;i++){
			range[i][0]= prev;
			prev+= p[i]/sum;
			range[i][1]= prev;
		}
	}
	
	private boolean check() {
		if( this.p!=null) {
			double sum=0;
			for (int i=0; i<p.length;i++)
				if( p[i]>1 || p[i]<0)
					return false;
				else
					sum+= p[i];
			if( sum <1.0-eps|| sum>1.0+eps)
				return false;
			if( sum <eps)
				return false;
		}
		return true;
	}
	
	public boolean ok() {
		return this.p!=null;
	}
	
	public int run() {
		Random w= new Random();
		double wi= w.nextDouble();
		for (int i=0; i<this.p.length;i++)
			if(this.range[i][0]<= wi&& wi<this.range[i][1])
				return i+1;
		return this.p.length;
	}
}
