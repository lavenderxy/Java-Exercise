package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
    	int N = ap.nextInt("Enter the number of people enter the room:");
    	
    	int month=(int)(Math.random()*11+1);
    	int day=(int)(Math.random()*30+1);
    	
    	int count=0;
    	int count1=0;
    	int count2=0; int count3=0; 
    	//int [] count = new int [12];
    	double [] percent_month = new double [12];
    	double [] percent_day = new double [31];
    	int ave_month=0;
    	int sum_month = 0;
    	int sum_day = 0;
    	
    	int[][] person= new int [N][2];
   
    	for (int i=0;i<N;i++){
    		person[i][0]=(int)(Math.random()*11+1);
    		person[i][1]=(int)(Math.random()*30+1);
    	}
    	
    	for (int i=0;i<12;i++){
    		count=0;
    		for (int j=0;j<N;j++){
    			if (person[j][0]==i+1){
    				count++;
    			}
    		percent_month[i]= (double)count/N;
    		percent_month[i]=percent_month[i]*1000;
    		percent_month[i]=(int)percent_month[i];
    		percent_month[i]=percent_month[i]/1000;
    		
    		}
    		System.out.println("the percent of people born in month "+(i+1)+":" +percent_month[i]);
    	
    	}
    	
    	for (int i=0;i<N;i++){
    		sum_month+=person[i][0];
    	}
    	System.out.println("the average of the 12 values: "+(double)sum_month/N);
    	
    	for (int i=0;i<31;i++){
    		count1=0;
    		for (int j=0;j<N;j++){
    			if (person[j][1]==i+1){
    				count1++;
    			}
    		percent_day[i]= (double)count1/N;
    		percent_day[i]=percent_day[i]*1000;
    		percent_day[i]=(int)percent_day[i];
    		percent_day[i]=percent_day[i]/1000;
    		
    		}
    		System.out.println("the percent of people born in day "+(i+1)+":" +percent_day[i]);
    	
    	}
    	
    	for (int i=0;i<N;i++){
    		sum_day+=person[i][1];
    	}
    	System.out.println("the average of the 31 values: "+(double)sum_day/N);
    	
    	/*
    	for (int i=0;i<N;i++){
    		for (int j=i+1; j<N;j++){
    			if ((person[i][0]==person[j][0]) && (person[i][1]== person[j][1])){
    				count2++;
    			}
    		}
    	} */
    	
    	for (int i=0;i<12;i++){
    		for (int j=0; j<31;j++){
    			count2=0;
    			for (int k=0; k<N;k++){
    				if ((person[k][0]==i) && (person[k][1]== j)){
    					count2++;
    				}
    			}
    			if (count2>1)
    				count3+=count2;
			
       		}
    	}
    
    	System.out.println("the fraction of people born on the same day: "+ (double)count3/N);
    	
    	/*
    	for (int i=0;i<N;i++){
    		for (int j=0;j<2;j++)
    			System.out.print(person[i][j]);
    	
    	System.out.println("");}   */   	 
    	
	}

}
