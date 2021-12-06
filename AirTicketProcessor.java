import java.util.Scanner;
import java.util.Arrays;  
import java.io.File;
import java.io.FileNotFoundException; 

/**
 * This class creates an array of AirTicket objs, initialized 
 * to 0, and provides various methods to manipulate the array
 * such as addAirTicket, generateReport, generateReportByFlightNum, 
 * and generateReportByItinerary. A read-in method is also provided 
 * to process AirTicket objs in a file. 
 * 
 * @author Winton Ebanks 
 * @version 18 November 2021
 */    
public class AirTicketProcessor {
   
   //Instance variables
   private AirTicket[] airTicketList;
   private String[] invalidRecordsList; //Not used for this project.
   
   /**
    * Creates a new AirTicketProcessor obj and initializes the 
    * the instance variables to 0.
    */
   public AirTicketProcessor() {
      airTicketList = new AirTicket[0];
      invalidRecordsList = new String[0];
   }
   
   /**
    * Gets the airTicketList field in AirTicketProcessor.
    * 
    * @return The array represenation of airTicketList field (array).
    */
   public AirTicket[] getTickets() {
      return airTicketList;
   } 
   
   /**
    * Gets the invalidRecordsList field in AirTicketProcessor.
    * 
    * @return The array represenation of invalidRecordsList field (array).
    */
   public String[] getInvalidInput() {
      return invalidRecordsList;
   }           
   
   /**
    * Reads-in the AirTicket objs in a file with two scanners: one for each line
    * (AirTicket obj) and the other to process each value in the working line. A
    * switch is then used to create specific AirTicket objs based on the first 
    * character of the working line. The new AirTicket obj created is also added
    * to the array of AirTicket objs; returns nothing.
    *
    * @param fileName The name of the file to process.
    * @throws FileNotFoundException Exception if file is not found.
    */
   public void readAirTicketFile(String fileName) throws FileNotFoundException {
      Scanner fileScanner = new Scanner(new File(fileName)); //File scanner
      
      while (fileScanner.hasNextLine()) {
         String line = fileScanner.nextLine(); //Line scanner
         
         Scanner lineScanner = new Scanner(line); //Single value scanner
         while (lineScanner.hasNext()) {
            lineScanner.useDelimiter(",");
         
            char ticketCategory = lineScanner.next().charAt(0); //switch char
         
         //Initialization of variables to create AirTicket objs.
            String flightNum;
            Itinerary itinerary;
            AirTicket ticket; 
         
            try {
               switch (ticketCategory) {
                  case 'N':
                     flightNum = lineScanner.next();
                     itinerary = new Itinerary(lineScanner.next(), 
                        lineScanner.next(), lineScanner.next(),
                        lineScanner.next(), 
                        Integer.parseInt(lineScanner.next()));
                  
                     ticket = new NonRefundable(flightNum, itinerary, 
                        Double.parseDouble(lineScanner.next()), 
                        Double.parseDouble(lineScanner.next()), 
                        Double.parseDouble(lineScanner.next()));
                  
                     addAirTicket(ticket);
                  
                     break;
                  
                  case 'E':
                     flightNum = lineScanner.next();
                     itinerary = new Itinerary(lineScanner.next(),
                        lineScanner.next(), lineScanner.next(),
                        lineScanner.next(), 
                        Integer.parseInt(lineScanner.next()));  
                  
                     ticket = new Economy(flightNum, itinerary, 
                        Double.parseDouble(lineScanner.next()), 
                        Double.parseDouble(lineScanner.next()));  
                  
                     addAirTicket(ticket);   
                  
                     break;   
               
                  case 'B':
                     flightNum = lineScanner.next();
                     itinerary = new Itinerary(lineScanner.next(),
                        lineScanner.next(), lineScanner.next(),
                        lineScanner.next(), 
                        Integer.parseInt(lineScanner.next()));  
                  
                     ticket = new Business(flightNum, itinerary, 
                        Double.parseDouble(lineScanner.next()), 
                        Double.parseDouble(lineScanner.next()),
                        Double.parseDouble(lineScanner.next()),
                        Double.parseDouble(lineScanner.next())); 
                  
                     addAirTicket(ticket);   
                  
                     break;  
               
                  case 'F':
                     flightNum = lineScanner.next();
                     itinerary = new Itinerary(lineScanner.next(), 
                        lineScanner.next(), lineScanner.next(),
                        lineScanner.next(), 
                        Integer.parseInt(lineScanner.next()));
                  
                     ticket = new Elite(flightNum, itinerary, 
                        Double.parseDouble(lineScanner.next()), 
                        Double.parseDouble(lineScanner.next()), 
                        Double.parseDouble(lineScanner.next()),
                        Double.parseDouble(lineScanner.next()),
                        Double.parseDouble(lineScanner.next()));   
                  
                     addAirTicket(ticket);   
                  
                     break;
               
                  default: 
                     if (lineScanner.hasNext()) {
                        lineScanner.nextLine();
                     }  
                  
                     throw new 
                        InvalidCategoryException(Character.
                        toString(ticketCategory));                      
               }
            }
            
            catch (InvalidCategoryException e) {
               String invalidRecord = e + " in: " + line;
               addInvalidRecord(invalidRecord);
            }
            
            catch (NumberFormatException e) {
               if (lineScanner.hasNext()) {
                  lineScanner.nextLine();
               }   
                       
               String invalidRecord = e + " in: " + line;
               addInvalidRecord(invalidRecord); 
            }
         }
      
      }
      
   }
  
