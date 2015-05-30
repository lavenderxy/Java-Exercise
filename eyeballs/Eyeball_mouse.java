package eyeballs;
 
public class Eyeball_mouse {

	double mx,my;
	double ex,ey;
	
	public Eyeball_mouse(double mx, double my, double ex, double ey){
		this.mx=mx;
		this.my=my;
		this.ex=ex;
		this.ey=ey;
	}
	
	public double get_mx(){
		return mx;
	}
	
	public double get_my(){
		return my;
	}
	
	public double get_ex(){
		return ex;
	}
	
	public double get_ey(){
		return ey;
	}
	
	public void set_mx(double mx){
		this.mx=mx;
	}
	
	public void set_my(double my){
		this.my=my;
	}
	
	public void set_ex(double ex){
		this.ex=ex;
	}
	
	public void set_ey(double ey){
		this.ey=ey;
	}
	
}
