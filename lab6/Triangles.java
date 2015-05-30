package lab6;
import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;
/**
 * 
 * @author xinyu yan and shiyao liu
 * a class draw recursion triangles
 *
 */


public class Triangles {
	 public static void main(String []args){
		 StdDraw.setXscale(0,2);
		 StdDraw.setYscale(0,1);
		 
		 double []x =new double[]{0,1,2};
		 double []y = new double[]{0,0.5*Math.sqrt(3),0};
		 StdDraw.filledPolygon(x, y);
		 StdDraw.setPenColor(StdDraw.WHITE);
		 ArgsProcessor ap = new ArgsProcessor(args);
		 int num = ap.nextInt("How many iteration times?");
		 
		 draw(num,x,y);
		 
	 }
	 
	 /**
	  *  draw the recursion triangles
	  * @param n: number of recursion, when n==0,the method will stop
	  * @param x: array which store three vertices of the triangles, x-coordinates
	  * @param y: array which store three vertices of the triangles, y-coordinates
	  */
	 public static void draw(int n, double[]x, double []y){
		 StdDraw.setPenColor(StdDraw.WHITE);
		 if (n==0) return;
		 
		 double []xDiv = new double[]{x[0]+0.25*(x[2]-x[0]),x[0]+0.5*(x[2]-x[0]),x[0]+0.75*(x[2]-x[0])};
		 double []yDiv = new double[]{y[0]+0.5*(y[1]-y[0]),y[0],y[0]+0.5*(y[1]-y[0])};
		 StdDraw.setPenColor(StdDraw.WHITE);
		 StdDraw.filledPolygon(xDiv, yDiv);
		 
		 double []xUpper = new double[]{xDiv[0],x[1],xDiv[2]};
		 double []yUpper = new double[]{yDiv[0],y[1],yDiv[2]};
		 double []xLeft = new double[]{x[0],xDiv[0],x[1]};
		 double []yLeft = new double[]{y[0],yDiv[0],y[1]};
		 double []xRight = new double[]{xDiv[1],xDiv[2],x[2]};
		 double []yRight = new double[]{yDiv[1],yDiv[2],y[2]};
		 
		 
		 draw(n-1,xRight,yRight);
		 draw(n-1,xUpper,yUpper);
		 draw(n-1,xLeft,yLeft);
	 }
	
}
