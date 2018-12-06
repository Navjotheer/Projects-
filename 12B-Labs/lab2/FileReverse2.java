//Navjot Heer
//Cruz ID: nsheer
//Lab 2
//FileReverse.java
//This program reads each input of a file, parses the tokens and 
//then prints each token backwards to an output file on a line by itself. 

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class FileReverse2{

  public static void main(String [] args) throws IOException{
      Scanner in = null;
      PrintWriter out = null;
      String line = null;
      String[] token = null;
      int i, n, lineNumber = 0;

      // check number of command line arguments is at least 2
      if(args.length < 2){
         System.out.println("Usage: FileCopy <input file> <output file>");
         System.exit(1);
      } 

      //open input and output files 
      in = new Scanner(new File(args[0]));
      out = new PrintWriter(new FileWriter(args[1]));

      // read lines from in, extract and print tokens from each line
      while( in.hasNextLine() ){
        lineNumber++;

      // trim leading and trailing spaces,
      // then add one trailing space so
      // split works on blank lines
      line = in.nextLine().trim() + " ";
      // split line around white space
      token = line.split("\\s+");

      n = token.length;

      //reverse tokens 
      for(i=0; i <n; i ++){
       // out.println(" "
        reverseString(token[i], token[i].length());
      }
    }

  in.close();
  out.close();
}
public static String reverseString(String X, int n){
char [] array = X.toCharArray();
char [] A = array;
char [] B = new char[A.length];
  reverseArray1(A, A.length, B);

String str = Arrays.toString(B);
str=str.replace(",", "");
str=str.replace("[", "");
str=str.replace("]","");
str=str.replaceAll("\\s","");
//String [] strArray = Arrays.toString(B);
//String output = " ";
//	for(String str: strArray)
//		output = output + str;
//for(int i = 0; i<strArray.length; i++){
System.out.println(str);


//System.out.println(output1); 
   return "";

}

  public static void reverseArray1( char [] X, int n, char [] Y ){
//if n==0 do nothing
if( n > 0 ) {
  Y[ X.length - n ] = X[ n - 1 ]; // Reverse
  reverseArray1( X, n-1, Y); // Recursion Step
  }
}
 
 }
 
