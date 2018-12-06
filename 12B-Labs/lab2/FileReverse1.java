
//Navjot Heer
//Cruz ID: nsheer
//Lab 2
//FileReverse.java
//This program reads each input of a file, parses the tokens and 
//then prints each token backwards to an output file on a line by itself. 

import java.io.*;
import java.util.Scanner;
class FileReverse{

  public static void main(String [] args){
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
      for(i=0, i < token.length, i ++){
        out.println(" "+stringReverse(token, token.length));

      }
    }

  in.close();
  out.close();
}


  public static String stringReverse(String s, int n){
    if( i <= 1){
      return s;
    }
    else{
      return stringReverse(s.substring(1)+s.charAt(0));
    }

  

