package studio2;

import cse131.ArgsProcessor;

public class GC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int length = ap.nextInt("Enter value for DNA");
		if(length==0)
			System.out.println("there is no Dna");
		
		double randnum=0.0;
		String Dna="";
		for (int i=1;i<=length;i=i+1){
			randnum=Math.random();
			if(randnum>=0 && randnum<=0.25)
				Dna+="A";
			else if(randnum>0.25 && randnum<=0.5)
				Dna+="T";
			else if(randnum>0.5 && randnum<=0.75)
				Dna+="C";
			else
				Dna+="G";}
			
		System.out.println(Dna);
		
		int c=0,g=0;
		double cg=0;
		for(int i=0;i<length;i=i+1){
			char r=Dna.charAt(i);
			if (r=='C')
				c=c+1;
			else if(r=='G')
				g=g+1;
		}
		cg=(c+g)/(double)length;
		cg=cg*1000;
		cg=Math.round(cg);
		cg=cg/ 10;
		System.out.println("the number of C is:"+c);
		System.out.println("the number of G is:"+g);
		System.out.println("the number of cg is:"+cg+"%");
		
		
		
	}

}
