
#Navjot Heer
#Cruz ID: nsheer
#Lab 2
#Makefile
#A simple makefile for lab 2. This makefile creates an 
#executable jar file called Recursion and includes a clean utility 
#that removes all .class files and jar files from the current directory


FileReverse: FileReverse.class
	echo Main-Class: FileReverse > Manifest
	jar cvfm FileReverse Manifest FileReverse.class
	rm Manifest
	chmod +x FileReverse

FileReverse.class: FileReverse.java
	javac -Xlint FileReverse.java

clean:
	rm -f FileReverse FileReverse.class
