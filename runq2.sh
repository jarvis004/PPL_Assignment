# checking wheather log.txt file exist or not (if already exist then removes first )
file="log.txt"
if [ -f $file ] ; then
	rm $file
fi
# compiling java files
javac *.java
# passed the main class to command line argument
java q2
