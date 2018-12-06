//Navjot Heer
//Cruz ID: nsheer
//lab5
//DictionaryTest.c
//Test file for Dictionary ADT

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Dictionary.c"


#define MAX_LEN 180

int main(int argc, char* argv[]){
	Dictionary A  = newDictionary();

	//isEmpty test1 
     
	 printf("Dictionary Empty? %s\n");
	 printf((isEmpty(A)?"true":"false"));

	 //size test
	 printf("\n"); 
	 printf("Size of Dictionary= %d\n", size(A));

	 freeDictionary(&A);

	 //insert test and printDictionary
	 //Dictionary D = newDictionary();

	  Dictionary D = newDictionary();
      char* k;
   	  char* v;
      char* key[] = {"1","2","3","4"};
      char* val[] = {"I","hate","coding","fml"};
      int i;

	 
	for(i=0; i<4; i++){
      insert(D, key[i], val[i]);
   }
     printf("\n");
     printf("Insert test"); 
     

     printf("\n");
	 printDictionary(stdout, D);  
	 printf("Dictionary Empty? %s\n");
	 printf((isEmpty(D)?"true":"false"));
	 printf("\n"); 
	 printf("Size of Dictionary= %d\n", size(D));
 

	 //test lookup
	 printf("\n");
	 printf("Lookup test"); 

     printf("\n"); 
	 for(i=0; i<3; i++){
	 	k = key[i];
	 	v = lookup(D, k);
	 	printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
   }     

	//test delete 
   printf("\n"); 
   printf("Delete test"); 
   delete(D, "1");
   printf("\n"); 
   printDictionary(stdout, D);  
   printf("\n"); 



	  for(i=0; i<3; i++){
	 	k = key[i];
	 	v = lookup(D, k);
	 	printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
   }     
	 printf("Size of Dictionary= %d\n",size(D));
	 printf("\n"); 
	 printDictionary(stdout, D); 

	 //makeEmpty test
	 printf("\n"); 
	 printf("makeEmpty test");  

	 makeEmpty(D);
	 printf("\n"); 
	 printf("Dictionary Empty? %s\n");
	 printf((isEmpty(D)?"true":"false"));
	 printf("\n");
	 printf("Size of Dictionary= %d\n", size(D));

	 freeDictionary(&D);

     printf("\n"); 
	 printf("End of test");
	 printf("\n"); 

 	return(EXIT_SUCCESS);

}
