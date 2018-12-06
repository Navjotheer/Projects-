//-----------------------------------------------------------------------------
// Queue.java
// interface for the Queue ADT
//-----------------------------------------------------------------------------

public class Queue implements QueueInterface {

   // Private inner Node class
   private class Node {
      Object item;
      Node next;

      Node(Object x){
         item = x;
         next = null;
      }
   }

   // Private helper variables
   private Node front;
   private Node back;
   private int size;

   // Queue()
   // Constructor for the Queue class
   public Queue(){
      front = null;
      back = null;
      size = 0;
   }

// ADT Operations -------------------------------------------------------------

   // isEmpty()
   // pre: none
   // post: returns true if this Queue is empty, false otherwise
   public boolean isEmpty(){
      return(size == 0);

   }

   // length()
   // pre: none
   // post: returns the length of this Queue.
   public int length(){
      return size;
   }

   // enqueue()
   // adds newItem to back of this Queue
   // pre: none
   // post: !isEmpty()
   public void enqueue(Object newItem){
      //tail.next = new Node(x);
      Node N = new Node(newItem);
      if(isEmpty() ){
         front = N;
         back = front;
      }else{
         back.next = N;
         back = N;
      }
      size++
   }

   // dequeue()
   // deletes and returns item from front of this Queue
   // pre: !isEmpty()
   // post: this Queue will have one fewer element
  
  /*public Object dequeue() throws QueueEmptyException{
      if(isEmpty() ){
         throw new QueueEmptyException("cannot dequeue() empty queue");
      }
      Object returnValue = peek(); 
      front = front.next;
      size--;
      return returnValue;
   } */

   // peek()
   // pre: !isEmpty()
   // post: returns item at front of Queue
   public Object peek() throws QueueEmptyException{
      if(isEmpty() ){
         throw new QueueEmptyException("cannot peek() an empty queue");
      }
      return front.item;
   }

   // dequeueAll()
   // sets this Queue to the empty state
   // pre: !isEmpty()
   // post: isEmpty()
   public void dequeueAll() throws QueueEmptyException {
       if(isEmpty() ){
          throw new QueueEmptyException("cannot dequeue() empty queue");
      }
      front = null;
      back = null;
      size = 0;
   }

   // toString()
   // overrides Object's toString() method
   public String toString(){
      String s = "";
      Node N = front;
      while(N!=null){
         s += N.item + "";
         N = N.next;
      }
      return s;
   }

    // dequeue()
   // deletes and returns item from front of this Queue
   // pre: !isEmpty()
   // post: this Queue will have one fewer element
   /*public Object dequeue() throws QueueEmptyException{
      if(isEmpty() ){
         throw new QueueEmptyException("cannot dequeue() empty queue");
      }
      Object returnValue = front.item; 
      if(front==back){
         front = back;
         back = null;
      } else{
         front = front.next;

      }
      size--;
      return returnValue;
   }*/
 public Object dequeue() throws QueueEmptyException {
    if (front == null) {
      throw new QueueEmptyException("cannot dequeue() on an empty Queue");
    } else {
      Node N = front;
      front = N.next;
      numItems--;
      return N.item;
    }
  }

}