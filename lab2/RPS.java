package lab2;

import cse131.ArgsProcessor;

public class RPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		//String name=ap.nextString("Player:");
		double randnum=0.0;
		
		int real=0;
		int real2=1;
		int winforreal=0;
		int winforreal2=0;
		double p1,p2;
		
		int round=ap.nextInt("How many rounds of RPS to play?");
		for(int i=1;i<=round;i++){
			randnum=Math.random();
			if(randnum>=0 && randnum<=1.0/3)
				real=1;
			else if(randnum>1.0/3 && randnum<=2.0/3)
				real=2;
			else
				real=3;
			
			if((real-real2)==-1)
				winforreal2++;
			else if((real-real2)==1)
				winforreal++;
			else if((real-real2)==-2)
				winforreal++;
			else if((real-real2)==2)
				winforreal2++;
						
			if(real2<3)
				real2++;
			else if(real2==3)
				real2=1;
			
			//System.out.println("The "+i+"th round result is:");
			//System.out.println("The real choose "+real2);
		}
		p1=(double)winforreal/round;
		p2=(double)winforreal2/round;
		p1=p1*100;
		p2=p2*100;
		p1=Math.round(p1);
		p2=Math.round(p2);
		p1=p1/100;
		p2=p2/100;
		System.out.println("The fraction for p1 is: "+p1);
		System.out.println("The fraction for p2 is: "+p2);
		
		
	}

}
