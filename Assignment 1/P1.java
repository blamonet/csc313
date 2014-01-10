import java.io.*; 
import java.util.*;

/** Program modified by Aaron Grant, CSC 313, September 27th, 2001

     A simple Java starter program to read lines of text
     from a text file whos name is supplied on the command
     line when the program is executed.

     If no file name is supplied then read from standard input.
     Use Ctrl/Z to terminate standard input from keyboard.

  */

public class P1 {

   /** A first program to read a list of Names and marks.
     * It prints the Names and scores for the three highest marks.
     * @param args[0] the name of an optional input
     *    file.
     * @exception java.io.IOException
     *    An I/O failure can occur
     */

     public static void main( String[] args)
                            throws IOException { 

      // input file may be supplied in the first  argument 
      InputStream istream; 
     System.out.println ("Aaron Grant\nCSC 313 Java\nProgram #1 - String Manipulation\n\n");

      if ( args.length > 0 ) 

      {
         File inputFile = new File( args[0] );
         istream = new FileInputStream( inputFile );
      } 

      else {
         // if no filename provided, use standard input stream
         // Tell user to teminate input with Ctrl/Z
        istream = System.in;
        System.out.println ("Reading input from keyboard, terminate with CTrl/Z");

      }

      // use a buffered reader for line-at-a-time reading
      BufferedReader lineReader; 
      lineReader = new BufferedReader(
                   new InputStreamReader(istream) );
         // read one line at a time until file is empty

      String line;

      while ( (line = lineReader.readLine()) != null) 
      {        
            // Echo on standard output line read in.
            // You may wish to delete this line from your program.    
                char separator = '/';                       // Substring separator

    // Determine the number of sub-strings
    int index = 0;
    int count = 0;   
    
           do
           {
            ++count;
            ++index; 
            index = line.indexOf(separator, index);
            }
            while(index != -1);
            
          // Extract the sub-string into an array    
         String[] subStr = new String[count];    // Allocate for substrings
         index = 0;                                       // Substring start index
         int endIndex = 0;                            // Substring end index
     
     for(int i = 0; i < count; i++)
            {
          endIndex = line.indexOf(separator,index); // Find next separator
          if(endIndex == -1)                        // If it is not found
            subStr[i] = line.substring(index);      // extract to the end
          else                                      // otherwise
            subStr[i] = line.substring(index, endIndex);  // to end index
          index = endIndex + 1;                // Set start for next cycle
            }

         String monthstr = subStr[0];
         String daystr = subStr[1];
         String yearstr = subStr[2];


        // String array of the months
        String  [] months = {"January", "February", "March","April","May","June","July","August","September", "October","November","December"};

        // Changing Varibles from Strings to Integers
        int month;
        month = Integer.parseInt(monthstr);
        // Adjust month so it can be used for months array which is set from 0 to 11
        month--;
        int day;
        day = Integer.parseInt(daystr);
        int year;
        year = Integer.parseInt(yearstr);


        // Creating th, rd, nd, and st behind the day of the month
        String dayend = "th";
        if (day == 1 || day == 21)
            dayend = "st";
        if (day == 2 || day == 22)
            dayend ="nd";
        if (day == 3 || day == 23)
            dayend ="rd";
            
        // makes 4 digit year instead of 2
        if (year <= 25)
            year = year + 2000;
        else
            year = year + 1900;
            
       //looped output for echo input and formated input
        System.out.println ( "echo input \t\t [" + line + "] ");
        System.out.println("formatted input \t" + months[month] + " " + day + dayend + " " + year + "\n");

      }  // end of while loop to read input lines
       // Code to delay ending the program, so output appears on the screen       

        System.out.println("(press Enter to exit)");
        try
        {
          System.in.read();           // Read some input from the keyboard
         }
        catch (IOException e)          // Catch the input exception
        {
          return;                      // and just return
        }

   }  // end of main
} // end of class

