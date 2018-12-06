#Makefile
#Navjot Heer
#nsheer
#lab8
# A simple Makefile for the GCD program

GCD: GCD.o
	gcc -o GCD GCD.o

GCD.o: GCD.c
	gcc -c -std=c99 GCD.c

clean:
	rm -f GCD GCD.o

submit: Makefile GCD.c
	submit cmps012a-pt.w17 lab8 Makefile GCD.c
