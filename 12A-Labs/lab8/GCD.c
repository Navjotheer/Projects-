/*
 * GCD,c
 * Navjot Heer
 * nsheer
 * lab8
 * Prints the greatest common denominator inserted
 * by the user.        
 *        
 */        

#include<stdio.h>
#include<stdlib.h>

int main(){
    int b, n, x, y, div, remainder;
    int large = 0;
    int small = 0;
    
    printf("Enter a positive integer: ");
    n = scanf("%d", &x);
    while ( 1 ){
        n = scanf(" %d", &x);
        while( n!=1){
            scanf("%s", &b);
            printf("Please enter a positive integer: ");
            n = scanf("%d", &x);
        }
        if( x > 0 ) break;
            printf("Please enter a positive integer: ");
    }
        
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
       small = large%small;
       large = remainder;
    }

  printf("The GCD of %d and %d is %d.\n", x, y,  remainder);

  return 0;
}
