package lab7;
/**
 * create the Course class which includes name, credits, a number of seats and a roster of students
 * @author xinyu.yan
 *
 */

public class Course {

	//instance variables
	String name;
	int seats;
	int credits;
	Student []studentRoster;
	int remainingSeats;


	//a constructor that takes in the name, credits and seats and initializes all of the instance variables
	public Course(String name, int credits, int seats){
		this.name=name;
		this.credits=credits;
		this.seats=seats;
		remainingSeats=seats;
		studentRoster= new Student[seats];

	}
	/**
	 * get remaining seats
	 * @return remainingSeats
	 */
	public int getRemainingSeats(){
		return remainingSeats;
	}

	/**
	 * get name
	 * @return name
	 */
	public String getName(){
		return name;
	}

	/**
	 * returns a string representation of the course that includes the course name and number of credits
	 */
	public String toString(){
		return this.name+this.credits;
	}

	/**
	 * takes a Studetn as a parameter and attempts to add them to the course
	 * if student is added successfully return true, if not return false
	 * @param stu
	 * @return true or false
	 */
	public boolean addStudent(Student stu){
		if (this.getRemainingSeats()>=1){	
			studentRoster[seats-remainingSeats]=stu;
			remainingSeats--;
			return true;
		}
		else
			return false;
	}

	/**
	 * prints the name and studentID of all of the students 
	 */
	public void printRoster(){

		for (int i=0; i<(seats-remainingSeats);i++){
			System.out.println(this.studentRoster[i].getName()+this.studentRoster[i].studentID);
		}
	}

	/**
	 * computes and returns the average GPA of all of the students in the course
	 * @return average gpa
	 */
	public double averageGPA(){
		double gpa=0.0;
		for (int i=0; i<(seats-remainingSeats);i++){
			gpa+=this.studentRoster[i].getGPA();}
		return gpa/(this.seats-this.remainingSeats);
	}

	public static void main(String[] args){
		Course course = new Course("ESE 501",3,100);
		Student s1 = new Student("Sally","Brown",300020); 
		Student s2 = new Student("David","Watson",200203);
		Student s3 = new Student("John","Walman",329930);
		//System.out.println("Student Roster:");
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		course.printRoster();
	}


}
