import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException; 
   
public class AirTicketAppTest {


   /** Fixture initialization (common initialization
    *  for all tests). 
    */
   @Before public void setUp() {
   }
   
   /** 
    *  Tests the main method with null arguement.
    */      
   public void main() throws Exception {
      //Constructor test
      AirTicketApp airTicketApp = new AirTicketApp();
      
      String[] args = {};
      AirTicketApp.main(args);
   
      Assert.assertEquals(1.5, Economy.E_AWARD_MILES, 01);
   }   
   
   /** 
    *  Tests the main method with an arguement.
    */       
   public void main2() throws Exception {
      //Constructor test
      AirTicketApp ticketApp = new AirTicketApp();
      
      String[] args = {"air_ticket_data.csv"};
      AirTicketApp.main(args);
      
      Assert.assertEquals(1.5, Business.B_AWARD_MILES);
   }      

}
