# 1-800-CODING-CHALLENGE
Phonewords are mnemonic phrases represented as alphanumeric equivalents of a telephone number.
This application maps a list of phone numbers to a list of words that can be made out of the digit of phone numbers based on following mapping:
DIGIT CHARACTERS
6     M N O
7     P Q R S
8     T U V
9     W X Y Z

###Sample program output:
Phone Number  | Phone Words 
---------------------------
2255            | [CALL, CALK, BALK, BALL]                                                                                                                                                                                
63              | [OF, ME]                                                                                                                                                                                                
43556           | [HELLO]                                                                                                                                                                                                 
96753           | [WORLD]                                                                                                                                                                                                       


# Explanation of choice of problem and design
This provides an opportunity for good object oriented design and class organization along with encapsulating a good Algorithm implementation.

Flexible design to read input and write output to various media, currently supports file as main source of i/o, a skeleton implementation of console i/o is also included.

Use of TreeSet for storing the in-memory dictionary. It will enable efficient data retrieval.

Classes designed with Single responsibility principle.

Algorithm:
1. Read phone numbers from input file
2. Escape phone numbers for special characters while storing in-memory.
3. Read and store dictionary data in-memory in a TreeSet.
4. Escape words for special characters while storing in-memory.
5. Convert words to Upper case while storing in-memory.
6. Generate potential words for the given number.
7. Check the words against dictionary for existence.
8. In case of a match, the word is stored against the list of words for that number.
8. Write formatted output to the give output file.

##To-do:
Following items I wish and intended to include, but not able to give proper time because of a packed schedule.
Implement multi-part input number logic, like 2255.63 should translate to CALL-ME.

# Build and Package
To build the project, run the following command from project home directory
`mvn clean package`.
The built JAR along with sample dictionaries and inputs can be found in the `target` directory.

# Example usage
phone-word-1.0-SNAPSHOT [-d dictionary.txt] -i input.txt -o output.txt

The optional `-d` switch provides a custom dictionary of possible words to use.
If not provided then the default dictionary packaged in the JAR will be used.

The `-i` switch provides the input file having phone numbers, one number per line.

The `-o` switch provides the output file which will have the program output, this file will be created if not present, otherwise overwritten.

# Technology
- Java 8
- JUnit
