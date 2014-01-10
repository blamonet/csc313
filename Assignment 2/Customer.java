// Aaron Grant
// Program 2
// CSC 313

import java.text.NumberFormat;

class Person {
   private String name;
   private String address;
   private Object item;
   public Person( String n, String a, Object i ) {
      name = n;
      address = a;
      item = i;
   }
   public Person( String n ) {
   	  Purchase i = new Purchase("Brim Hat", 49.95);
      name = n;
      address = "404 Internet Ave.";
      item = i;
   }
   
public String toString() {
	String customerString = "\nName: " + name + "\n"
						  + "Address: " + address + "\n"
						  + item + "\n";
	return customerString;
}
}

class Purchase {
   private String item;
   private String currency;
   private double amountSpent;
   public Purchase( String i, double a ) {
      item = i;
      amountSpent = a;
   }
   
public String toString() {
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	String purchaseString = "Item Name: " + item + "\n"
						  + "Amount: " + currency.format(amountSpent) + "\n";
	return purchaseString;
}
}

class Customer extends Person {
   private String n;
   private String a;
   private Purchase thing;
   
   Customer( String n ) {
      super( n );
}
   Customer( String n, String a, Object thing ) {
      super( n, a, thing );
    }  
}

