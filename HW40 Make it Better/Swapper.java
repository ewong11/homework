/*Eric Wong
APCS1 pd02
HW40 -- Make It Better
2017-11-27

-----------------------------------------------------------------
EXPLANATION OF CODE
-----------------------------------------------------------------
the makeTable() method creates a visual representation of a 2D Array, in which:
- All elements of the array are Strings
- strings are made randomized using the alphabet
    I use Math.random to generate random indicies to get a random letter from the alphabet
    for each String, I repeat this 4 times to have a random string of 4 letters

the swap() method could probably be more efficient, but it works!
-takes user input in the form of a 4 digit integer
-the first 2 digits represent the row and column of the first string
-the second 2 digits represent the row and column of the second string
--------------------------------------------------------------------
VERSION 2
--------------------------------------------------------------------

I changed makeTable() so that it can populate the array with both 3 character strings and 4 character strings,
whereas previously it would create an array with only 4 character strings

i improved the user interface (thanks to my boy Henry) so the user would input the position (row and column)
of each string one at a time, rather than four numbers at once, which can be confusing and hard to read.

i allowed the user to choose how large they wanted their array as well
*/


import cs1.Keyboard;

public class Swapper {
    //displays a visual representation of a 2D array consisting of 4-character Strings
    public static void makeTable(String[][] s) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String[][] s = new String[3][4];
        for (int x =0; x < s.length; x++) {
            for(int y = 0; y < s[x].length; y ++) {
                String finalString = "";
                int counter = 0;
                int len = 4;
                if (Math.random() > .5) {
                    len = 3;
                }
                while (counter < len) {
                    int index = (int)(Math.random() * 26);
                    finalString += LETTERS.substring(index, index + 1);
                    counter += 1;
                }
                //System.out.print(finalString);
                s[x][y] = finalString;
                System.out.print(s[x][y] + "\t");
                
            }
        System.out.println();
        }
    }
    /*-----------------------------------
    swap() swaps the position of two elements of the 2D array
    
    takes four integer inputs, one at a time instead of all 4 separately
    the first two inputs are the row and column of the first string
    the second two inputs are the row and clumn of the second string
    after inputting the two positions, the two strings will swap
    
    precondition: an existing array that contains elements
    postcondition: the same array, but with two specified Strings swapped in position
    -----------------------------------------*/
    
    public static void swap(String[][] z) {
        //getting user input
        Keyboard k = new Keyboard();
        System.out.print("Enter the row of the first string: ");
        int rowA = k.readInt();
        System.out.print("Enter the column of the first string: ");
        int columnA = k.readInt();
        System.out.print("Enter the row of the second string: ");
        int rowB = k.readInt();
        System.out.print("Enter the column of the second: ");
        int columnB = k.readInt();
        
        //the swapping of the two elements
        String origA = z[rowA][columnA];
        z[rowA][columnA] = z[rowB][columnB];
        z[rowB][columnB] = origA;
        
        //printing new array
        System.out.println("New Array!");
        System.out.println();
        for (String[] m: z) {
            for (String j: m) {
                System.out.print(j + "\t");
            }
            System.out.println();
    }
    }   
    public static void main(String[] args) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // user initializes num of rows and columns of their desired array
        System.out.print("How many rows do you want your array to have: ");
        int numRows = Keyboard.readInt();
        System.out.print("How many columns should your array have: ");
        int numCols = Keyboard.readInt();
        //------------------------------------------------------------------
        String[][] s = new String[numRows][numCols];
        makeTable(s);
        swap(s);
    }
}

    
    

        