package lab4;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

public class BumpingBalls {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
    	int number = ap.nextInt("Enter the number of balls:");
    	int iter = ap.nextInt("Enter the iteration times:");
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);

        // initial values
        double [][]balls_pos = new double [number][2];
        double [][]balls_vol = new double [number][2];
        double []balls_radius = new double [number];
        //initial balls value
        for (int i=0; i<number;i++){
        	for (int j=0; j<2; j++){
        		
        		balls_pos[i][j]=Math.random();      		
        		balls_vol[i][j]=Math.random()/200;
        		//System.out.println(balls_pos[i][j]);
        	
        	}	
    		balls_radius[i]=Math.random()/10;
        }
     
        double dist=0.0;
        double dist1=0.0;

        // main animation loop
        while (iter-->=0)  { 
        	StdDraw.clear();
        	StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0, 0, 2.0);
        	for (int i=0;i<number;i++){
            // bounce off wall according to law of elastic collision
        	/*
            if (Math.abs(balls_pos[i][0] + balls_vol[i][0]) > 1.0 - balls_radius[i] ) 
            	balls_vol[i][0]=-balls_vol[i][0];
            if (Math.abs(balls_pos[i][1] + balls_vol[i][1]) > 1.0 - balls_radius[i] ) 
            	balls_vol[i][1]=-balls_vol[i][1];  */
        		
        	if (balls_pos[i][0]<-1 && balls_vol[i][0]<0 ) 
                balls_vol[i][0]=-balls_vol[i][0];
        	if (balls_pos[i][0]>1 && balls_vol[i][0]>0 ) 
                balls_vol[i][0]=-balls_vol[i][0];
        	if (balls_pos[i][1]<-1 && balls_vol[i][1]<0 ) 
                balls_vol[i][1]=-balls_vol[i][1];
        	if (balls_pos[i][1]>1 && balls_vol[i][1]>0 ) 
                balls_vol[i][1]=-balls_vol[i][1];

            // update position
            balls_pos[i][0]=balls_pos[i][0]+balls_vol[i][0];
            balls_pos[i][1]=balls_pos[i][1]+balls_vol[i][1];
            
            for (int j=1;j<number;j++){
        		dist=Math.sqrt((balls_pos[j][0]-balls_pos[i][0])*(balls_pos[j][0]-balls_pos[i][0])
        				+(balls_pos[j][1]-balls_pos[i][1])*(balls_pos[j][1]-balls_pos[i][1]));
        		dist1=Math.sqrt((balls_pos[j][0]+balls_vol[j][0]-balls_pos[i][0]-balls_vol[i][0])*(balls_pos[j][0]+balls_vol[j][0]-balls_pos[i][0]-balls_vol[i][0])
        				+(balls_pos[j][1]+balls_vol[j][1]-balls_pos[i][1]-balls_vol[i][1])*(balls_pos[j][1]+balls_vol[j][1]-balls_pos[i][1]-balls_vol[i][1]));
        		
        		if (dist<=(balls_radius[i]+balls_radius[j])&& dist1<dist){
        			balls_vol[i][0]=-balls_vol[i][0];
        			balls_vol[j][0]=-balls_vol[j][0];
        			balls_vol[i][1]=-balls_vol[i][1];
        			balls_vol[j][1]=-balls_vol[j][1];
        		}
        		
        		balls_pos[i][0]=balls_pos[i][0]+balls_vol[i][0];
        		balls_pos[i][1]=balls_pos[i][1]+balls_vol[i][1];
        		balls_pos[j][0]=balls_pos[j][0]+balls_vol[j][0];
        		balls_pos[j][1]=balls_pos[j][1]+balls_vol[j][1];
        		
        		
        		}
            
        	}
        	// draw ball on the screen
            for (int i=0;i<number;i++){
            StdDraw.setPenColor(StdDraw.BLACK); 
            StdDraw.filledCircle(balls_pos[i][0], balls_pos[i][1], balls_radius[i]); 
            }
            
            // display and pause for 20 ms
            StdDraw.show(20); 
         
        }
	}
}
