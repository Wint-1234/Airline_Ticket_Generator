/**
* Simple user defined exception that creates an 
* exception object meant to be thrown when a line of
* input data contains an invalid category.
*
* 
* @author Winton Ebanks 
* @version 18 November 2021
*/   
public class InvalidCategoryException extends Exception {
   
   /**
    * Creates an Invalid Category Exception object by 
    * calling on the parent constructor (Exception) with 
    * a toString() value.
    *
    * @param category The String parameter for the category.
    */
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }
}