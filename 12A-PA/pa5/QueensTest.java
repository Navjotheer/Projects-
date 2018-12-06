import java.util.Scanner;

class QueensTest{
    public static void main(String [] args ){

        int i, n = args.length;
        int queens = 0;
        boolean verbose = false;
        if( args.length == 0) {
            System.out.println("Usage: Queens [-v] number");
            System.out.println("Option: -v verbose outpout, print all solutions");
        }
        for ( i = 0; i < n; i++){
            try{
               queens = Integer.parseInt(args[i]);
            } catch ( NumberFormatException e1){
                try{
                    Double.parseDouble(args[i]);
                    System.out.println(args[i] + "is a double");
                } catch (NumberFormatException e2){
                    if (args[i].equalsIgnoreCase("-v")){
                        verbose = true;
                        if(args.length > 1)
                            queens = Integer.parseInt(args[1]);
                    } else {
                        System.out.println("Usage: Queens [-v] number");
                        System.out.println("Options: -v verbose output, print all solutions");
                    }
                }
            }
        }
        int [] board = fillArray(queens);
        long f = factorial(board.length - 1);
        int counter = 0;

        for(int g = 0; g < f; g++){
            if(isSolution(board)){
                counter++;
                if(verbose)
                    printArray(board);
            }
            nextPermutation(board);
        }
        System.out.println(queens + "-Queens has " + counter + " solutions");
    }

    static int[] fillArray(int i) {
        int[] W = new int[i + 1];
        for(int x = 0; x < i + 1; x++)
            W[x] = x;
        return W;
    }

    static void nextPermutation(int[] A) {
        int pivot = 0, pI = 0, sI = 0;
        for(int i = A.length - 1; i > 0; i--){
            if(A[i - 1] < A[i]){
                pivot = A[i - 1];
                pI = i -1;
                break;
            }
        }
        if(pivot == 0){
            A = reverse(A, 0);
            return;
        }
        for(int t = A.length - 1; t > 0; t--)
            if(A[t] > pivot) {
                sI = t;
                break;
            }
        swap(A, pI, sI);
        A = reverse(A, pI);
    }

    static void swap(int[] A, int pivot, int successor){
        int temp = A[pivot];
        A[pivot] = A[successor];
        A[successor] = temp;
    }
    static boolean isSolution(int[] A){
        int n = A.length;
        for ( int i = 1; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int vert = Math.abs(A[i] - A[j]);
                int hor = Math.abs(i - j);
                if (vert == hor){
                    return false;
                }
                if(A[i] == A[j]){
                    return false;
                }
            }
            //return true;
        }
        return true; //
    }

    static void printArray(int[] P){
        System.out.print("(");
        for(int i = 1; i < P.length; i++){
            if(i == P.length - 1){
         //   System.out.print("(");
            System.out.print(P[i]);
           // System.out.print(")");
           } else{
System.out.print(P[i] + ",");
}

        }
         System.out.print(")");
        System.out.println("");
    }

    static int[] reverse(int[] A, int pivot){
        int i = pivot + 1;
        int j = A.length -1;
        while (i < j){
            swap(A, i, j);
            i++;
            j--;
        }
        return A;
    }

    static long factorial(long j){
        return j <= 1 ? 1 : j * factorial(j - 1);
    }
}

