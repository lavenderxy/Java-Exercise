package lab7;
/**
 * create the student class which includes first name, last name, student ID, credits and GPA
 * @author xinyu.yan
 *
 */

public class Student {
	
	//instance variables
	String firstName;
	String lastName;
	int studentID;
	int credits;
	double gpa;
	/**
	 * create a public constructor 
	 * which takes three parameters and assigns their values to appropriate instance variables
	 * when we create student objects, we'll want to supply the first name, last name and studentID for them
	 */
	public Student(String firstName, String lastName, int studentID ){
		this.firstName=firstName;
		this.lastName=lastName;
		this.studentID=studentID;
		this.credits=0;
		this.gpa=0.0;
	}
	
	/**
	 * create a method for Student class 
	 * that returns that student's full name and studentID
	 */
	public String toString(){
		return firstName+lastName+studentID;
	}
	
	/**
	 * get the first name and last name
	 * @return firstName and lastName
	 */
	public String getName(){
		return firstName+" "+lastName;
	}
	
	
	/**
	 * get the student ID
	 * @return studentID
	 */
	public int getStudentID (){
		return studentID;
	}
	
	/**
	 * get the credits
	 * @return c
	 */
	public int getCredits (){
		return credits;
	}
	
	/**
	 * get the GPA
	 * @return gpa
	 */
	public double getGPA() {
		return gpa;
	}
	
	/**
	 * distinguish student according to the credits
	 * @return the class of the student based on how many credits they have
	 */
	public String getClassStanding(){
		if (credits<30)
			return "Freshman";
		else if (credits>=30 && credits<60)
			return "Sophomore";
		else if (credits>=60 && credits<90)
			return "Junior";
		else
			return "Senior";
	}
	
	/**
	 * a student to be graduated if they have 120 or more cerdits
	 * @return true if the student has graduated
	 */
	public boolean isGraduated(){
		if (credits>=120)
			return true;
		else
			return false;
	}
	
	/**
	 * takes in a Student as a parameter 
	 * returns true if the currentStudent (this student)
	 * has a higher GPA than the input student
	 * false otherwise
	 * @param stu
	 * @return true OR false
	 */
	public boolean hasHigherAverage(Student stu){
		if (this.gpa>stu.gpa)
			return true;
		else 
			return false;
	}
	
	/**
	 * update the student's GPA
	 * @param grade (course grade)
	 * @param credit (course credits associated with the grade)
	 */
	public void submitGrade(double grade, int credit){
		double deltaGpa=(grade*credit+this.gpa*this.credits)/(credit+this.credits);
		this.credits+=credit;
		this.gpa= (double)Math.round(deltaGpa*1000)/1000; 	
	}
	
	/**
	 * determines how much tution the student has paid so far
	 * @return the tuition
	 */
	public double computeTuition(){
		int sem= (int)Math.round(credits/18.0);
		sem=sem>0?sem:1;                   //if the semester is equals to 0, which means it is less than 1, it shuld be 1
			
		return sem*22850.0;
		
	}
	
	/**
	 * the parameter student and "this " studetn create a baby
	 * @param stu
	 * @return baby
	 */
	public Student createBaby(Student stu){
		Student baby=new Student(stu.getName(),this.getName(),(int)Math.random()*899999+100000);
		baby.gpa= (stu.gpa+this.gpa)/2;
		if (this.credits<stu.credits)
			baby.credits=stu.credits;
		else
			baby.credits=this.credits;
		
		return baby;
	}
}
