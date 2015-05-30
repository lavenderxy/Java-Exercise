package lab6;
/**
 * 
 * @author xinyu.yan
 *
 */

public class Methods {
	
	//
	// In this class, implement the f and g functions described on the lab page
	//

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//
		// from here, call f or g with the appropriate parameters
		//
	
		System.out.println(f(99));	

	}
	/**
	 * an interesting recursive function
	 * @param x: the input value
	 * @return function value
	 */
	public static int f (int x){
		if (x>100)
			return (x-10);
		else
			return f(f(x+11));
	}
	
	/**
	 * calculate exponential
	 * @param n: the number
	 * @param k: the exponential of numbers
	 * @return the value of n^k
	 */

	public static int expt(int n, int k) {
		if (k==0)
			return 1;
		else{
			return n*expt(n,(k-1));
		}	
	}

	/**
	 * to judge the word is palindrome or not
	 * @param string: input string which need to be tested
	 * @return true of false
	 */
	public static boolean isPalindrome(String string) {
		String string1="";
		
		if (string.length()<=1)
			return true;
		else if (string.charAt(0) != string.charAt(string.length()-1))
			return false;
		return isPalindrome(string.substring(1, string.length()-1));
		
	}

}

