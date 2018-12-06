#------------------------------------------------------------------------------
# Navjot Heer
# Cruz ID: nsheer
# lab5
# Makefile for any ADT and its test client
#------------------------------------------------------------------------------

ADT_NAME  = Dictionary
SOURCES   = Dictionary.c DictionaryClient.c
OBJECTS   = Dictionary.o DictionaryClient.o
HEADERS   = Dictionary.h
EXEBIN    = DictionaryClient
FLAGS     = -std=c99 -Wall

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 
