package watermelons;

import java.util.Arrays;

public class Watermelons {
	
	/**
	 * Computes the sum of each distinct pair of entries in the incoming array.
	 * A given pair of entries has its sum computed only once.  So if you
	 * compute the sum for entries 2 and 4, and that sum appears in your answer
	 * array, then you do not also compute the sum of entries 4 and 2.
	 * Depending on the input, the same sum value may appear multiple times in the result.
	 * For example, if all of the incoming values are 0, then so are all of the returned values.
	 * @param nums an array of integers, possibly containing duplicates
	 * @return an array containing the sums of pairs as described above
	 */
	public static int[] allPairSums(int[] nums) {
		
		int length= (nums.length*(nums.length-1))/2;
		int[] ans = new int[length] ;  // FIXME compute ans as the result you want
		
		int index=0;
		
		for (int i=0; i<(nums.length-1); i++){
			for (int j=i+1; j<nums.length;j++){
				ans[index]=nums[i]+nums[j];
				index++;
			}
		}		
		
		return ans;
	}
	
	/**
	 * The method below must COMPUTE and return a solution to the puzzle posted
	 * on the page that describes this extension.  You must compute the solution by trying
	 * lots of possibilities, and finding the one that yields the right answer.
	 * You can run the unit test testPuzzleSolution to see if you are right.
	 * @return
	 */
	public static int[] getSolution() {
		int [] sum_all = new int[] {20,22,23,24,25,26,27,28,30,31};
		int [] sum_now = new int[10];
		int [] melon=new int [5] ;
		int melon1=0,melon2=0,melon3=0,melon4=0,melon5=0;
		
		
		for (int i=0; i<31 ;i++){
			for (int j=0;j<31;j++){
				for (int k=0; k<31;k++){
					for (int m=0; m<31; m++){
						for (int n=0; n<31; n++){
							melon[0]=i;melon[1]=j;melon[2]=k;melon[3]=m;melon[4]=n;
							sum_now=allPairSums(melon);
							Arrays.sort(sum_now);
							if (Arrays.equals(sum_now, sum_all)){
								melon1=i; melon2=j; melon3=k; melon4=m; melon5=n;
							}
								
						}
					}
				}
			}
		}
		
		return new int[] { melon1,melon2,melon3,melon4,melon5 };
		
		
		
	}

}
