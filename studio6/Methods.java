package studio6;

public class Methods {

	public static int fact(int i) {
		
		if (i==0)
			return 1;
		else
			return i*fact(i-1);
			
	}

	public static int fib(int i) {
		if (i==0)
			return i;
		else if (i==1)
			return i;
		else
			return (fib(i-1)+fib(i-2));
	}

	public static boolean isOdd(int i) {
		if (i==0)
			return false;
		else
			return (!isOdd(i-1));
	}

	public static int sum(int a, int b) {
		if (b==0)
			return a;
		else
			return (sum(a+1,b-1));
	}
	
	public static int factorial(int n){
		if (n==0)
			return 1;
		else
			return (n*factorial(n-1));
	}

	public static int sumDownBy2(int n) {
		// TODO Auto-generated method stub
		if (n==0 ||n==1)
			return n;
		else 
			return (n+sumDownBy2(n-2));
	}

	public static double harmonicSum(int i) {
		if (i==1)
			return 1;
		else 
			return (1/(double)i+harmonicSum(i-1));
		
	}

	// Your methods go below this line
	
	
	
}
