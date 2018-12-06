//Guess.java
//Navjot Heer
//nsheer
//pa2
//interactive guessing game

import java.util.Scanner;

class Guess{
   public static void main(String[] args){
   double guess;
   
    int random = (int) (Math.random() * 10 + 1);
    Scanner sc = new Scanner(System.in);
    System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
    System.out.print("Enter your first guess: ");
    guess = sc.nextDouble();
    if (guess == random){
      System.out.println("You win!"); 
      System.exit(0);
    }
    else if (guess < random){
      System.out.println("Your guess is too low.");
    }
    else{ 
      System.out.println("Your guess is too high.");
    }
  
    System.out.print("Enter your second guess: ");
    guess = sc.nextDouble();
    if (guess == random){
      System.out.println("You win!");
      System.exit(0);
    }
    else if (guess < random){
      System.out.println("Your guess is too low.");
    }
    else{
      System.out.println("Your guess is too high.");
    }

    System.out.print("Enter your third guess: ");
    guess = sc.nextDouble();
    if (guess == random){
      System.out.println("You win!");
      System.exit(0);
    }
    else if (guess < random){
      System.out.println("Your guess is too low.");
    }
    else{
      System.out.println("Your guess is too high.");
    }
      System.out.println("You lose. The number was "+random+".");
    }
}
