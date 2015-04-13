Task objective
=====================================

Find all unique configurations of a set of normal chess pieces on a chess board with dimensions M×N where none of the pieces is in a position to take any of the others. The colour of the piece does not matter. There are no pawns among the pieces.

Target task
=====================================

Provide answer the total number of unique configurations for a 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight.


Run by maven
-------------------------------------
1. To start user dialog and choose you oun configuration: 
$ mvn clean install exec:java -DskipTests=true
2. To see results for targen task:
$ mvn clean test

