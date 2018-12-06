//Queens.java
//Navjot Heer
//nsheer
//pa5
//Prints number of solutions to n-Queens in normal mode. Prints permutations
//representing solutions to n-queens & number of solutions to n-queens in 
//verbose mode.

class Queens{
    public static void main(String [] args ){

        int i, m = args.length;
        int queen = 0;
        boolean verbose = false;

        if( args.length < 1 || args.length > 2) {
            System.out.println("Usage: Queens [-v] number");
            System.out.println("Option: -v   verbose output, print all solutions");
            return;
        }

        if(args.length == 1){
            try{
                queen = Integer.parseInt(args[0]);
            } catch ( NumberFormatException e1){
                System.out.println("Usage: Queens [-v] number");
                System.out.println("Option: -v   verbose output, print all solutions");
                return;
            }
        } else 
            try{
                queen = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e2){
                System.out.println("Usage: Queens [-v] number");
                System.out.println("Option: -v   verbose output, print all solutions");
                return;
            }
            
        if (args[0].equalsIgnoreCase("-v")){
            verbose = true;

        }


        int [] A = fillArray(queen);
        int f = fact(A.length - 1);
        int counter = 0;

        for(int g = 0; g < f; g++){
            if(isSolution(A)){
                counter++;
                if(verbose)
                    printArray(A);
            }
            nextPermutation(A);
        }
        System.out.println(queen + "-Queens has " + counter + " solutions"); 
    }

    static void nextPermutation(int[] A) {
        int pivot = 0, q = 0, r = 0;
        for(int i = A.length - 1; i > 0; i--){
            if(A[i - 1] < A[i]){
                pivot = A[i - 1];
                q = i -1;
                break;
            }
        }

        if(pivot == 0){
            A = reverse(A, 0);
            return;
        }

        for(int j = A.length - 1; j > 0; j--)
            if(A[j] > pivot) {
                r = j;
                break;
            }

        swap(A, q, r);
        A = reverse(A, q);

    }

    static boolean isSolution(int[] A){
        int n = A.length;
        for ( int i = 1; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int vertical = Math.abs(A[i] - A[j]);
                int horizontal = Math.abs(i - j);
                if (vertical == horizontal){
                    return false;
                }
                if(A[i] == A[j]){
                    return false;
                }
            }
            
        }
        return true; 
    }

    static void swap(int[] A, int pivot, int successor){
        int temp = A[pivot];
        A[pivot] = A[successor];
        A[successor] = temp;
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

    static int fact(int f){

        if(f>0){
            return f*fact(f-1);
        }else{
            return 1;
        }
    }

    static int[] fillArray(int i) {
        int[] Z = new int[i + 1];

        for(int x = 0; x < i + 1; x++)
            Z[x] = x;

        return Z;
    }

    static void printArray(int[] C){
        System.out.print("(");

        for(int i = 1; i < C.length; i++){                      
            if(i == C.length - 1){
                System.out.print(C[i]);
            } else{

                System.out.print(C[i] + ",");
            }

        }
        System.out.print(")");
        System.out.println("");
    }
}

