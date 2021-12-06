/**
* Simple derived (child) class from the AirTicket class that 
* creates new Economy objects that store ticket data and provides a 
* totalFare method, totalAwardMiles method, and toString method. 
* A constant is used to depict the economy award mile factor.
* 
* @author Winton Ebanks
* @version 18 November 2021
*/   
public class Economy extends AirTicket {
   
  /**
   * Constant - economy award mile factor.
   */
   public static final double E_AWARD_MILES = 1.5;
   
  /**
   * Creates a new Economy object and initializes the
   * instance variables of the parent class constructor (AirTicket)
   * with the data passed in.
   *
   * @param flightNumberIn The number of the flight.
   * @param tripDataIn The Itinerary of the flight.
   * @param baseFareIn The base fare of the flight.
   * @param fareAdjFactorIn The fare adjustment factor of the flight.
   */         
   public Economy(String flightNumberIn, Itinerary tripDataIn,
          double baseFareIn, double fareAdjFactorIn) {
          
      super(flightNumberIn, tripDataIn, baseFareIn, fareAdjFactorIn);
   }      
   
  /**
   * Gets the totalFare by multiplying base fare with fare adjustment factor.
   *
   * @return The Double representation of the total fare.
   */       
   public double totalFare() {
      return super.getBaseFare() * super.getFareAdjustmentFactor();
   }      
   
  /**
   * Call on parent class and returns an int that represents
   * the actual miles from the itinerary multiplied by the 
   * economy award mile factor.
   *
   * @return The Integer representation of miles from itinerary 
   * multiplied by economy award mile factor.
   */      
   public int totalAwardMiles() {
      return (int) (super.tripData.getMiles() * E_AWARD_MILES);
   }     
   
  /**
   * Returns a String representation of the Economy
   * object that includes the Itinerary and the economy
   * award mile factor.
   * 
   * @return String representation of an Economy object.
   */        
   public String toString() {
      return super.toString() + "\n   " 
         + "Includes Award Miles Factor: " + E_AWARD_MILES; 
   }     
}