/*
	ISYS 320
	Name(s):AlfurhudSolomon
	Date: Apr22, 2018
*/

import java.util.Scanner;

public class P1_FindMinAndMax {

	public static void main(String[] args) {
        Scanner console = new Scanner( System.in );
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // YOUR CODE STARTS HERE
        
        int x = 0;
        
        while(x != -1) {
        	
        	System.out.print("Type a number (or -1 to stop):");
        	int input = console.nextInt();
        	
        	if(input != -1) {   		
        	
        		if(input > -1) {
		        	if(input < min && min != Integer.MIN_VALUE) {
		        		min = input;
		        	} else if(min == Integer.MIN_VALUE) {
		        		min = input;
		        	}
		       	
		        	if(input > max && max != Integer.MAX_VALUE) {
		        		max = input;
		        	} else if(max == Integer.MAX_VALUE) {
		        		max = input;
		        	}
        		}
	       	
        	} else {
        		x = -1;
        	}
        }
        
        // YOUR CODE ENDS HERE
        
        System.out.println( "Maximum was " + max );
        System.out.println( "Minimum was " + min );
    }

}
