//Example main program that runs with Customer.java

public class P2Drive {

  public static void main ( String args [] )  {
	
   Purchase item = new Purchase ( "Toys", 29.99);
   Customer aCust = new Customer ("Linda M. Hicks", "213D MSB", item);
   Customer bCust = new Customer ( "A.E. Neuman");
   
   System.out.println (" aCust: " + aCust );
   System.out.println (" bCust: " + bCust ); 
	
  } // end main


} // end p2drive.java