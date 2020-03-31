import java.util.Scanner;


public class partA {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print( "Enter an odd number:  ");
        int n = in.nextInt();
        if (n % 2 == 0) {
            System.out.println("Input is even. CLOSING PROGRAM.");
            System.exit(0);
        }
        MagicSquare square = new MagicSquare( n );
        square.showMagicSquare();
        square.MagicSum();


    }
}
