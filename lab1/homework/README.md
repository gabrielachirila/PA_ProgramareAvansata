Firstly, I verified if there are enough arguments at the command line, and after it I checked if n it is an integer or not. 
Then, I created the Latin Square as a matrix using a method for populating it, that beginning with the main diagonal it has the numbers from 1 to the rest of the line in ascending order, and below the main diagonal, the rest numbers that wasn't above the main diagonal in the precedent line, including the last element from the precedent line.
After it, I made 2 methods, one for getting the lines of the matrix, and the other for getting the columns. I casted the elements of the matrix from int to string and concatenated all from one line resulting one string.
For n larger than 30000 I calculated the running time in milliseconds.
