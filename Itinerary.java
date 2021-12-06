/**
* Simple parent class that creates an Itinerary object 
* for an airline. Various methods are provided to perform
* operations on the objects such get departure 
* date/time, get miles, and toString.
* 
* @author Winton Ebanks 
* @version 18 November 2021
*/
public class Itinerary {
   
   //Instance variables
   private String fromAirport, toAirport;
   private String departureDateTime, arrivalDateTime;
   private int miles; 
   
  /**
   * Creates a new Itinerary object and initializes the
   * instance variables with the data passed in.
   *
   * @param fromAirportIn The abbreviation of the departure airport.
   * @param toAirportIn The abbreviation of the arrival airport.
   * @param departureDateTimeIn The departure date and time.
   * @param arrivalDateTimeIn The arrival date and time.
   * @param milesIn The travel distance in miles.
   */
   public Itinerary(String fromAirportIn, String toAirportIn, 
      String departureDateTimeIn, String arrivalDateTimeIn, int milesIn) {
   
      fromAirport = fromAirportIn;
      toAirport = toAirportIn;
      departureDateTime = departureDateTimeIn;
      arrivalDateTime = arrivalDateTimeIn;
      miles = milesIn; 
   }
   
  /**
   * Gets the name of the departure airport.
   *
   * @return The String representation of the departure airport field.
   */ 
   public String getFromAirport() {
      return fromAirport;
   }
   
  /**
   * Gets the date and time of the departure fare.
   *
   * @return The String representation of the departure date/time field.
   */ 
   public String getDepDateTime() {
      return departureDateTime;
   }     
   
  /**
   * Gets the total number of travel miles from departure to arrival.
   *
   * @return The Integer representation of the miles field.
   */ 
   public int getMiles() {
      return miles;
   }
   
  /**
   * Returns a String representation of the Itinerary
   * object that includes the departure/arrival airport, 
   * arrival/departure date/time, and total travel distance 
   * represented in miles.
   * 
   * @return String representation of an Itinerary object.
   */  
   public String toString() {
   
      String result = fromAirport + "-" + toAirport + " (" 
               + departureDateTime + " - " + arrivalDateTime + ") " 
               + miles + " miles";  
               
      return result;
   }
}