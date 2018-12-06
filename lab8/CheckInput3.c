//-----------------------------------------------------------------------------
//  CheckInput3.c
// 
//  Reads tokens from stdin, identifying them as int or double, until a 
//  non-numeric String is entered.
//
//  This re-creation of the Java version is surprisingly complex.  The reason
//  is that scanf() does not convert tokens to int and double the way nextInt()
//  and nextDouble() in the Scanner class do. For instance, when converting 
//  the string "23y45" to int, scanf() will succeed! It reads the first two 
//  digits "23", stops at the letter "y" since it cannot be part an int, then 
//  converts "23" to int. For instance, on input "23y45", scanf("%d", &a) 
//  assigns 23 to the int variable a. A similar problem arrises when scanf() 
//  converts a string to double.
//
//  There are two other functions in stdio.h similar to scanf() called sscanf()
//  and fscanf(). sscanf(), used below, reads from a string rather than from 
//  stdin and fscanf() reads from a file.  Thus sscanf("23y45", "%d", &a) also 
//  assigns 23 to a.
//
//  Instead we want "23y45" to be recognized as a non-numeric string, as it
//  would by Java's nextInt() and nextDouble() functions.  To accomplish this,
//  we write two functions called isInteger() and isDouble().  These functions 
//  step through the char array s[] to determine whether it contains 'wrong' 
//  characters, returning the value 1 (true) or 0 (false) as appropriate. This
//  task is complicated by the fact that an int may contain a sign (+ or -)
//  as its first character, and a double may also contain at most one decimal 
//  point (.).  
//
//  See https://www-s.acm.illinois.edu/webmonkeys/book/c_guide/ for the
//  documentation on functions strlen() in string.h, and isdigit() in ctype.h
//  used below.
//
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>  // for strlen()
#include<ctype.h>   // for isdigit()

int main(){
   int a, n;
   double x;
   char str[200];
   
   while( 1 ){ // seemingly infinite loop
      printf("Enter a number: ");
      n = scanf(" %s", str);  // skip white space and read a whole token
      
      if( isInteger(str) ){           // if str is an integer
         sscanf(str, "%d", &a);       // convert it to int
         printf("%d is an int\n", a); // print it out
         continue;
      }   
      if( isDouble(str) ){              // if str is a double
         sscanf(str, "%lf", &x);        // convert it to double
         printf("%f is a double\n", x); // print it out
         continue;
      }
      printf("%s is not a number\n", str);  // otherwise str is not a number
      break;
      // continue lands here
   }
   // break lands here
   printf("bye!\n");
   
   return 0;
}

// isInteger()
// Returns 1 (true) if string s[] can be interpreted as an int, and
// returns 0 (false) otherwise.
int isInteger(char s[]){
   int i, n;
   
   if( s==NULL ) 
      return 0;
   n = strlen(s);
   if( n==0 ) 
      return 0;
   if( s[0]!='-' && s[0]!='+' && !isdigit(s[0]) )
      return 0;
   for(i=1; i<n; i++){
      if( !isdigit(s[i]) ) 
         return 0;
   }
   return 1;
}

// isDouble()
// Returns 1 (true) if string s[] can be interpreted as a double, and
// returns 0 (false) otherwise.
int isDouble(char s[]){
   int i, n, num_points;
   
   if( s==NULL ) 
      return 0; 
   n = strlen(s);  
   if( n==0 ) 
      return 0;
   num_points = ( s[0]=='.' ? 1 : 0 );
   if( s[0]!='.' && s[0]!='-' && s[0]!='+' && !isdigit(s[0])  )
      return 0;
   for(i=1; i<n; i++){
      if( s[i]=='.' ) num_points++;
      if( ( !isdigit(s[i]) && s[i]!='.' ) || num_points>1 ) 
         return 0;
   }
   return 1;
}




