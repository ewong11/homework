/*Eric Wong
APCS1 pd02
HW38 -- Put it together
2017-11-22

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
                while (counter < 4) {
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
        System.out.println("Enter the positions of the two strings you want to swap, with a 4 digit integer");
        System.out.println("in which the first two digits represent the row and column of the first String,");
        System.out.println("the last two digits represent the row and column of the second String");
    }
    /*-----------------------------------
    swap() swaps the position of two elements of the 2D array
    
    -takes user input in the form of a 4 digit integer
    -the first 2 digits represent the row and column of the first string
    -the second 2 digits represent the row and column of the second string
    
    precondition: an existing array that contains elements
    postcondition: the same array, but with two specified Strings swapped in position
    -----------------------------------------*/
    
    public static void swap(String[][] z) {
        //getting user input
        Keyboard k = new Keyboard();
        int a = k.readInt();
        String b = Integer.toString(a);
        
        //extracting user input for the positions of each element
        int rowA = Integer.parseInt(b.substring(0,1));
        int columnA = Integer.parseInt(b.substring(1,2));
        int rowB = Integer.parseInt(b.substring(2,3));
        int columnB = Integer.parseInt(b.substring(3));
        String origA = z[rowA][columnA];
        
        //the swapping of the two elements
        z[rowA][columnA] = z[rowB][columnB];
        z[rowB][columnB] = origA;
        
        //printing new array
        for (String[] m: z) {
            for (String j: m) {
                System.out.print(j + "\t");
            }
            System.out.println();
    }
    }   
    public static void main(String[] args) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[][] s = new String[3][4];
        makeTable(s);
        swap(s);
    }
}

    
    

        