// Aaron Grant
// CSC 313
// Program #4
// April 1, 2003

import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;

public class P4 {
	
   public static void main(String[] args){
      String choice = "";
      Stack s = new Stack();
      String conNum = "";
      int div = 0;
      int R = 0;
      String numString = "";
      String baseString = "";
      int baseInt = 0;
      int numInt = 0;
      String Remainder = "";
      String baseTest = "Fail";
  
      try {
      while (numInt >= 0){   // begin while loop

         
         
         // number input
          
         while (numString.equalsIgnoreCase(""))
         numString = JOptionPane.showInputDialog("Enter a Number ");
         
            try 
		    { 
		     numInt = Integer.parseInt(numString); 
		    } 
	     	catch(NumberFormatException nfe) 
		    { 
				System.out.println(numString + " is not a number!"); 
		      	System.exit(0);    
		    } 
	     
		 
  	     div = numInt;
  	     
  	     if (numInt < 0) 
  	           System.exit(0);
   		 
   		
   		 // base input
	
         while (!((baseInt > 1) && (baseInt < 17))) {
         	
         	while (baseString.equalsIgnoreCase("") || baseTest.equalsIgnoreCase("Fail")) {
            baseString = JOptionPane.showInputDialog("Enter a Base ");
            
            
            try 
		    { 
   	     	 baseInt = Integer.parseInt(baseString);
		    } 
	     	catch(NumberFormatException nfe) 
		    { 
				System.out.println(baseString + " is not a number!"); 
		      	System.exit(0);    
		    } 
		    
            if ((baseInt > 1) && (baseInt < 17))
               baseTest = "Pass";
        }
		}
		
		   
 
   			 
         while (div != 0) {
         	R = div%baseInt;
         	
         	if (R == 15) {
         	Remainder = "F";
          	s.push(Remainder);    
          	}    	
          	if (R == 14) {
         	Remainder = "E";
          	s.push(Remainder);    
          	}    	
          	if (R == 13) {
         	Remainder = "D";
          	s.push(Remainder);    
          	}    
          	if (R == 12) {
         	Remainder = "C";
          	s.push(Remainder);    
          	} 	
          	if (R == 11) {
         	Remainder = "B";
          	s.push(Remainder);    
          	} 
          	if (R == 10) {
         	Remainder = "A";
          	s.push(Remainder);    
          	} 
          	if (R < 10) {
         	Remainder = String.valueOf(R);
         	s.push(Remainder);
            }
            
         	div = div/baseInt;
         }
         
  	     while (!s.isEmpty()) {
  	       conNum = conNum + s.pop();
  	   }

         String message = "Number at Base 10: " + numString + "\n"
         				+ "Convert Base 10 to Base " + baseInt + "\n\n"
                        + "Converted Number : " + conNum + "\n";
                        
         JOptionPane.showMessageDialog(null, message, "Input", JOptionPane.PLAIN_MESSAGE);

         s.makeEmpty();
         numString = "";
         baseString = "";
         baseInt = 0;
         numInt = 0;
         Remainder = "";
         conNum    = "";
         baseTest = "Fail";
  	 }}
  		 catch (NullPointerException e) { 
      		System.exit(0);
   		 }             
      System.exit(0);
}
      
}

