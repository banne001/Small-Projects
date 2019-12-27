import java.util.*;
//Blezyl Santos
//In Class Assignment Week 6
public class StackQueue_InClass{
   public static void main (String[] args){
      Queue<Integer> test = new LinkedList<>();
      test.add(1);
      test.add(2);
      test.add(3);
      System.out.print(test + " to ");
      stutter(test);
      System.out.println(test);
      
      Queue<String> letters = new LinkedList<>();
      letters.add("a");
      letters.add("b");
      letters.add("c");
      System.out.print(letters + " to ");
      mirror(letters);
      System.out.println(letters);
   }
   
   public static void stutter(Queue<Integer> q){
      Queue<Integer> u = new LinkedList<>();
      while(!q.isEmpty()){
         u.add(q.peek());
         u.add(q.remove());
      }
      while(!u.isEmpty()) q.add(u.remove()); 
   }
   public static void mirror(Queue<String> letters){
      Queue<String> answer = new LinkedList<>();
      Stack<String> temp = new Stack<>();
      while(!letters.isEmpty()){
         answer.add(letters.peek());
         temp.add(letters.remove());
      }
      while(!temp.isEmpty()) answer.add(temp.pop()); 
      while(!answer.isEmpty()) letters.add(answer.remove());
   }
   
}