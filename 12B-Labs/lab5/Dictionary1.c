//Navjot Heer
//Cruz ID: nsheer
//lab5
//Dictionary.c
//Dictionary ADT written in c

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
}


   int isEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
         "Error: calling isEmpty() on NULL Dictionary \n");
      exit(EXIT_FAILURE);
   }
   if(D->numItems>0){
	   return 0;
   }else{
	   return 1;
   }
}

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
char* lookup(Dictionary S, char* k){ 
  Node N = S->head;
       if( S == NULL ){
         fprintf(stderr, "Error: calling lookup() on NULL Dictionary\n");
         exit(EXIT_FAILURE);
      }
      while(N != NULL){
         if(strcmp(N->key,k)== 0)
            return N->value;
         N = N->next;
      }
         return NULL;;
      } 


// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary S, char* k, char* v){ 
	// Node N = S->head;
      if( lookup(S,k) == NULL ){
          fprintf(stderr, "Error: key not found\n");
          exit(EXIT_FAILURE);
      }
      if(S->numItems == 0){
      	S->head = S->tail;
      	S->tail = newNode(k, v);

      }else{
      	Node N;
      	N = newNode(k,v);
      	S->tail->next = N;
      	S->tail = N;
      }
      S->numItems++;
       
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
              "Error: calling printDictionary() on NULL Dictionary \n");
      exit(EXIT_FAILURE);
   	}
   	for(N=S->head; N!=NULL; N=N->next) fprintf(out, "%s %s \n ", N->key, N->value); 
   	fprintf(out, "\n");

}


/*void delete(Dictionary S, char* k){
   if( lookup(S, k)==NULL ){
      fprintf(stderr, 
         "Error: unable to delete non-existent key\n");
      exit(EXIT_FAILURE);
   }else{
      if(S->numItems <= 1){
         Node N = S->head;
         S->head = (S->head)->next;
         N->next = NULL;
         S->numItems--;
      }else{
         Node N = S->head;
         if(strcmp((N->key), k)==0){
            S->head = N->next;
            S->numItems--;
         }else{
            while(!(strcmp((N->next->key),k)==0)){
               N = N->next;
            }
            N->next = N->next->next;
            S->numItems--;
         }
      }
   }
} */

void delete(Dictionary S, char* k){
      Node N = S->head;
      if( lookup(S,k) == NULL ){
          fprintf(stderr, "Dictionary error: key not found\n");
          exit(EXIT_FAILURE);
      }
      if(strcmp(S->key,k)==0){
         Node P = S->head;
         Node G = S->next;
         S->head = G;
         freeNode(&P);
      }else{
         while(N !=NULL && N->next != NULL){
            if(strcmp(N->next->key, k)==0){
            Node G = N;
            Node C = N->next;
            G->next = C->next;
            N=G;
            freeNode(&C);
            }
         N = N->next;
        }
      }
      S->numItems--;
 }








