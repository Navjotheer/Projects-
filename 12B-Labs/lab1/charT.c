/*
 * Navjot Heer
 * Cruz ID: nsheer
 * lab4
 * charType.c
 * charType.c will take an input file, read it, and print out 
 * what line alpahbetic characters, digits, punctuation and whitespace 
 * were found on into an output file. 
 */

#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>
#include<string.h>

#define MAX_STRING_LENGTH 100

// function prototype
void extract_chars(char* s, char* a, char* d, char* p, char* w);

// function main which takes command line arguments
int main(int argc, char* argv[]){
   FILE* in;        // handle for input file
   FILE* out;       // handle for output file
   char* line;      // string holding input line
   char* alphabet; // string holding all alphabet chars
   char* digit;
   char* punct;
   char* whitespace;

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

   // allocate strings on the heap
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   alphabet = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   digit = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   punct = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   whitespace = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line!=NULL && alphabet!=NULL && digit!=NULL && punct!=NULL && whitespace!=NULL );

   int lineNum = 0;
   
   //extract alpha-numeric chars
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
       lineNum++;
       extract_chars(line, alphabet, digit, punct, whitespace);

        fprintf(out, "line %d contains: \n", lineNum);

        fprintf(out, "%lu ", strlen(alphabet));
        if(strlen(alphabet) == 0 || strlen(alphabet) == 1 || strlen(alphabet) > 1 ){

        fprintf(out, "%s", "alphabet characters: ");
        fprintf(out, "%s\n", alphabet);
      }

       // extract digits
       fprintf(out, "%lu ", strlen(digit));
       if ( strlen(digit) == 0 || strlen(digit) == 1 || strlen(digit) > 1 ){
       fprintf(out, "%s", "numeric character: ");
       fprintf(out, "%s\n", digit);
     }
       // extract punctuation 
       fprintf(out, "%lu ", strlen(punct));
       if ( strlen(punct) == 0 || strlen(punct) == 1 || strlen(punct) > 1 ){
       fprintf(out, "%s", "punctuation character: ");
       fprintf(out, "%s\n", punct);
     }
        // extract whitespace
       fprintf(out, "%lu ", strlen(whitespace));
       if ( strlen(whitespace) == 0 || strlen(whitespace) == 1 || strlen(whitespace) > 1 ){
       fprintf(out, "%s", "whitespace character: ");
       
       fprintf(out, "%s\n", whitespace);
     }
   }

   // free heap memory
   free(line);
   free(alphabet);
   free(digit);
   free(punct);
   free(whitespace);

   // close input and output files
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
/*void extract_chars(char* s, char* a, char* d, char* p, char* w) {

    int i=0, j=0;
    int r=0, q=0;
    int l=0, k=0;
    int n=0, m=0;

    while(s[i]!='\0' && i<MAX_STRING_LENGTH){
       if( isalpha( (int)s[i]) ) {
           a[j++] = s[i]; // if s[i] is alphabet, put it into array a :)
       }
       i++;
   }
    while(s[r]!='\0' && i<MAX_STRING_LENGTH) {
       if( isdigit( (int)s[r] ) ) { // if value at s[i] is digit
           d[q++] = s[r]; // if s[i] is digit, put it into array d :)
       }
       r++;
   }
   while(s[l]!='\0' && i<MAX_STRING_LENGTH){
       if( ispunct( (int)s[l]) ) {
           p[k++] = s[l]; // if s[i] is punct, put it into array p :)
       }
       l++;
   }
   while(s[n]!='\0' && i<MAX_STRING_LENGTH){
       if( isspace( (int)s[n]) ) {
           w[m++] = s[n]; // if s[i] is whitespace, put it into array w :)
       }
       n++;
   }
    a[j] = '\0';
    d[q] = '\0';
    p[k] = '\0';
    w[m] = '\0';
}
*/
// function definition 
void extract_chars(char* s, char* a, char* d, char* p, char* w){

   int g=0, h=0;
   int i=0, j=0;
   int k=0, l=0;
   int m=0, n=0;

   
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( isdigit( (int) s[g]) ) a[h++] = s[g];
      g++;
   }
  

   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( isalpha( (int) s[i]) ) b[j++] = s[i];
      i++;
}

   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( ispunct( (int) s[k]) ) c[l++] = s[k];
      k++;

}
   while(s[n]!='\0' && i<MAX_STRING_LENGTH){
       if( isspace( (int)s[n]) ) {
           s[n] = d[m++]; 
       }
       n++;
   }

a[j] = '\0';
b[j] = '\0';
c[j] = '\0';
d[j] = '\0';


}
