package lab5;
/**
 * 
 * @author xinyu.yan
 * a class includes six method 
 */

public class Lab5Methods {

	/**
	 * given two positive integers and use iteration 
	 * and repeated addition to form the product
	 * @param i
	 * @param j
	 * @return the product j*k
	 */
	public static int multPos(int j, int k){
		int sum=0;
		for (int i=0; i<j; i++){
			sum+=k;
		}
		return sum;		
	}
	
	/**
	 * given two integers (positive, negative or zero) 
	 * and returns their product
	 * @param integer j
	 * @param integer k
	 * @return the product j*k
	 */
	public static int mult(int j, int k){
		int result=0;
		if ((j<0 && k<0) || (j>0 && k>0) ){
			if (j<0) j=-j;
			if (k<0) k=-k;
			result=multPos(j,k);
		}
		else if (j==0 || k==0){
			result=0;
		}
		else{
			if (j<0) j=-j;
			if (k<0) k=-k;
			result=-multPos(j,k);
		}
		return result;
	}
	/**
	 * use repeated multiplication to calculate exponentiation
	 * @param n
	 * @param k
	 * @return the value of n to the power k
	 */
	public static int expt(int n, int k){
		int result=1;
		for (int i=0; i<k; i++){
			result*=n;
		}		
		return result;
	}

	/**
	 * to determine whether or not s is a palindrome.
	 * A palindrome is a word that reads the same forwards and backwards.
	 * we assume that there will not be any spaces or punctuation in the string.
	 * @param a string s
	 * @return if the string is a palindrome, return true, or return false.
	 */
	public static boolean isPalindrome(String s){
		String s1="";
		for (int i=(s.length()-1); i>=0;i--){
			s1+=s.charAt(i);
		}
		if (s1.equals(s))
			return true;
		return false;
	}
	
	/**
	 * given a positive integer n, return an array that contains the 
	 * first n Fibonacci numbers.
	 * @param a positive integer n
	 * @return n Fibonacci numbers
	 */
	public static int[] fibonacci(int n){
		int [] fibo=new int [n];
		
		if (n==1)
			fibo[0]=1;
		if (n==2){
			fibo[0]=1;
			fibo[1]=1;
		}
		if (n>=3){
			fibo[0]=1;
			fibo[1]=1;
			for (int i=2; i<n;i++){
				fibo[i]=fibo[i-1]+fibo[i-2];
			}
		}
			
		return fibo;
	}
	
	/**
	 * according to the scores of labs, quizzes, exams, studio and extentions 
	 * to calculate the course grade 
	 * @param double array labs
	 * @param double array quizzes
	 * @param double array exams
	 * @param boolean studio
	 * @param int extentions
	 * @return
	 */
	public static String computeGrade(double[]labs, double[]quizzes, double[]exams, boolean studio, int extentions){
		double sumLabs=0,avgLabs=0;
		double sumQuizzes=0, avgQuizzes=0, minQuizzes=100;
		double sumExams=0, avgExams=0;
		double scoreStudio=0;
		double finalScore=0;
		String grade="A+";
		
		//calculate the average score of labs
		for (int i=0; i<labs.length;i++){
			sumLabs+=labs[i];
		}
		avgLabs=sumLabs/labs.length;
		
		//remove the least value of quizzes
		for (int i=0; i<quizzes.length;i++){
			if (quizzes[i]<=minQuizzes)
				minQuizzes=quizzes[i];
		}
		//calculate the average score of quizzes
		for (int i=0; i<quizzes.length;i++){
			if (quizzes[i]==minQuizzes){
				quizzes[i]=0;
				break;}
		}
		for (int i=0; i<quizzes.length;i++){
			sumQuizzes+=quizzes[i];
		}
		avgQuizzes=sumQuizzes/(quizzes.length-1);
		
		//calculate the average score of exams
		for (int i=0; i<exams.length;i++){
			sumExams+=exams[i];
		}
		avgExams=sumExams/exams.length;
		
		//calculate the studio score
		if (studio==true)
			scoreStudio=100;
		
		//extention value
		if (extentions>100)
			extentions=100;
		
		finalScore=scoreStudio*0.1+avgLabs*0.15+extentions*0.2+avgExams*0.45+avgQuizzes*0.1;
		//System.out.println("finalscore: "+finalScore+"avgLab: "+avgLabs+", scoreStudio: "+scoreStudio+", exteneions: "+extentions+", avgExams: "+avgExams+", avgQuizzes: "+avgQuizzes);
		
		if (finalScore>=97 && finalScore<=100)
			grade="A+";
		else if (finalScore>=93)
			grade="A";
		else if (finalScore>=90)
			grade= "A-";
		else if (finalScore>=87)
			grade= "B+";
		else if (finalScore>=83)
			grade= "B";
		else if (finalScore>=80)
			grade= "B-";
		else if (finalScore>=77)
			grade= "C+";
		else if (finalScore>=73)
			grade= "C";
		else if (finalScore>=70)
			grade= "C-";
		else if (finalScore>=60)
			grade= "D";
		else if (finalScore>=0)
			grade= "F";
		
		return grade;
				
	}

}
