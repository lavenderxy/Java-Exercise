package eyeballs;

import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Eyeballs {
	

	/**
	 * @param args
	 */
	public static final int MOUSEPRESS=0;
	public static final int MOUSERELEASE=1;
	public static final int MOUSECLICK=2;
	public static List<Eyeball_mouse>eye= new ArrayList<Eyeball_mouse>();
	
	private static void draw(){
		double eyex=StdDraw.mouseX()+0.02;
		double eyey=StdDraw.mouseY();
		//eye.add(new Eyeball_mouse(StdDraw.mouseX(),StdDraw.mouseY(),eyex,eyey));
		System.out.println(eye.get(0).get_ex()+","+eye.get(0).get_ey());
		
		StdDraw.setPenColor(StdDraw.BLACK); 
		StdDraw.circle(StdDraw.mouseX(), StdDraw.mouseY(), 0.03);
		
		StdDraw.setPenColor(StdDraw.RED); 
		StdDraw.filledCircle(eyex,eyey , 0.01);	
	}
	
	private static void mouse_move(){
		for (int j=0; j<eye.size();j++){
			//mx=ex+dx
			//my=ey+dy
			//(0.03-0.01*2)/d=delta(x)/dx. delta(x)=0.01*dx/d
			
			double mx = eye.get(j).get_mx();
			double my = eye.get(j).get_my();
			double dx = StdDraw.mouseX()-mx;
			double dy = StdDraw.mouseY()-my;
			double d = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
			double ex = StdDraw.mouseX()-dx+0.016*dx/d;
			double ey = StdDraw.mouseY()-dy+0.016*dy/d;
			
			eye.get(j).set_ex(ex);
			eye.get(j).set_ey(ey);
			
		} 
		
	}
	
	private static void draw_eyeball(){
		for (int j=0; j<eye.size();j++){
			//mx=ex+dx
			//my=ey+dy
			//(0.03-0.01*2)/d=delta(x)/dx. delta(x)=0.01*dx/d
			
			double mx = eye.get(j).get_mx();
			double my = eye.get(j).get_my();
			double ex = eye.get(j).get_ex();
			double ey = eye.get(j).get_ey();
			
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.circle(mx,my,0.03);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(ex, ey, 0.01);  				
			
		}
	}
	
	private static void draw_eye(){
		double mx=StdDraw.mouseX();
		double my=StdDraw.mouseY();
		double ex=StdDraw.mouseX()+0.02;
		double ey=StdDraw.mouseY();
		eye.add(new Eyeball_mouse(mx,my,ex,ey));
		//System.out.println(eye.get(0).get_mx()+"," +eye.get(0).get_my()+","+eye.get(0).get_ex()+","+eye.get(0).get_ey());
		
		StdDraw.setPenColor(StdDraw.BLACK); 
		StdDraw.circle(StdDraw.mouseX(), StdDraw.mouseY(), 0.03);
		
		StdDraw.setPenColor(StdDraw.RED); 
		StdDraw.filledCircle(ex,ey , 0.01);	   
	}
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		StdDraw.picture(0.5, 0.5, "images/ken.jpg");
		int N = ap.nextInt("How many eyeballs?");
		
		int state= MOUSERELEASE;
		int count=0;
		
		while (true){
			
			StdDraw.clear();
			StdDraw.picture(0.5, 0.5, "images/ken.jpg");
			draw_eyeball();
					
			switch(state){
			

				case MOUSEPRESS:
					if (!StdDraw.mousePressed())
						state=MOUSECLICK;
					break;
					
				case MOUSERELEASE:
					//	System.out.println("click");
				
					mouse_move();
					
					if (StdDraw.mousePressed()){
						state=MOUSEPRESS;
					}

					break;
					
				case MOUSECLICK:
					//System.out.println("clicked");

					if (count<N){
						draw_eye();
										
					}
					
					state = MOUSERELEASE;
					count++;
					
					break;
				default:break;
			}
			
			StdDraw.show(50);
		}
		
	}

}
