//Navjot Heer
//Cruz ID: nsheer
//lab7
//Dictionary.java
//Dictionary.c using Binary Search Tree translated into java

public class Dictionary implements DictionaryInterface {

	// private inner Node class
    private class Node {
       String key;
       String value;
       Node left;
       Node right;

     Node(String x, String y){
          key = x;
          value = y;
          right = null;
          left = null; 
       }
    }

    // Fields for the Dictionary class
   private Node root;    //reference to first Node
   private int numItems; // number of items in this Dictionary

    //Dictionary() 
    // constructor for the Dictionary class
    //public Dictionary(){
     //  root = null;
      // numItems = 0;
    //}

    // private helper function ----------------------------------------------

    // findKey()
	// returns the Node containing key k in the subtree rooted at R, or returns
	// NULL if no such Node exists
    private Node findKey(Node R, String k){
    	if(R == null || R.key.compareTo(k)==0){
    		return R;
    	  }

    	if(R.key.compareTo(k)>0){
    		return findKey(R.left, k);
    	}else{ // if(R.key.compareTo(k)>0)
    		return findKey(R.right, k);
    	}
    }

	// findParent()
	// returns the parent of N in the subtree rooted at R, or returns NULL 
	// if N is equal to R. (pre: R != NULL)
	private Node findParent(Node N, Node R){
    	Node P = null;
    	if(N!=R){
    		P=R;
    		while(P.left!=N && P.right != N){
    			if(N.key.compareTo(P.key)<0){
    				P = P.left;
    			}
    			else{
    				P=P.right;
    			}
    		}
    	}
  			return P;
  	}

  	// findLeftmost()
    // returns the leftmost Node in the subtree rooted at R, or NULL if R is NULL.
    private Node findLeftmost(Node R){
    	Node L = R;
    	if(L!=null)
    		for(; L.left != null; L=L.left);
    			return L;
    }

    // printInOrder()
    // prints the (key, value) pairs belonging to the subtree rooted at R in order
    // of increasing keys to file pointed to by out. 
     private void printInOrder(Node R) {
      
      if (R != null) {
        printInOrder(R.left);
        System.out.println(R.key + " " + R.value);
        printInOrder(R.right);
    }
      
      
   } 

   /*private String printInOrder(Node R){
	if( R! = null) return "";
	StringBuffer sb = new StringBuffer();
	sb.append(printInOrder(R.left));
	sb.append(R.key + " " + R.value;
	sb.append(printInOrder(R.right));
	return new String(sb); */


    // deleteAll()
    // deletes all Nodes in the subtree rooted at N.
    private void deleteAll(){
    	root = null;
    	numItems = 0;
    	
    }

    // public functions -----------------------------------------------------------

    //Dictionary() 
    // constructor for the Dictionary class
    public Dictionary(){
       root = null;
       numItems = 0;
    }

	// isEmpty()
	// returns 1 (true) if D is empty, 0 (false) otherwise
	// pre: none
	public boolean isEmpty(){
		return(numItems == 0);
	}

	// size()
	// returns the number of (key, value) pairs in D
	// pre: none
	public int size(){
		return(numItems);
	}

	// lookup()
	// returns the value v such that (k, v) is in D, or returns NULL if no 
	// such value v exists.
	// pre: none
	public String lookup(String key){
		Node N = findKey(root,key);
		if(N==null){
			return null;
		}
		return N.value;
	}

	// insert()
	// inserts new (key,value) pair into D
	// pre: lookup(D, k)==NULL
	public void insert(String key, String value) throws DuplicateKeyException{
		Node N, A, B;
		if(findKey(root,key)!=null){
			throw new DuplicateKeyException("Dictionary Error: insert() cannot insert duplicate keys");
		}
		N = new Node(key,value);
		B = null;
		A = root;
		while(A!=null){
			B=A;
			if(A.key.compareTo(key)>0){
				A = A.left;

			}else{
				A = A.right;
			}
		}
			if(B==null){
				root = N;
			} else if(B.key.compareTo(key)>0){
				B.left = N;
			}else{
				B.right = N;

				
			}
			numItems++;
			}
			

	// delete()
	// deletes pair with the key k
	// pre: lookup(D, k)!=NULL
	public void delete(String key) throws KeyNotFoundException{
	    Node N, P, S;
	    
     	if(findKey(root, key) == null){
         throw new KeyNotFoundException("Dictionary Error: delete() cannot delete non-existent key: ");
      }
       N = findKey(root,key);
       if(N.left == null && N.right == null){ //no children
       	if(N == root){
       		root = null;
       	}else {
       		P = findParent(N, root);
            if( P.right == N ){
             P.right = null;
         }
            else{
             P.left = null;
         }
        }
       	}
       else if(N.right == null){ // case 2, left but no right child
       	if( N == root){
       		root = N.left;
       	}else {
       		 P = findParent(N, root);
             if( P.right == N ){
              P.right = N.left;
             }else{
              P.left = N.left;
              }     
       	}

       } else if(N.left == null){ //case 2 right but no left child
       	    if( N == root ){
            root = N.right;
       }else{
       	    P = findParent(N, root);
            if( P.right == N ){
             P.right = N.right;
         }
            else{
             P.left = N.right;
         }
         }
       }
	 else {
		 S = findLeftmost(N.right);
         N.key = S.key;
         N.value = S.value;
         P = findParent(S, N);
         if( P.right == S ){ 
         P.right = S.right;
     	}
         else{ P.left = S.right;
         }
     
	}
	numItems--;
	}

	// makeEmpty()
	// re-sets D to the empty state.
	// pre: none
	public void makeEmpty(){
		deleteAll();
		root = null;
		numItems = 0;
	}

	// toString()
    // returns a String representation of this Dictionary
    // overrides Object's toString() method
    // pre: none
    public String toString(){
    	printInOrder(root);
    	return "";

    }
			
}


