import java.text.DecimalFormat;
  
/**
* Simple derived (child) class from the AirTicket class that 
* creates new Business objects that store ticket data and provides a 
* totalFare method, totalAwardMiles method, and toString method. 
*
* @author Winton Ebanks 
* @version 18 November 2021
*/   
public class Business extends AirTicket {
   
   //Instance variables
   protected double foodBeverages, entertainment; 

  /**
   * Constant - business award mile factor.
   */
   public static final double B_AWARD_MILES = 2.0;
   
  /**
   * Creates a new Business object and initializes the
   * instance variables of the parent class constructor (AirTicket)
   * with the data passed in. Also initializes the instance variables 
   * of the business class with the remaining parameters.
   *
   * @param flightNumberIn The number of the flight.
   * @param tripDataIn The Itinerary of the flight.
   * @param baseFareIn The base fare of the flight.
   * @param fareAdjFactorIn The fare adjustment factor of the flight.
   * @param foodBeveragesIn The amount of food and beverages alloted.
   * @param entertainmentIn The amount of entertainment alloted.      
   */         
   public Business(String flightNumberIn, Itinerary tripDataIn,
          double baseFareIn, double fareAdjFactorIn, 
          double foodBeveragesIn, double entertainmentIn) {
          
      super(flightNumberIn, tripDataIn, baseFareIn, fareAdjFactorIn);
      
      foodBeverages = foodBeveragesIn;
      entertainment = entertainmentIn;  
   }       

  /**
   * Gets the totalFare by multiplying base fare with fare adjustment factor
   * and then adding food & beverages and entertainment.
   *
   * @return The Double representation of the total fare.
   */       
   public double totalFare() {
      return super.getBaseFare() * super.getFareAdjustmentFactor() 
         + foodBeverages + entertainment;
   }   
   
  /**
   * Call on parent class and returns an int that represents
   * the actual miles from the itinerary multiplied by the 
   * business award mile factor.
   *
   * @return The Integer representation of miles from itinerary 
   * multiplied by business award mile factor.
   */      
   public int totalAwardMiles() {
      return (int) (super.tripData.getMiles() * B_AWARD_MILES);
   }   

  /**
   * Returns a String representation of the Business
   * object that includes the Itinerary and the Business
   * award mile factor. Food/Beverage and entertainment
   * are also displayed.
   * 
   * @return String representation of an Business object.
   */        
   public String toString() {
   
     //Decimal format for results.   
      DecimalFormat df = new DecimalFormat("$#,##0.00");  
   
      return super.toString() + "\n   " 
         + "Includes Food/Beverage: " + df.format(foodBeverages) 
         + " Entertainment: " + df.format(entertainment); 
   }  
}