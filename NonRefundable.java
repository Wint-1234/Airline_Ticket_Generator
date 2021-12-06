/**
* Simple derived (child) class from the AirTicket class that 
* creates new NonRefundable objects that store ticket data and  
* provides "getter" methods, a toString method, a totalFare method,
* and a totalAwardMiles method to manipulate the object.
* 
* @author Winton Ebanks 
* @version 18 November 2021
*/    
public class NonRefundable extends AirTicket {
   
      //Instance variable
   private double discountFactor;
      
  /**
   * Creates a new NonRefundable object and initializes the
   * instance variables of the parent class constructor (AirTicket)
   * with the data passed in; discount factor is also updated.
   *
   * @param flightNumberIn The number of the flight.
   * @param tripDataIn The Itinerary of the flight.
   * @param baseFareIn The base fare of the flight.
   * @param fareAdjFactorIn The fare adjustment factor of the flight.
   * @param discountFactorIn The discount factor of the flight.
   */         
   public NonRefundable(String flightNumberIn, Itinerary tripDataIn,
          double baseFareIn, double fareAdjFactorIn, 
          double discountFactorIn) {
          
      super(flightNumberIn, tripDataIn, baseFareIn, fareAdjFactorIn);
          
      discountFactor = discountFactorIn;  
   }
   
  /**
   * Gets the discount factor.
   *
   * @return The Double representation of the discount factor.
   */      
   public double getDiscountFactor() {
      return discountFactor;
   }
   
  /**
   * Gets the totalFare by multiplying base fare with fare adjustment factor 
   * and discount factor.  
   *
   * @return The Double representation of the total fare.
   */       
   public double totalFare() {
      return super.getBaseFare() * super.getFareAdjustmentFactor() 
         * discountFactor;
   }
  
  /**
   * Call on parent class and returns an int that represents
   * the actual miles from the itinerary.
   *
   * @return The Integer representation of miles from itinerary .
   */      
   public int totalAwardMiles() {
      return super.tripData.getMiles();
   }
  
  /**
   * Returns a String representation of the NonRefundable
   * object that includes the Itinerary and the discount factor.
   * 
   * @return String representation of an NonRefundable object.
   */        
   public String toString() {
      return super.toString() + "\n   " 
         + "Includes DiscountFactor: " + getDiscountFactor(); 
   } 
}