// Lawn.java
// Navjot Heer
// nsheer
// pa1
// Program calculates area of a lot and time to mow lot.

import java.util.Scanner;

class Lawn{

   public static void main( String[] args){
    double width, length, area, lot_area, house_area, rate, M_time;
    Scanner sc = new Scanner(System.in);

    //System.out.print("Enter the length and width of the lot, in feet: ");
    width = sc.nextDouble();
    length = sc.nextDouble();
    lot_area = width*length;

    // System.out.print("Enter the length and width of house, in feet: ");
    width = sc.nextDouble();
    length = sc.nextDouble();
    house_area = width*length;
    area = lot_area-house_area;
    System.out.print("The lawn area is ");
    System.out.print(area);
    System.out.println(" square feet.");
    
    // System.out.print("Enter the mowing rate, in square feet per second: ");
    rate = sc.nextDouble();
    M_time = area/rate;
    System.out.print("The mowing time is ");
     
    double sec = M_time;
    int h, m, s;
      
    s = (int) Math.round(sec); 
    m = s/60;
    s = s%60;  // same as s %= 60
    h = m/60;
    m = m%60;  // same as m %= 60
  
    String str;

    str = (s==1 ? "singular" : "plural" );
    str = (h==1 ? "singular" : "plural" );
    str = (m==1 ? "singular" : "plural" );

    System.out.println(h+" hour"+(h==1?" ":"s ")+m+" minute"+(m==1?" ":"s and ")+s+" second"+(s==1?".":"s."));
      
   }
}


    

