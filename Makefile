# minimal makefile for SE class
all: test

# main depends on all cpp files
%.class: %.java
	javac $^

test: Main.class TestSuite.class
	#java Main DollarToEuro 10000
	java TinyTestJ.RunTests TestSuite

clean:
	rm *.class

