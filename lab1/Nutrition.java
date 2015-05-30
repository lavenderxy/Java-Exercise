package lab1;

import cse131.ArgsProcessor;

public class Nutrition {
	
	
	public static double calculate(double x,double y,int i){
		double food=0;
		food = x*i/y; food = food*1000;
		food = Math.round(food); 
		food = food/10;	
		return food;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name=ap.nextString("Name");
		double carbs=ap.nextDouble("Carbs");
		double fat=ap.nextDouble("fat");
		double protein=ap.nextDouble("protein");
		int statedCals=ap.nextInt("statedCals");
		
		double totalCal;
		totalCal=carbs*4+fat*9+protein*4;
		double unCal,gramsFiber;
		unCal=(totalCal-statedCals)*10;
		unCal=Math.round(unCal);
		unCal=unCal/10;
		
		gramsFiber=unCal/4;
		
		double foodCar=calculate(carbs,statedCals,4);
		double foodFat=calculate(fat,statedCals,9);
		double foodPro=calculate(protein,statedCals,4);
		
		boolean accLowcarb,acclowfat,head;
		accLowcarb=(foodCar<=25);
		acclowfat=(foodFat<=15);
		boolean rannum = Math.random() < 0.5;
		
		System.out.println(name+" has");
		System.out.println("  "+carbs+" grams of carbohydrates = 138.0 Calories");
		System.out.println("  "+fat+" grams of fat = 122.4 Calories");
		System.out.println("  "+protein+" grams of protein = "+protein*4+" Calories");
		
		System.out.println("This food is said to have "+statedCals+" (available) Calories.");
		System.out.println("With "+unCal+" unavailable Calories, this food has "+gramsFiber+" grams of fiber");
		
		System.out.println("Approximately");
		System.out.println("  "+foodCar+"% of your food is carbohydrates");
		System.out.println("  "+foodFat+"% of your food is fat");
		System.out.println("  "+foodPro+"% of your food is protein");
		
		System.out.println("This food is acceptable for a low-carb diet?  "+accLowcarb);
		System.out.println("This food is acceptable for a low-fat diet?  "+acclowfat);
		System.out.println("By coin flip, you should eat this food?  "+rannum);
		
		
		

	}

}
