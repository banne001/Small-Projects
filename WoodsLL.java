public class WoodsLL<E extends Comparable<E> >
{
   private Node<E> head;
   private int size;
  
   public WoodsLL()
   {
     head = null;
     size = 0;
   } 
   
   public void clear()
   {
     head = null;
     size = 0;
   }
   public void pivot()  { 
      if (head == null) return;
      if (head.next == null ) return;
      Node<E> holdF = head;
      Node<E>  holdM = head.next;     
      Node<E>  holdB = head.next.next;     
      head = holdM;
      head.next = holdF;
      head.next.next = holdB;
      Node<E> pseudoFront = holdF;//the front is located in the middle now
      while (pseudoFront.next != null){ 
         if (pseudoFront.next == null) return;//even end of list
         if (pseudoFront.next.next == null ) return;//odd
         holdF = pseudoFront.next;
         holdM = pseudoFront.next.next;     
         holdB = pseudoFront.next.next.next;    
          pseudoFront.next = holdM;
          pseudoFront.next.next = holdF;
          pseudoFront.next.next.next = holdB;     
          pseudoFront = holdF;
       } 
   } 
   
   public void add(int location, E x)
   {
     if (location < 0) throw new IllegalArgumentException();
     else if (location > size) throw new IllegalArgumentException();
     else if (location == size) add(x);
     else if (location == 0)
     {
       size++;
       Node<E> temp = new Node<E>();
       temp.data = x;
       temp.next = head;
       head = temp;
     }
     else
     {
        Node<E> current = head;
        for (int i = 1; i < location; i++) current = current.next;
        Node<E> temp = new Node<>();
        temp.data = x;
        temp.next = current.next;
        current.next = temp;
        size++;
     }
   }
   
   
   public boolean contains(E x)
   {
     Node<E> current = head;
     while(current != null)
     {
       if (current.data.compareTo(x) == 0 ) return true;
       else
         current = current.next;
     }
     
     return false;
   }
   
   public int length()
   {
     return size();
   }
   
   public int size()
   {
     return size;
   }
   
   public void add(E x)
   {
     if (head == null)
     {
       // no head node yet.
       head = new Node<E>();
       size++;
       head.data = x;
       head.next = null;
     }
     else
     {
        Node<E> temp;
        temp = head;
        while (temp.next != null)
         temp = temp.next;  // Move one node forward
        
        temp.next = new Node<E>();  //Create the new "last"
        temp.next.data = x;      // node and fill it in
        temp.next.next = null; 
        size++;
     }
     
   } 
   
   public boolean remove(E x)
   {
     if (head == null) return false;
     if (head.data.equals(x))
     {
       head = head.next;
       size--;
       return true;
     } 
     Node<E> current = head;
     Node<E> behind  = head;
     
     while(current != null && !current.data.equals(x))
     {
       behind = current;
       current = current.next;
     }
     if (current != null)
     {
       behind.next = current.next;
       size--;
       return true;
     }
     
     return false;
   }
   
   public String toString()
   {
        // Empty LL
        if (head == null) return "[]";

        // LL has at least ONE item
        String result = "";
        Node<E> temp = head;

        while (temp != null)
        {
          result = result + "," + temp.data.toString();
          temp = temp.next;  //
        }
        
        return "[" + result.substring(1) + "]";
 
   }  
   //Blezyl Santos
   public String get(int x){
      if (x>size()||x<0) throw new IllegalArgumentException();
      Node<E> temp = head;
      for (int i=0; i<x; i++) temp = temp.next;
      return temp.data.toString();
   }
   public void removeLast(){
      if(size()==0){}
      else if(size()==1){ 
         head=null;
         size=0;
      }else{
         Node<E> temp = head;
         Node<E> current = head;
         while(current.next!=null){
            temp = current;
            current = current.next;
         }
         temp.next = null;
         size--;
      }
   }
   private class Node<E>
   { 
      public E data;
      public Node<E> next;
   }
    
   
}