//Roots.java
//Navjot Heer
//nsheer
//Pa4
//Determines the real roots of a polynomial
//that lie within a specified range

import java.util.Scanner;

class Roots {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double a, b, l, r;
        double resolution = .01;
        double tolerance = .0000001;
        double threshold = .001;
        double [] equation;

        System.out.print("Enter the degree: ");
        n = sc.nextInt();
        n++;

        System.out.print("Enter "+n+" coefficients: ");
        equation = new double[n];
        for(int i = 0; i < n; i++){
            equation[i] = sc.nextDouble();
        }

        System.out.print("Enter the left and right endpoints: ");
        l = sc.nextDouble();
        r = sc.nextDouble();

        double[] derivative = equation.clone();
        derivative = diff(derivative);

        a = l;
        b = a + resolution;
        int count = 0;
        System.out.println("");
        while(a<=r){
            if(poly(equation, a) * poly(equation, b) <= 0){
                double rt = findRoot(equation, a, b, tolerance);
                System.out.print("Root found at ");
                System.out.printf("%.5f%n", rt);
                count++;
            }
            else if(poly(derivative, a) * poly(derivative, b) <= 0){
                double rt = findRoot(derivative, a, b, tolerance);
                if(Math.abs(poly(equation, rt)) < threshold){
                    count++;
                    System.out.print("Root found at ");
                    System.out.printf("%.5f%n", rt);

                }
            }
            a = b;
            b += resolution;
        }

        if (count == 0){
            System.out.print("\nNo roots were found in the specified range.");
        }
    }

    public static double poly(double [] J, double x){
        double sum = 0.0;
        for(int i = 0; i < J.length; i++){
            sum += J[i] * Math.pow(x, i);
        }
        return sum;
    }

    public static  double[] diff(double[] K){
        double[] J = new double[K.length-1];
        for(int i = 0; i < J.length; i++){
           J[i] = (i+1)*K[i+1];
        }
        return J;
    }

    public static double findRoot(double[] J, double a, double b, double tolerance){
        double mid = a;
        double width = b-a;
        while(width>tolerance){
            mid = (a+b)/2;
            if(poly(J,a) * poly(J,mid)<=0){
                b = mid;
            } else{
                a = mid;
            }
            width = b-a;
        }
        return mid;
    }
}

