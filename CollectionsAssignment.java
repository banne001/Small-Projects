import java.util.*;
import java.io.*;
// Blezyl Santos
// 1/22/2019

public class CollectionsAssignment{
   public static void main(String[] args)throws FileNotFoundException{
      File file = new File("DataFile1.txt");
      Scanner scan = new Scanner(file);
      
      Map<String, Integer> words= new TreeMap<>();
      while (scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);
         String word = lineScan.next();
         if(words.containsKey(word)){
            words.put(word, words.get(word)+1);
         } else {
            words.put(word, 1);
         }
      } 
            
      while (!words.keySet().isEmpty()){
         int currentHigh = 0;
         String highest = "null";
         for (String x: words.keySet()){
            if ( words.get(x) > currentHigh){
               highest = x;
               currentHigh = words.get(x);
            }
         } 
         System.out.println(highest + " " + words.get(highest));
         words.remove(highest);
      }     
   }
} 