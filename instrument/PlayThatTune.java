package instrument;
import cse131.ArgsProcessor;
import sedgewick.*;
import sedgewick.StdDraw;
import java.awt.Color;

/*************************************************************************
 *  Compilation:  javac PlayThatTune.java
 *  Execution:    java PlayThatTune < input.txt
 *  Dependencies: StdAudio.java StdAudio.java
 *
 *  This is a data-driven program that plays pure tones from
 *  the notes on the chromatic scale, specified on standard input
 *  by their distance from concert A.
 *
 *  % java PlayThatTune < elise.txt
 *
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/99luftballons.txt
 *  http://www.cs.princeton.edu/introcs/21function/freebird.txt
 *  http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 *  http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/firstcut.txt 
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *
 *************************************************************************/

public class PlayThatTune {

    public static void main(String[] args) {
    	
    	ArgsProcessor.useStdInput("music");

        // repeat as long as there are more integers to read in
        while (!StdIn.isEmpty()) {
        	
            // read in the pitch, where 0 = Concert A (A4)
            int pitch = StdIn.readInt();

            // read in duration in seconds
            double duration = StdIn.readDouble();
            
            double []fk= new double [3];
            int numerator=1;
            int denominator=1;
            double rela_strength=0.75;
            fk[0]=numerator; fk[1]=denominator; fk[2]=rela_strength;
            
            // build sine wave with desired frequency
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int N = (int) (StdAudio.SAMPLE_RATE * duration);
            double[] a = new double[N+1];
            StdDraw.setXscale(0, 1.0);
            StdDraw.setYscale(-2.0, 2.0);
            for (int i = 0; i <= N; i++) {
                //a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            	a[i] = fk[2]*Math.sin(2 * Math.PI * i *fk[1]*fk[0]* hz / StdAudio.SAMPLE_RATE);
            }
         

            // play it using standard audio
            StdAudio.play(a);
            
            for (int j=0; j<= 1000; j++){
            	StdDraw.point((double)1/1000*j, 0.75*Math.sin(2*Math.PI*440*((double)1/(440*1000)*j)));
            	StdDraw.point((double)1/1000*j, 0.55*Math.sin(2*Math.PI*440*((double)1/(440*500)*j)));
            	StdDraw.point((double)1/1000*j, 0.35*Math.sin(2*Math.PI*440*((double)1/(440*1000/1.5)*j)));
            	//StdDraw.setPenColor(Color.RED);
            	StdDraw.point((double)1/1000*j, 0.75*Math.sin(2*Math.PI*440*((double)1/(440*1000)*j))+0.55*Math.sin(2*Math.PI*440*((double)1/(440*500)*j))+0.35*Math.sin(2*Math.PI*440*((double)1/(440*1000/1.5)*j)));
            	
           }
        }
    }
}
