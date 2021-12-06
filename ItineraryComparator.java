import java.util.Comparator;

/**
 * Simple class that compares two AirTicket objs based on 
 * the string values of their Itinerary fields.
 * 
 * @author Winton Ebanks 
 * @version 18 November 2021
 */    
public class ItineraryComparator implements Comparator<AirTicket> {
   
  /**
   * Compares two AirTicket objects, based on Itinerary, and 
   * returns an int result of the comparison.
   *
   * @param t1 The first AirTicket obj to compare against.
   * @param t2 The second AirTicket obj to compare against.
   * @return The int representation of comparing AirTicket objs based
   * based on Itinerary.
   */       
   public int compare(AirTicket t1, AirTicket t2) {
   
      return (t1.getItinerary()).toString().
                     compareTo((t2.getItinerary()).toString());
   }    
}