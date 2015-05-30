package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int rows = ap.nextInt("The number of rows:");
		
		int cols=rows;
		int [][]triangle=new int [rows][cols];
		
		for (int i=0;i<rows;i++){
			for (int j=0;j<=i;j++){
				if (j==0){
				triangle[i][j]=1;}
				else if (i==j){
					triangle[i][j]=1;
				}
				else if (i<0 || j<0 || j>i){
					triangle[i][j]=0;
				}
				else{
					triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
				}
				System.out.print(triangle[i][j]);
			}
			System.out.println("");
		}
		
		
	}

}
