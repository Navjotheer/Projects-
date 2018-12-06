
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

// private types --------------------------------------------------------------

// NodeObj
typedef struct NodeObj{
	char* key;
	char* value;
	struct NodeObj* next; 
} NodeObj;

// Node
typedef NodeObj* Node; 

// newNode()
// constructor of the Node type
Node newNode(char* k, char* v) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = k;
   N->value = v;
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for the Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}

// DictionaryObj
typedef struct DictionaryObj{
   Node head;
   Node tail;
   int numItems;
} DictionaryObj;

// public functions -----------------------------------------------------------

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void){
   Dictionary S = malloc(sizeof(DictionaryObj));
   assert(S!=NULL);
   S->head = NULL;
   S->tail = NULL;
   S->numItems = 0;
   return S;
}

// freeStack()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pS){
   if( pS!=NULL && *pS!=NULL ){
      if( !isEmpty(*pS) )makeEmpty(*pS);
      free(*pS);
      *pS = NULL;
   }


// isEmpty()
// returns 1 (true) if Dictionary is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary S){
   if( S==NULL ){
      fprintf(stderr, 
              "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   } //if statement???
   return(S->numItems==0);
} //return 1???

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary S){
	return S->numItems;
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
char* lookup(Dictionary S, char* k){ //////CHANGE 
  Node N = D->head;
       if( D == NULL ){
         fprintf(stderr, "Dictionary Error: calling lookup() on NULL Dictionary\n");
         exit(EXIT_FAILURE);
      }
      while(N != NULL){
         if(strcmp(N->key,k)== 0)
            return N->value;
         N = N->next;P
      }
         return NULL;;
      } 


// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary S, char* k, char* v){ //maybe uhhhhhhh
	 Node N = D->head;
      if( lookup(D,k) == NULL ){
          fprintf(stderr, "Dictionary error: key not found\n");
          exit(EXIT_FAILURE);
      }
        N = newNode(x);
        N->next = S->head;
        S->head = N;
        S->numItems++;
}



// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete(Dictionary S, char* k){ //fack
	Node N = D->head;
      if( lookup(D,k) == NULL ){
          fprintf(stderr, "Dictionary error: key not found\n");
          exit(EXIT_FAILURE);
      }
      N = S->top;
  	 returnValue = S->head->item;
   	 S->h = S->head->next;
   	 S->numItems--;
   	freeNode(&N);

}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary S){
	 S->head = NULL;
     S->tail = NULL;
     S->numItems = 0;

}

// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary S){
	Node N;
   		if( S==NULL ){
      fprintf(stderr, 
              "Dictionary Error: calling printDictionary() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   	}
   	for(N=S->head; N!=NULL; N=N->next) fprintf(out, "%s %s \n ", N->key, N->value); //DOUBLE CHECK THISSSSS SHIIII IF WORKS
   	fprintf(out, "\n");

}

}





