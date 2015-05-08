Task objective
=====================================

Find all unique configurations of a set of normal chess pieces on a chess board with dimensions M×N where none of the pieces is in a position to take any of the others. The colour of the piece does not matter. There are no pawns among the pieces.

Target task
=====================================

Provide answer the total number of unique configurations for a 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight.


Run by maven
-------------------------------------
1. To start user dialog and choose your own configuration: 
$ mvn clean install exec:java -DskipTests=true
2. To see results for targen task:
$ mvn clean test

Target task validation
=====================================
Target task for board 7х7:
Count of unique configuration for 2Q, 2B, 2K and N is 3063828

1. Result configurations were stored in file you can find here
http://www.ex.ua/90313529

2. To validate uniqueness strings in txt file you can use corresponding unix command uniq. For example:
$ sort output.txt | uniq -d > output1.txt

3. For chess positions validation please consider following code:
https://github.com/rminko/sandbox/blob/master/chessboard/src/test/java/TestChessboard.java#L180-L191

From my test output file was successfully validated - 3063828 options
