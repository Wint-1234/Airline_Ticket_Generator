import java.io.FileNotFoundException; 
   
/**
 * Simple driver app that utilizes the command line arguements 
 * to read-in a file of AirTicket objs and then prints four
 * different types of reports; handles various exceptions 
 * accordingly.
 * 
 * @author Winton Ebanks 
 * @version 18 November 2021
 */     
public class AirTicketApp {

   /**
    * Accepts command line arguements, uses the first String value
    * to read-in a file and subsequently prints out 4 reports with an 
    * AirTicketProcessor obj. If no (or bad) arguments are passed in via 
    * command line, an error message is displayed. Every bad 
    * AirTicket obj is placed onto a separate Air Ticket Report at the 
    * end.
    *
    * @param args The command line arguement for file name.
    * @throws FileNotFoundException Exception if file is not found.
    */   
   public static void main(String[] args) {
      AirTicketProcessor ticketProcessor;
      
      if (args.length == 0) {
         System.out.println("*** File name not provided " 
               + "by command line argument.");
         System.out.println("Program ending.");
      }
      else {
         String fileName = args[0];
         ticketProcessor = new AirTicketProcessor();
            
         try {
            ticketProcessor.readAirTicketFile(fileName);
            
         
            System.out.print(ticketProcessor.generateReport());
            System.out.print(ticketProcessor.generateReportByFlightNum());
            System.out.print(ticketProcessor.generateReportByItinerary());
            System.out.print(ticketProcessor.generateReportForInvalidInput());
         }
            
         catch (FileNotFoundException e) {
            System.out.println("*** File not found." 
               + "\nProgram ending.");
         }               
      }
   }
}




