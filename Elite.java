import java.text.DecimalFormat;
   
/**
* Simple derived (child) class from the Business class that 
* creates new Elite objects that store ticket data and provides a 
* totalFare method, totalAwardMiles method, and toString method. 
*
* @author Winton Ebanks 
* @version 18 November 2021
*/   
public class Elite extends Business {

   //Instance variables
   private double commServices;
   
  /**
   * Creates a new Elite object and initializes the
   * instance variables of the parent class constructors 
   * (AirTicket and Business) with the data passed in.
   * Also initializes the instance variables 
   * of the Elite class with the remaining parameter.
   *
   * @param flightNumberIn The number of the flight.
   * @param tripDataIn The Itinerary of the flight.
   * @param baseFareIn The base fare of the flight.
   * @param fareAdjFactorIn The fare adjustment factor of the flight.
   * @param foodBeveragesIn The amount of food and beverages alloted.
   * @param entertainmentIn The amount of entertainment alloted. 
   * @param commServicesIn The amount of communication services alloted. 
   */         
   public Elite(String flightNumberIn, Itinerary tripDataIn,
          double baseFareIn, double fareAdjFactorIn, 
          double foodBeveragesIn, double entertainmentIn, 
          double commServicesIn) {
          
      super(flightNumberIn, tripDataIn, baseFareIn, fareAdjFactorIn, 
            foodBeveragesIn, entertainmentIn);
      
      commServices = commServicesIn;  
   }    
   
  /**
   * Gets the totalFare by calling super.totalFare() and 
   * adding communication services.
   *
   * @return The Double representation of the total fare.
   */       
   public double totalFare() {
      return super.totalFare() + commServices;
   }       
   
  /**
   * Returns a String representation of the Elite
   * object that includes the toString method of the
   * Business class and adds communication services.
   * 
   * @return String representation of an Elite object.
   */        
   public String toString() {
   
     //Decimal format for results.   
      DecimalFormat df = new DecimalFormat("$#,##0.00");  
   
      return super.toString() + "\n   " 
         + "Includes: Comm Services: " + df.format(commServices); 
   }      


}