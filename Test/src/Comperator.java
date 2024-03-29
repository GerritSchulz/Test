import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Comperator {

   //TO-DO:
   // Create method, that return an ArrayList
   // CompareArrays calls the saveInArray method twice and start to compare it

   Comperator(){}

   // Read in the entries from a .txt list and return them in an ArrayList

    /**
     * Reads in a String (path to file) and read this file line by line and returns it in an ArrayList
     * @param path String, path to file
     * @return ArrayList containing all Strings from file
     */
    private static ArrayList<String> listToArray(String path){
      ArrayList<String> names = new ArrayList<>();
      try{
         BufferedReader bfreader = new BufferedReader((new FileReader(path)));
         String line = bfreader.readLine();
         while (line != null){
            names.add(line);
            // read next line
            line = bfreader.readLine();
         }
         bfreader.close();
         //System.out.println(names.size());
         //System.out.println(names);
      } catch (IOException e){
         e.printStackTrace();
      }
      return names;
   }

    private static void checkForCommon(String list1, String list2){
        ArrayList<String> namesOfList1 = listToArray(list1);
        ArrayList<String> namesOfList2 = listToArray(list2);
        namesOfList1.retainAll(namesOfList2);
        System.out.println("Common: " + namesOfList1);
    }

    private static void checkForDifference(String list1, String list2){
        ArrayList<String> namesOfList1 = listToArray(list1);
        ArrayList<String> namesOfList2 = listToArray(list2);
        namesOfList1.removeAll(namesOfList2);
       System.out.println("Difference: " + namesOfList1);
    }

   /**
    * Reads in two .txt files (lists) and compare them.
    * What elements are only in list1, list 2 and which are in both?
    * @param list1
    * @param list2
    */
   public void compareLists(String list1, String list2){

      checkForCommon(list1,list2);
      checkForDifference(list1,list2);
      checkForDifference(list2,list1);

      //TODO: Ausgabe an Ausgabeformat anpassen -> JSON PlugIn?
   }


}
