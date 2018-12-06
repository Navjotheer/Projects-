//-----------------------------------------------------------------------------
// Navjot Heer
// Cruz ID: nsheer
// lab6
// ListTest.java
// A test client for the List ADT
//-----------------------------------------------------------------------------

public class ListTest{

   public static void main(String[] args){

      List<String> A = new List<String>();
      List<String> B = new List<String>();
      int i, j;

      //Test isEmpty
      System.out.println();
      System.out.println("List A Empty?");
      System.out.println(A.isEmpty() );
      System.out.println();

      //Test add() and size()
      System.out.println("Adding to List");
      A.add(1,"one");
      B.add(1, "two");
      System.out.println("Size = ");
      System.out.println(A.size() );
      System.out.println("List A Empty?");
      System.out.println(A.isEmpty() );
      System.out.println();

      //Test remove()
      System.out.println("Remove item from list");
      A.remove(1);
      System.out.println("size(A) = ");
      System.out.println(A.size() );
      System.out.println();

       //Test add() and equals()
      System.out.println("Add items + equals Test");
      A.add(1, "one");
      A.add(2, "two");
     // B.add(1, "three");
      B.add(2, "four");
      System.out.println("A.equals(A) = ");
      System.out.println(A.equals(A));
      System.out.println("B.equals(B) = ");
      System.out.println(B.equals(B));
      System.out.println();

      //Test get()
      System.out.println("B.get(1)= ");
      System.out.println(B.get(1));
      System.out.println();

      //Test removeAll()
      System.out.println("Remove All");
      A.removeAll();
      B.removeAll();
      System.out.println("List A Empty?");
      System.out.println(A.isEmpty() );
      System.out.println("List B Empty?");
      System.out.println(B.isEmpty() );
      System.out.println("size(A) = ");
      System.out.println(A.size() );
      System.out.println("size(B) = ");
      System.out.println(B.size() );
      System.out.println();
    
      System.out.println("End of Test");
      
   }
}
