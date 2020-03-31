import java.util.Scanner;



//Class containing methods for Question 1
public class MagicSquare {

    // Instance variables declared here:
    private int n;
    public int [][] array;
    public int [][] Temp;
    private int sum = n * (((n * n) + 1) / 2);
    private int direction;

    // Constructors:

    public MagicSquare( int input ) {
        //This creates the magic square
        n = input;
        array = new int[n][n];
        // x,y is the starting point
        int x = n / 2;
        int y = n - 1;


        for ( int k = 1 ; k <= n * n ; ) {
            if ((x == -1) && (y == n)) {
                x = 0;
                y = y - 2;
            } else {
                if (x == -1) {
                    x = n - 1;
                } else if (y == n) {
                    y = 0;
                }
            }
            /*
            Code above used to wrap array so that after the last row
            is the first row. Avoids out of bounds errors.
            */

            if (array[x][y] != 0) {
                x = x + 1;
                y = y - 2;
                continue;
            } else {
                // Increasing k here, not in loop
                array[x][y] = k++;
                //added at the end because of errors(Out of bounds)
                x = x - 1;
                y = y + 1;
            }
        }
    }

    // Setters:

    // Getters:

    public int getDirection() {
        return direction;
    }

    // Methods:

    public void MagicSnapShot( ) {
        Temp = new int[n][n];
        for ( int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < n ; j++ ) {
                Temp[i][j] = array[i][j];
            }
        }
    }


    public void showSnapShot() {
        for ( int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < n ; j++ ) {
                System.out.print( Temp[i][j] + " " );
            } System.out.println( " ");
        }
    }

    public void showMagicSquare() {
        //Print the array to terminal in a square format
        for ( int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < n ; j++ ) {
                System.out.print( array[i][j] + " ");
            } System.out.println( " ");
        }
    }


    public void MagicSum() {
        int sum = n * (((n * n) + 1) / 2);
        System.out.println("All rows, collumns and diagonals add to " + sum);
    }


    public void MagicShuffle() {
        for ( int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < n ; j++ ) {
                MagicRandom();
                getDirection();
                if (direction == 1) {
                    SwitchUp(i, j);
                } else if (direction == 2) {
                    SwitchLeft(i, j);
                } else if (direction == 3) {
                    SwitchDown(i, j);
                } else {
                    SwitchRight(i, j);
                }
            }
        }
    }

    public void MagicRandom() {
        double rand = Math.random();
        if (rand < 0.25) {
            direction = 1;
        } else if ((rand > 0.26) & (rand < 0.5)) {
            direction = 2;
        } else if ((rand > 0.51) & (rand < 0.75)) {
            direction = 3;
        } else {
            direction = 4;
        }
    }


    // Methods for switching

    public void SwitchUp( int i, int j ) {
        if (i == 0) {
            int temp = array[i][j];
            array[i][j] = array[n - 1][j];
            array[n - 1][j] = temp;
        } else {
            int temp = array[i][j];
            array[i][j] = array[i - 1][j];
            array[i - 1][j] = temp;
        }
    }

    public void SwitchLeft( int i, int j ) {
        if (j == 0) {
            int temp = array[i][j];
            array[i][j] = array[i][n - 1];
            array[i][n - 1] = temp;
        } else {
            int temp = array[i][j];
            array[i][j] = array[i][j - 1];
            array[i][j - 1] = temp;
        }
    }

    public void SwitchDown( int i, int j ) {
        if (i == n - 1) {
            int temp = array[i][j];
            array[i][j] = array[0][j];
            array[0][j] = temp;
        } else {
            int temp = array[i][j];
            array[i][j] = array[i + 1][j];
            array[i + 1][j] = temp;
        }
    }

    public void SwitchRight( int i, int j ) {
        if (j == n - 1) {
            int temp = array[i][j];
            array[i][j] = array[i][0];
            array[i][0] = temp;
        } else {
            int temp = array[i][j];
            array[i][j] = array[i][j + 1];
            array[i][j + 1] = temp;
        }
    }


}