   /**
    * Returns nothing and increases the AirTicket array by 1.   
    * The AirTicket passed-in is placed at the last position of 
    * the array.
    *
    * @param airTicketIn The AirTicket obj to add to array.
    */     
   public void addAirTicket(AirTicket airTicketIn) {
      airTicketList = Arrays.copyOf(airTicketList, airTicketList.length + 1); 
      airTicketList[airTicketList.length - 1] = airTicketIn;
   }
  
   /**
    * Returns nothing and increases the InvalidRecord array by 1.   
    * The InvalidRecord passed-in is placed at the last position of 
    * the array.
    *
    * @param invalidRecord The InvalidRecord obj to add to array.
    */     
   public void addInvalidRecord(String invalidRecord) {
      invalidRecordsList = Arrays.copyOf(invalidRecordsList,
         invalidRecordsList.length + 1); 
      invalidRecordsList[invalidRecordsList.length - 1] = invalidRecord;     
   }  
  
   /**
    * Returns a string report of the AirTicket objs in the array   
    * based on original ordering read-in from file.
    * 
    * @return The String representation of AirTicket objs, based on 
    * original order, read-in from file.
    */      
   public String generateReport() {
   
      String result = "----------------------------\n" 
         + "Air Ticket Report\n" 
         + "----------------------------\n\n";
          
      for (AirTicket ticket : airTicketList) {
         result += ticket + "\n\n";
      }
   
      return result;
   }
  
   /**
    * Returns a string report of the AirTicket objs in the array   
    * based on natural ordering of Flight Numbers read-in from file.
    * 
    * @return The String representation of AirTicket objs, based on 
    * natural ordering of Flight Numbers, read-in from file.
    */      
   public String generateReportByFlightNum() {
      Arrays.sort(airTicketList);
      String result = "--------------------------------------\n" 
         + "Air Ticket Report (by Flight Number)\n" 
         + "--------------------------------------\n\n";  
   
      for (AirTicket ticket : airTicketList) {
         result += ticket + "\n\n";
      } 
      
      return result; 
   }
   
   /**
    * Returns a string report of the AirTicket objs in the array   
    * based on Itinerarys read-in from file.
    * 
    * @return The String representation of AirTicket objs, based on 
    * Itinerarys, read-in from file.
    */       
   public String generateReportByItinerary() {
     
   
      Arrays.sort(airTicketList, new ItineraryComparator());
      
      String result = "--------------------------------------\n" 
         + "Air Ticket Report (by Itinerary)\n" 
         + "--------------------------------------\n\n";  
         
      for (AirTicket ticket : airTicketList) {
         result += ticket + "\n\n";
      }
      
      return result;      
   }
   
   /**
    * Returns a string report of the invalid AirTicket objs    
    * in the array based on Itinerarys read-in from file.
    * 
    * @return The String representation of invalid AirTicket objs,
    * based on list of Itinerarys read-in from file.
    */        
   public String generateReportForInvalidInput() {
      
      String result = "--------------------------------------\n" 
         + "Air Ticket Report for Invalid Input\n" 
         + "--------------------------------------\n";  
         
      for (String invalidTicket : invalidRecordsList) {
         result += invalidTicket + "\n";
      }         
      
      return result;
   }
   
}