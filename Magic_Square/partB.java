import java.util.Scanner;
import java.util.Arrays;

/*

Tasks:
 - Prompt user for odd integer(DONE)
 - Create a Magic Square(DONE)
 - Shuffle magic square(DONE)
 - Display new magic sqaure to user(DONE)
 - Let the user reconstruct magic square(DONE)
 - Count how many moves taken when game finishes(DONE)

Other:
 - Find a way to save the array(DONE)
 - Find a way to compare to multidimensional arrays(DONE)
 - Make game design better!!!


*/

public class partB {
    public static void main(String[] args) {

        int moves = 0;

        //Ask user for size of magic square
        Scanner in = new Scanner(System.in);
        System.out.print( "Enter an odd number:  ");
        int n = in.nextInt();

        //Checks for even number
        if (n % 2 == 0) {
            System.out.println("Input is even. CLOSING PROGRAM.");
            System.exit(0);
        }

        //Creates and shuffles magic square
        MagicSquare square = new MagicSquare( n );
        System.out.println("Magic square for " + n + ":");
        square.showMagicSquare();
        square.MagicSnapShot();
        int [][] save = square.Temp;
        square.MagicShuffle();
        System.out.println( "New shuffled magic square" );
        square.showMagicSquare();


        // Used for swap.equals() conditions
        String Up = "Up";
        String Down = "Down";
        String Right = "Right";
        String Left = "Left";



        while ( true ) {
            if ( Arrays.deepEquals( square.Temp, square.array ) ) {
                System.out.println( "Magic Square Completed." );
                System.out.println( "Moves Made: " + moves );
                System.out.println( "CLOSING PROGRAM." );
                System.exit(0);
            } else {
                System.out.println( "Moves made: " + moves );
                Scanner position = new Scanner(System.in);
                System.out.println( "Fix the magic square in as few moves as possible." );
                System.out.print( "Input must be in the format (2 1 Down): " );
                int i = position.nextInt();
                int j = position.nextInt();
                String swap = position.next();
                if (swap.equals(Up)) {
                    square.SwitchUp( i, j );
                } else if (swap.equals(Left)) {
                    square.SwitchLeft( i, j );
                } else if (swap.equals(Down)) {
                    square.SwitchDown( i, j );
                } else if (swap.equals(Right)) {
                    square.SwitchRight( i, j );
                } else {
                   System.out.println( "Not a direction" );
               }
                System.out.println();
                System.out.println( "Orginal Magic Square");
                square.showSnapShot();
                System.out.println();
                System.out.println( "Your square: ");
                square.showMagicSquare();

                moves++;
            }
        }
    }
 }
