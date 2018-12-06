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
   Node newNode(char* k, char* v){
      Node N = malloc(sizeof(NodeObj)); //allocate memory in heap
      assert(N!=NULL);                  //checks for memory allocation
      N->key = k;
      N->value = v;                     // intialize nodes
      N->next = NULL;
      return(N);                       
   }

   // freeNode()
  // destructor for the Node type
   void freeNode(Node* pN){
      if(pN!=NULL && *pN!=NULL ){
         free(*pN);               //free memory allocated
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
      Dictionary D = malloc(sizeof(DictionaryObj)); //allocating memory in heap for Dict
      assert(D != NULL);              //making sure memory is allocated             
      D->head = NULL;                //initialize Dict. fields                 
      D->tail = NULL;
      D->numItems = 0;
      return D;       //return pointer to Dictionary
   }

   

   // freeStack()
  // destructor for the Dictionary type
   void freeDictionary(Dictionary* pD){
      if( pD!=NULL && *pD!=NULL){  //free mem. allocated
         if( !isEmpty(*pD) )makeEmpty(*pD);
            free(*pD);
         *pD = NULL;
      }
   }

   
   int isEmpty(Dictionary D){
      if( D ==NULL ){  //making sure not referencing null dict. 
         fprintf(stderr, "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");     
         exit(EXIT_FAILURE);
      }
      if(D->numItems>0){ //returns true if empty
         return 0;
      }
      return 1;
   }

   
  // size()
  // returns the number of (key, value) pairs in D
  // pre: none
   int size(Dictionary D){
    if( D == NULL){  // referencing a NULL Dictionary or not
    fprintf(stderr, "Dictionary Error: calling size() on NULL Dictionary reference\n");
    exit(EXIT_FAILURE);
  }
      return D->numItems;
   }

   // lookup()
  // returns the value v such that (k, v) is in D, or returns NULL if no 
  // such value v exists.
  // pre: none
   char* lookup(Dictionary D, char* k){
       Node N = D->head;
       if( D == NULL ){  // check if referencing a NULL Dictionary
         fprintf(stderr, "Dictionary Error: calling lookup() on NULL Dictionary\n");
         exit(EXIT_FAILURE);
      }
      while(N != NULL){  //while not null
         if(strcmp(N->key,k)== 0)
            return N->value;
         N = N->next;
      }
         return NULL;;
      }

  // insert()
  // inserts new (key,value) pair into D
  // pre: lookup(D, k)==NULL
   void insert(Dictionary D, char* k, char* v){
      if(D->numItems == 0){       //if list is empty
         D->head = D->tail = newNode(k, v);
      }else{
         Node N;
         N = newNode(k, v);
         D->tail->next = N;
         D->tail = N;   //adding new node to end 
       }
       D->numItems++; //increment for num of items 
   }

  // makeEmpty()
  // re-sets D to the empty state.
  // pre: none
   void makeEmpty(Dictionary D){
      D->head = NULL;
      D->tail = NULL;
      D->numItems = 0;
}

  // delete()
  // deletes pair with the key k
  // pre: lookup(D, k)!=NULL
   void delete(Dictionary D, char* k){
      Node N = D->head;
      if( lookup(D,k) == NULL ){  //key does not exist
          fprintf(stderr, "Dictionary error: key not found\n");
          exit(EXIT_FAILURE);
      }
      if(strcmp(N->key,k)==0){
         Node A = D->head;
         Node B = A->next;
         D->head = B;
         freeNode(&A);
      }else{
         while(N !=NULL && N->next != NULL){
            if(strcmp(N->next->key, k)==0){
            Node B = N;
            Node C = N->next;
            B->next = C->next;
            N=B;
            freeNode(&C);
            }
         N = N->next;
        }
      }
      D->numItems--;
 }

// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
   void printDictionary(FILE* out, Dictionary D){
      Node N;
      if( D==NULL ){
         fprintf(stderr, "Dictionary Error: calling printDictionary() on NULL Dictionary reference\n");
         exit(EXIT_FAILURE);
      }
      for(N=D->head; N!=NULL; N=N->next) fprintf(out, "%s %s \n" , N->key, N->value); //Begins @Head
      fprintf(out, "\n"); //print 
   }
