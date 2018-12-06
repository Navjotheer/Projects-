
        #include<stdio.h>
#include<stdlib.h>

int main(){
    int b, n, x, y, div, remainder;
    int large = 0;
    int small = 0;
    
    
    while ( 1 ){
        printf("enter a postive integer:");
      n = scanf(" %s", str);  // skip white space and read a whole token
      
      if( isInteger(str) ){           // if str is an integer
         sscanf(str, "%d", &x);       // convert it to int
        
         continue;
      }   
      printf("Please enter a postive integer: ");
      break;
    }
      while ( 1 ){
        printf("enter a postive integer:");
      n = scanf(" %s", str);  // skip white space and read a whole token
      
      if( isInteger(str) ){           // if str is an integer
         sscanf(str, "%d", &x);       // convert it to int
        
         continue;
      }   
      printf("Please enter a postive integer: ");
      break;    }
        
        
        
   if ( integer > y ){
     large = integer;
     small = y;
        }
        
   else if ( integer < y) {
   small = integer;
   large = y;
       }
   div = large/small;
   remainder = large%small;
   while( large != 0 && small != 0){
   remainder = small;
   small = large%small;
   large = remainder;
       }
  printf("The GCD is %v", remainder);

  return 0;
}

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




 
           /* scanf("%s", &b);
            printf("Please enter a positive integer: ");
            n = scanf("%d", &x);
        }
        if( x > 0 ) break;
            printf("Please enter a positive integer: ");
    }

   for(int i = 0; i < 2; i++){
   printf("Enter another positive integer: ");
   n = scanf("%d", &x);
    while ( 1 ){
        n = scanf(" %d", &y);
        while( n!=1){
            scanf("%s", &b);
            printf("Please enter a positive integer: ");
            n = scanf("%d", &y);
        }
        if( y > 0 ) break;
            printf("Please enter a positive integer: ");
    }
}
        if ( x > y ){
             large = x;
             small = y;
        }

        else if ( x < y) {
        small = x;
        large = y;

        }

   div = large/small;
   remainder = large%small;

    while( large != 0 && small != 0){
       remainder = small;
*/
