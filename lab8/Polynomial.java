package lab8;
/**
 * create some method for polynomial 
 * @author xinyu.yan
 *
 */

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

	final private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//
		// Set the instance variable (list) to be a new linked list of Double type
		//
		
		list = new LinkedList<Double>(); //inform java that the type of objects stored in the list are Doubles		
		//double coeff = list.getFirst();
		
	}

	/**
	 * returns a String representation of the polynomial.
	 */
	public String toString() {
		String result="";
		for (int i=0;i<list.size();i++)
			if (i==0)
				result += list.get(0)+" ";
			else if (i==1)
				result+="+"+list.get(1)+"x ";
			else
				result+=("+"+list.get(i)+"x^"+i+" ");
		return result;
		// FIXME
	}
	/**
	 * 
	 * @param coeff
	 * @return this polynomial 
	 */
	public Polynomial addTerm(double coeff) {
		this.list.add(coeff);
		return this;
	}
	
	/**
	 * 
	 * @param double x
	 * @return the double value of the polynomial at point x
	 */
	public double evaluate(double x) {
		Iterator<Double> i=this.list.iterator();
		return evalu(x,i);  // FIXME
	}
	
	/**
	 * 
	 * @param x
	 * @param i
	 * @return part of polynomial
	 * use this function for solve the evaluate problem in recursion way
	 */
	public double evalu(double x, Iterator<Double> i){
		if (!i.hasNext()){
			i=null;
			return 0;
		}
		else 
			return i.next() +x*evalu(x,i);
	}
	/**
	 * takes no parameters and returns a new Polynomial that is the first derivative of this polynomial
	 * @return polynomial
	 */
	public Polynomial derivative() {
		Polynomial result=new Polynomial();
		for (int i=1; i<list.size();i++)
			result.list.add(this.list.get(i)*i);
		return result;   // FIXME
	}
	
	/**
	 * takes another Polynomial as its parameter and returns a new Plolynomial that is the result of 
	 * adding together the two polynomials.
	 * @param another
	 * @return sum polynomial
	 */
	public Polynomial sum(Polynomial another) {
		Polynomial result=new Polynomial();
		if (this.list.size()==another.list.size()){
			for (int i=0;i<list.size();i++){
				result.list.add(this.list.get(i)+another.list.get(i));
			}
		}
		
		else if (this.list.size()<another.list.size()){
			for (int i=0;i<list.size();i++){
				result.list.add(this.list.get(i)+another.list.get(i));
			}
			for (int i=list.size();i<another.list.size();i++){
				result.list.add(another.list.get(i));
			}
		}
		
		else if (this.list.size()>another.list.size()){
			for (int i=0;i<another.list.size();i++){
				result.list.add(this.list.get(i)+another.list.get(i));
			}
			for (int i=another.list.size(); i<this.list.size();i++){
				result.list.add(this.list.get(i));
			}
		}
		return result;
	}

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}
