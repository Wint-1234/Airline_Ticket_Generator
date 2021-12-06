import java.text.DecimalFormat;

/**
* Simple abstract (parent) class that creates AirTicket 
* objects that store ticket data and provides "getter"  
* methods for the instance variables, a toString method, 
* and two abstract methods (totalFare and totalAwardMiles).
* 
* @author Winton Ebanks 
* @version 18 November 2021
*/ 
public abstract class AirTicket implements Comparable<AirTicket> {

   //Instance variables
   protected String flightNumber;
   protected Itinerary tripData;
   protected double baseFare, fareAdjFactor;
   
  /**
   * Creates a new AirTicket object and initializes the
   * instance variables with the data passed in.
   *
   * @param flightNumberIn The number of the flight.
   * @param tripDataIn The Itinerary of the flight.
   * @param baseFareIn The base fare of the flight.
   * @param fareAdjFactorIn The fare adjustment factor of the flight.
   */
   public AirTicket(String flightNumberIn, Itinerary tripDataIn,
          double baseFareIn, double fareAdjFactorIn) {
      
      flightNumber = flightNumberIn;
      tripData = tripDataIn;
      baseFare = baseFareIn;
      fareAdjFactor = fareAdjFactorIn;
   }
   
  /**
   * Gets the flight number.
   *
   * @return The String representation of the flight number.
   */ 
   public String getFlightNum() {
      return flightNumber;
   }   

  /**
   * Gets the base fare of the flight.
   *
   * @return The Double representation of the flight's base fare.
   */ 
   public double getBaseFare() {
      return baseFare;
   }  

  /**
   * Gets the fare adjustment factor of the flight.
   *
   * @return The Double representation of the flight's fare adjustment factor.
   */ 
   public double getFareAdjustmentFactor() {
      return fareAdjFactor;  
   }

  /**
   * Returns a String representation of the AirTicket
   * object that includes the flight number, trip data
   * total award miles, base fare, fare adjustment factor,
   * and total fare.
   * 
   * @return String representation of an AirTicket object.
   */  
   public String toString() {
   
     //Decimal format for results.   
      DecimalFormat df = new DecimalFormat("$#,##0.00");
        
      String result = "Flight: " + flightNumber + "\n"
         + tripData +  " (" + totalAwardMiles() + " award miles)"
         + "\n" + "Base Fare: " + df.format(baseFare) 
         + " Fare Adjustment Factor: " + fareAdjFactor + "\n" 
         + "Total Fare: " + df.format(totalFare())
         + " (" + this.getClass() + ")";
               
      return result;
   }  

  /**
   * Abstract method that returns the total fare as a double, all 
   * subclasses of AirTicket must implement totalFare method.
   *
   * @return The double representation of total fare.
   */      
   public abstract double totalFare();
   
  /**
   * Abstract method that returns the award miles as an int, all 
   * subclasses of AirTicket must implement totalAwardMiles method.
   *
   * @return The int representation of total award miles.
   */       
   public abstract int totalAwardMiles();
   
  /**
   * Compares two AirTicket objects, based on flightNumber, and 
   * returns an int result of the comparison.
   *
   * @param ticketIn The AirTicket obj to compare against.
   * @return The int representation of comparing AirTicket objs based
   * based on the flight number value.
   */      
   public int compareTo(AirTicket ticketIn) {
      return (flightNumber).compareTo(ticketIn.getFlightNum());
   }
   
  /**
   * Returns the itinerary field, tripData, of the 
   * AirTicket obj.
   *
   * @return The Itinerary field of AirTicket obj.
   */      
   public Itinerary getItinerary() {
      return tripData;
   }
   
}



