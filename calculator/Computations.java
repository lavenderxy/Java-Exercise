package calculator;

public class Computations {
	
	
	/**Double operators**/
	//Return the result of adding d1 and d2.
	static double addDoubles(double d1, double d2) {
		double ans = d1 + d2;
		return ans;
	}
	
	//Return the result of subtracting d2 from d1.
	static double subtractDoubles(double d1, double d2) {
		double ans = d2-d1;  // FIXME
		return -ans;
	}
	
	//Return the result of dividing d1 by d2.
	static double divideDoubles(double d1, double d2) {
		double ans = d1/d2;  // FIXME
		ans=100000000*ans;
		ans=Math.round(ans);
		ans=ans/100000000;
		return ans;
	}
	
	//Return the result of multiplying d1 and d2.
	static double multiplyDoubles(double d1, double d2) {
		double ans = d1*d2;  // FIXME
		ans=100000000*ans;
		ans=Math.round(ans);
		ans=ans/100000000;
		return ans;
	}
	
	
	
	/**Int operators**/

	//Return the result of adding i1 and i2.
	static int addInts(int i1, int i2) {
		int ans = i1+i2; // FIXME
		return ans;
	}

	//Return the result of subtracting i2 from i1.
	static int subtractInts(int i1, int i2) {
		int ans = i2-i1; // FIXME
		return -ans;
	}
	
	//Return the result of dividing i1 by i2.
	static int divideInts(int i1, int i2) {
		int ans = i1/i2; // FIXME
		return ans;
	}
	
	//Return the result of multiplying i1 and i2.
	static int multiplyInts(int i1, int i2) {
		int ans = i1*i2; // FIXME
		return ans;
	}
	
	
	
	/**String operators**/	
	//	//Return the result of concatenating s2 to s1.
	static String concatenate(String s1, String s2) {
		String ans= s1+s2;
		return ans;  // FIXME
	}
	
	
	
	/**Boolean operators**/
	//Return the boolean value that results from an AND operation of b1 and b2
	static boolean andBoolean(boolean b1, boolean b2) {
		boolean ans=b1&&b2;
		return ans;  // FIXME
	}
	//Return the boolean value that results from an OR operation of b1 and b2
	static boolean orBoolean(boolean b1, boolean b2) {
		boolean ans=b1||b2;
		return ans;  // FIXME
	}
	
	/**Casting to int**/
	static int intToint(int in) {
		return in; // FIXME Auto-generated method stub
	}
	static int doubleToint(double in) {
		int ans= (int)in;
		return ans;  // FIXME
	}
	static int stringToint(String in) {
		error();
		return 0;  // FIXME
	}
	static int booleanToint(boolean in) {
		int ans=0;		
		return in?1:0;  // FIXME
	}
	
	
	/**Casting to double**/
	static double intTodouble(int in) {
		double ans=in;
		return ans;  // FIXME
	}
	static double doubleTodouble(double in) {
		return in;  // FIXME
	}
	static double stringTodouble(String in) {
		error();
		return 0.0;  // FIXME
	}
	static double booleanTodouble(boolean in) {
		double ans=0.0;
		if(in==true)
			ans=1.0;
		else if(in==false)
			ans=0.0;
		return in?1.0:0.0;  // FIXME
	}
	
	
	/**Casting to String**/
	static String intToString(int in) {
		String ans=""+in;
		return ans;  // FIXME
	}
	static String doubleToString(double in) {
		String ans=""+in;
		return ans;  // FIXME
	}
	static String stringToString(String in) {
		return in;  // FIXME
	}
	static String booleanToString(boolean in) {
		String ans=""+in;
		return ans;  // FIXME
	}
	
	
	/**Casting to Boolean**/
	static boolean intToboolean(int in) {
		boolean ans=(in !=0);
		return ans;  // FIXME
	}
	static boolean doubleToboolean(double in) {
		error();
		return true;  // FIXME
	}
	static boolean stringToboolean(String in) {
		boolean ans= false;
		ans=in.equals("true");
			
		return ans;  // FIXME
	}
	static boolean booleanToboolean(boolean in) {
		return in;  // FIXME
	}
	
	/**Error method**/
	//Call this when an operation is not possible, or doesn't make sense.  
	//Ex. Casting a string to boolean, casting a double to boolean.
	public static void error(){
		Calculator.calculator.errorDisplay("This operation is not possible.");
	}
}
