package biofindframe;

import java.io.File;

import org.biojava3.core.sequence.DNASequence;

import biojava.SequenceLoader;
import cse131.ArgsProcessor;

public class FindTheFrame {
	
	//
	// Do not change any code from here....
	//

	public static void main(String[] args) {
		File file = ArgsProcessor.chooseFile("genomes");
		System.out.println("For " + file + ", best reading frame is " + runsolution(file));
	}
	
	public static int runsolution(File file) {
		//
		// Load the sequence into a DNASequence object
		//
		SequenceLoader sequenceLoader = new SequenceLoader();
		DNASequence dnaSequence = sequenceLoader.loadDNASequence(file);
		
		//
		// Convert the sequence to a string and then a char array
		//
		String dnaAsString = dnaSequence.getSequenceAsString().toUpperCase();
		char[] dnaAsCharArray = dnaAsString.toCharArray();
		
		//
		// Call your solution to compute the result
		//
		int frame = bestReadingFrame(dnaAsCharArray);
		
		return frame;
	}
	
	//
	// ... to here, so we can unit test your solution
	//
	
	/**
	 * 
	 * @param dna an array of char.  Each element is a nucleotide:  one of A, T, C, or G.
	 * @return the index at which the best reading frame occurs.  This would be 0, 1, or 2.
	 */
	public static int bestReadingFrame(char[] dna) {
		

		// Below, define each of the three Stop Codons as a separate array of char,
		//     named ochre, amber, and opal
		//     See http://en.wikipedia.org/wiki/Genetic_code#Start.2Fstop_codons

		char [] ochre = new char [3];
		char [] amber = new char [3];
		char [] opal = new char [3];
		
		ochre[0]='T'; ochre[1]='A'; ochre[2]='A';
		amber[0]='T'; amber[1]='A'; amber[2]='G';
		opal[0]='T'; opal[1]='G'; opal[2] ='A';
		
		// Below, define the Start Codon (Methionine) as an array of char
		//Start Codon
		char [] methionine =new char [3];
		methionine[0]='A'; methionine[1]='T'; methionine[2]='G';
		
		int ans = -1;  // returned if no appropriate sequences was found
		
		//
		// Follow the instructions in the extension write up
		//
		
		//char [] dna_arr = new char [1000];
	
		/*
		int flag=0, flag1=0, flag2=0;
		int count=0, count1=0, count2=0;
		int count_max=0,count_max1=0,count_max2=0;
		
		for (int i=0; i<(dna.length-2); i+=3){
			if (flag==0){
				if (dna[i]==methionine[0] && dna[i+1]==methionine[1] && dna[i+2]==methionine[2]){
					flag=1;
				 }					
			}
				if ((dna[i]==ochre[0] && dna[i+1]==ochre[1] && dna[i+2]==ochre[2])
					|| (dna[i]==amber[0] && dna[i+1]==amber[1] && dna[i+2]==amber[2] )
					|| (dna[i]==opal[0] && dna[i+1]==opal[1] && dna[i+2]==opal[2])){
				flag=0;
				if (count>count_max){
					count_max=count;
				}
				count = 0;
				
			}
			
			if (flag==1){
				count++;
			}	
			
		}    
		
		for (int i=1; i<(dna.length-2); i+=3){
			if (flag1==0){
				if (dna[i]==methionine[0] && dna[i+1]==methionine[1] && dna[i+2]==methionine[2]){
					flag1=1;		
				}				
			}
			
			if ((dna[i]==ochre[0] && dna[i+1]==ochre[1] && dna[i+2]==ochre[2])
					|| (dna[i]==amber[0] && dna[i+1]==amber[1] && dna[i+2]==amber[2] )
					|| (dna[i]==opal[0] && dna[i+1]==opal[1] && dna[i+2]==opal[2])){
				flag1=0;
				if (count1>count_max1){
					count_max1=count1;
				}
				count1=0;
			}		
			
			if (flag1==1){
				count1++;
			} 
			
			
		}    		
	
		for (int i=2; i<(dna.length-2); i+=3){
			if (flag2==0){
				if (dna[i]==methionine[0] && dna[i+1]==methionine[1] && dna[i+2]==methionine[2]){
					flag2=1;
				}				
			}
			
			if ((dna[i]==ochre[0] && dna[i+1]==ochre[1] && dna[i+2]==ochre[2])
					|| (dna[i]==amber[0] && dna[i+1]==amber[1] && dna[i+2]==amber[2] )
					|| (dna[i]==opal[0] && dna[i+1]==opal[1] && dna[i+2]==opal[2])){
				flag2=0;
				if (count2>count_max2){
					count_max2=count2;
					
				}
				count2=0;
			}	
			
			if (flag2==1){
				count2++;
			}
						
			
		} 		
		
		if (count_max==0 && count_max1==0 && count_max2==0)
		    ans=-1;
		else if (count_max>=count_max1 && count_max>=count_max2)
			ans=0;
		else if (count_max1>=count_max && count_max1>=count_max2)
			ans=1;
		else if (count_max2>=count_max && count_max2>=count_max1)
			ans=2;
		*/
	
		
		int flag=0;
		int [] count=new int [3];
		int [] count_max=new int [3];
		
		for (int j=0; j<3; j++){
			for (int i=j; i<(dna.length-2); i+=3){
				if (flag==0){
					if (dna[i]==methionine[0] && dna[i+1]==methionine[1] && dna[i+2]==methionine[2]){
						flag=1;
					}					
				}
				if ((dna[i]==ochre[0] && dna[i+1]==ochre[1] && dna[i+2]==ochre[2])
						|| (dna[i]==amber[0] && dna[i+1]==amber[1] && dna[i+2]==amber[2] )
						|| (dna[i]==opal[0] && dna[i+1]==opal[1] && dna[i+2]==opal[2])){
					flag=0;
					if (count[j]>count_max[j]){
						count_max[j]=count[j];
					}
				count[j] = 0;
				
				}
			
				if (flag==1){
					count[j]++;
				}	
			
			}
			
		}
		
		if (count_max[0]==0 && count_max[1]==0 && count_max[2]==0)
		    ans=-1;
		else if (count_max[0]>=count_max[1] && count_max[0]>=count_max[2])
			ans=0;
		else if (count_max[1]>=count_max[0] && count_max[1]>=count_max[2])
			ans=1;
		else if (count_max[2]>=count_max[0] && count_max[2]>=count_max[1])
			ans=2;
		
		return ans;
	}
	
	/*
	public static boolean isEqual(char c,char []a, char []b){
		boolean isequal=false;
		for (int i=0; i<(a.length-2);i++){
			for (int j=0; j<(b.length-2);j++)
				if (a[i]==a[j] && a[i+1]==b[j+1] && a[i+2]==b[j+2])
					isequal=true;
		}
		
		
		return isequal;
	}  */
	
}
