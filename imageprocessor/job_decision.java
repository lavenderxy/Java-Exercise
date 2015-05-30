package imageprocessor;

public class job_decision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double p=0.001;
		boolean decision;
		double wealth1,wealth2;
		double EU_game=0, EU_programmer=0;
		wealth1=p*190000+(1-p)*5000;
		wealth2=((int)Math.random()*50001)+110000;
		
		EU_game=3*Math.sqrt(wealth1);
		EU_programmer=2*Math.sqrt(wealth2);
		
		if(EU_game>EU_programmer)
			decision=true;
		else
			decision=false;
		
		System.out.println("Gamer:"+(int)EU_game);
		System.out.println("Programmer:"+(int)EU_programmer);
		System.out.println("You should be a gamer and not a programmer?"+decision);
		
	}

}
