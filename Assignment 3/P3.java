// Aaron Grant
// CSC 313
// Assignment 3

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Date;
import java.text.DateFormat;

public class P3 {
	
   public static void main(String[] args){
      String choice = "";
  
   try {   
      while (!(choice.equalsIgnoreCase("x"))){   // begin while loop
      
      	 long age=0;
      	 long days;


         String birthDateString = JOptionPane.showInputDialog("Enter birthdate: (MM/DD/YYYY) ");

         while (birthDateString.equals("")) {
         	birthDateString = JOptionPane.showInputDialog("Birthdate required: (MM/DD/YYYY) ");
         }

         while ((birthDateString.indexOf("/") != 2) && (birthDateString.indexOf("/") != 5)) {
         	birthDateString = JOptionPane.showInputDialog("Birthdate requires proper formatting: (MM/DD/YYYY) ");
         }


         String gradDateString = JOptionPane.showInputDialog("Enter graduation date: (MM/DD/YYYY) ");
         while (gradDateString.equals("")) {
         	gradDateString = JOptionPane.showInputDialog("Graduation date required: (MM/DD/YYYY) ");
         }
         while ((gradDateString.indexOf("/") != 2) && (birthDateString.indexOf("/") != 5)) {
         	gradDateString = JOptionPane.showInputDialog("Graduation date requires proper formatting: (MM/DD/YYYY) ");
         }
         
         
         DateParser birthDate = new DateParser(birthDateString);
         DateParser gradDate  = new DateParser(gradDateString);
         long birthMS = birthDate.getMS();
         long gradMS  = gradDate.getMS();
         Date now = new Date();
         long currentdate = now.getTime();
                  
         age = (gradMS - birthMS);
         age = age/1000/60/60/24/365;
         days = (gradMS - currentdate);
         days = days/1000/60/60/24;


         String message = "BirthDate total: " + birthDateString + "\n"
         				+ "GradDate total: " + gradDateString + "\n\n"
         				+ "Age at graduation: " + age + "\n"
         				+ "Days until graduation: " + days + "\n\n"
                        + "Press Enter to continue or 'x' to exit.\n";
                        
         choice = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.PLAIN_MESSAGE);
      } // end while loop
   }
   catch (NullPointerException e) { 
      System.exit(0);
   }
      System.exit(0);
}
      
}

