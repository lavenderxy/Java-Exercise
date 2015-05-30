package lab3;

import cse131.ArgsProcessor;

public class MineSweeper {

	public static void main (String[] args) {
		
		//
		// Do not change anything between here ...
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int cols = ap.nextInt("How many columns?");
		int rows = ap.nextInt("How many rows?");
		double percent = ap.nextDouble("What is the probability of a bomb?");
		//
		// ... and here
		//
		//  Your code goes below these comments
		//

		double [][]set=new double [rows][cols];
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				double randnum=Math.random();
				set[i][j]=randnum;
			}	
		}
		
	/*	for (int i=0;i<rows;i++){
			for (int j=0;j<cols;j++){

				if (set[i][j]<=percent)
					System.out.print("* ");
				else if(set[i][j]>percent)
					System.out.print(". ");
			}
			System.out.println("");
		} */
		
		for (int i=0;i<rows;i++){
			for (int j=0;j<cols;j++){

				if (set[i][j]<=percent)
					set[i][j]=1;
				else if(set[i][j]>percent)
					set[i][j]=0;
			}
		} 
		
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if (set[i][j]==1)
					System.out.print("* ");
				else if (set[i][j]==0)
					System.out.print(". ");
			}
			System.out.println("");
		}
		int [][]set1=new int [rows][cols];
		for (int i=0;i<rows;i++){
			for (int j=0;j<cols;j++){
				set1[i][j]=(int)set[i][j];
			}
		} 
		
		int num;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if (set1[i][j]==1)
					System.out.print("* ");
				else if (set1[i][j]==0){
					
					if (i==0){
						if(j==0){
							set1[0][0]=(int)(set[0][1]+set[1][0]+set[1][1]);
							System.out.print((int)set1[i][j]+" ");
						}
						else if (j==(cols-1)){
							set1[0][cols-1]=(int)(set[0][cols-2]+set[1][cols-2]+set[1][cols-1]);
							System.out.print((int)set1[i][j]+" ");
						}
						else{
							set1[i][j]=(int)(set[0][j-1]+set[1][j-1]+set[1][j]+set[1][j+1]+set[0][j+1]);
							System.out.print((int)set1[i][j]+" ");
						}
					}
		
					else if (i==(rows-1)){
						//set1[i][j]=(int)set[i][j];
						if (j==0){
							set1[i][j]=(int)set[i][j];
							set1[i][j]=(int)(set[i-1][j]+set[i-1][j+1]+set[i][j+1]);
							System.out.print((int)set1[i][j]+" ");
						}
						else if (j==(cols-1)){
							set1[i][j]=(int)set[i][j];
							set1[i][j]=(int)(set[i-1][j-1]+set[i-1][j]+set[i][j-1]);
							System.out.print((int)set1[i][j]+" ");
						}
						else{
							set1[i][j]=(int)set[i][j];
							set1[i][j]=(int)(set[i-1][j-1]+set[i-1][j]+set[i-1][j+1]+set[i][j-1]+set[i][j+1]);
							System.out.print((int)set1[i][j]+" ");
						}
					}
					else{
			
						if (j==0){
							set1[i][j]=(int)set[i][j];
							set1[i][j]=(int)(set[i-1][j]+set[i-1][j+1]+set[i][j+1]+set[i+1][j]+set[i+1][j+1]);
							System.out.print((int)set1[i][j]+" ");
						}
						else if (j==(cols-1)){
							set1[i][j]=(int)set[i][j];
							set1[i][j]=(int)(set[i-1][j-1]+set[i-1][j]+set[i][j-1]+set[i+1][j-1]+set[i+1][j]);
							System.out.print((int)set1[i][j]+" ");
						}
						else{
							set1[i][j]=(int)set[i][j];
							set1[i][j]=(int)(set[i-1][j-1]+set[i-1][j]+set[i-1][j+1]+set[i][j-1]
								+set[i][j+1]+set[i+1][j-1]+set[i+1][j]+set[i+1][j+1]);
							System.out.print((int)set1[i][j]+" ");
						}
					}   
					
					//System.out.print((int)set1[i][j]+" ");
				}
			}
			System.out.println("");
		}
		
		
	}

}
