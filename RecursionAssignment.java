import java.util.*;
// Blezyl Santos
// CS 145

public class RecursionAssignment{
   public static void writeSquares(int n){
      if ( n==0 ){
       System.out.println("nothing");
      } else if (n == 1){//base
         System.out.print(1 + " ");
      } else if (n % 2 == 0){
         writeSquares(n-1);
         System.out.print(n*n + " " );
      } else if (n % 2 == 1){
         System.out.print(n*n + " " );
         writeSquares(n-1);
      } 
   }
   public static boolean isPalindrome(String n){   
      if( n.length() < 2 ){
         return true;
      } else {
         char first = n.charAt(0);
         char last = n.charAt(n.length()-1);
         if (first != last) return false;
         String middle = n.substring(1, n.length() - 1);
         return isPalindrome(middle);
      }      
   }
   
   public static void main(String[] args){
      writeSquares(8);
      System.out.println();
      writeSquares(11);
      System.out.println();
      writeSquares(1);
      System.out.println();
      writeSquares(0);
      
      boolean x = isPalindrome("madam");
      System.out.println(x);
      boolean y = isPalindrome("racecar");
      System.out.println(y);
      boolean z = isPalindrome("step on no pets");
      System.out.println(z);
      boolean a = isPalindrome("able was i ere i saw elba");
      System.out.println(a);
      boolean b = isPalindrome("java");
      System.out.println(b);
      boolean c = isPalindrome("rotater");
      System.out.println(c);
      boolean d = isPalindrome("byebye");
      System.out.println(d);
      boolean e = isPalindrome("notion");
      System.out.println(e);
   }
}
