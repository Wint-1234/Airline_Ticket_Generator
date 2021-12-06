import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException; 

/**
 * Simple test class that tests AirTicketProcessor
 * methods.
 * 
 * @author Winton Ebanks
 * @version 10 November 2021
 */    
public class AirTicketProcessorTest {

   private AirTicketProcessor ticketProcessor = new AirTicketProcessor();
   private Itinerary trip = new Itinerary("ATL", "LGA", "2021/11/21 1400", 
                                      "2021/11/21 1640", 800);
   private Business bTicket = new Business("DL 1860", trip, 450,
                                       2.0, 50.0, 50.00);    
   private Business bTicket2 = new Business("DL 1862", trip, 450,
                                 2.0, 50.0, 50.00);

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /**
    * Tests the generateReport method by checking if it (1) creates a file 
    * and (2) if the created file contains accurate information.
    *
    * @throws FileNotFoundException Exception if file not found. 
    */   
   @Test public void generateReportTest() throws FileNotFoundException {
      ticketProcessor.readAirTicketFile("air_ticket_data.csv");
      String testReport = ticketProcessor.generateReport();
      Assert.assertEquals(true, testReport.contains("2015"));
      Assert.assertEquals(false, testReport.contains("TEST"));
   }    
   
   /**
    * Tests the generateReportByFlightNum method by checking if 
    * it (1) creates a file and (2) if the created file contains
    * accurate information.
    *
    * @throws FileNotFoundException Exception if file not found. 
    */   
   @Test public void generateReportByFlightNumTest()
                               throws FileNotFoundException {
      ticketProcessor.readAirTicketFile("air_ticket_data.csv");
      String testReport = ticketProcessor.generateReportByFlightNum();
      Assert.assertEquals(true, testReport.contains("2015"));
      Assert.assertEquals(false, testReport.contains("TEST"));
   }       
   
   /**
    * Tests the generateReportByItinerary method by checking if 
    * it (1) creates a file and (2) if the created file contains
    * accurate information.
    *
    * @throws FileNotFoundException Exception if file not found. 
    */   
   @Test public void generateReportByItineraryTest()
                               throws FileNotFoundException {
      ticketProcessor.readAirTicketFile("air_ticket_data.csv");
      String testReport = ticketProcessor.generateReportByItinerary();
      Assert.assertEquals(true, testReport.contains("2015"));
      Assert.assertEquals(false, testReport.contains("TEST"));
      Assert.assertEquals(1.5, Economy.E_AWARD_MILES, 01);
   }       
     
   /**
    * Tests the addAirTicket method by passing in a AirTicket obj.
    */   
   @Test public void addAirTicketTest() {
      ticketProcessor.addAirTicket(bTicket);
   
      Assert.assertEquals(bTicket, ticketProcessor.getAirTicketList()[0]);
      Assert.assertEquals(1, ticketProcessor.getAirTicketList().length);
   }   

   /**
    * Tests the addInvalidRecord method by passing in a String.
    */   
   @Test public void addInvalidRecordTest() {
      ticketProcessor.addInvalidRecord("Test");
   
      Assert.assertEquals("Test", ticketProcessor.getInvalidRecordsList()[0]);
      Assert.assertEquals(1, ticketProcessor.getInvalidRecordsList().length);
   } 
      
}
