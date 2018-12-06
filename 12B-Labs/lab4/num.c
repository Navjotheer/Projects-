/*
 * Navjot Heer
 * Cruz ID: nsheer
 * lab 4
 * charType.c
 * charType.c will t takes two command line arguments giving 
 * the input and output file names respectively, then classify
 * the characters on each line of the input file into the following 
 * categories: alphabetic characters, numeric characters, punctuation, 
 * and white space. 
 */ 



#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

// function prototype 
void extractNumba(char* s, char* a);

// function main which takes command line arguments 
int main(int argc, char* argv[]){
   FILE* in;        // handle for input file                  
   FILE* out;       // handle for output file                 
   char* line;      // string holding input line              
   char* num; // string holding all alpha-numeric chars 

   // check command line for correct number of arguments 
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   // allocate strings line and alpha_num on the heap 
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   num = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line!=NULL && num!=NULL );

   // read each line in input file, extract alpha-numeric characters 
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extractNumba(line, num);
      fprintf(out, "%s\n", num);
   }

   // free heap memory 
   free(line);
   free(num);

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
void extractNumba(char* s, char* a){
   int i=0, j=0;
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( isalnum( (int) s[i])){
      	a[j] = s[i];
      }
      i++;
   }
   a[j] = '\0';
}
