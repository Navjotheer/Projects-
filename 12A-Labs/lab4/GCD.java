//pa3
//Navjot Heer
//nsheer
//GCD.java
//Prints the Greatest Common Denominator based on two
//postive inputs by the user

import java.util.Scanner;
class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y, div, remainder;
        int large = 0;
        int small = 0;

        System.out.print("Enter a positive integer: ");
        while(true){
            if(sc.hasNextInt()){
                x = sc.nextInt();
                if(x > 0){
                    break;
                }
            }

            System.out.print("Please enter a positive integer: ");
            sc.next();
        }

        System.out.print("Enter another positive integer: ");
        while(true){

            if(sc.hasNextInt()){
                y = sc.nextInt();
                if(y > 0){
                    break;
                }
            }

            System.out.print("Please enter a positive integer: ");
            sc.next();
        }

        if (x > y) {
            large = x;
            small = y;
        }
        else if (x < y) {
            small = x;
            large = y;
        }
        div = large / small;
        remainder = large % small;
        while (large != 0 && small != 0) {
            remainder = small;
            small = large % small;
            large = remainder;
        }
        System.out.println("The GCD of " + x + " and " + y + " is " + remainder);
    }
}


