import java.util.Random;
import java.util.Scanner;

// Guessing game interface for the game
interface GuessingGameForPlay {
    int playGame(String name, int a, int b);
}
// class Decoration{
//     public void welcome() {
//         verticalLine(12);
//         System.out
//                 .println("\t\t\t\t\t\tWELCOME TO\n\n\n\t\t\tGUESSER\t\t\t\t\t\t GAME\n\n\n\t\t\t\t\t\tWITH JAVA");
//         verticalLine(12);

//     }
//     public void verticalLine(int n) {
//         System.out.println("\n");
//         for (int i = 1; i <= n; i++) {
//             // Pattern Style
//             System.out.print("~~<_*_>~");
//         }
//         System.out.println("\n\n");
//     }
// }
// Guessing game implementation for interface 
class GuessingGameImpl implements GuessingGameForPlay {
    @Override
    public int playGame(String name, int a, int b) {
        Random r = new Random();
        int trialsForGame= 0;
        while (true) {
            int v = r.nextInt(b - a + 1) + a;
            System.out.printf("%s, Please guess the number between %d and %d: \n", name, a, b);
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == v) {
                System.out.printf("%s, congratulations! You guessed the number in %d trials.\n", name, trialsForGame);
                break;
            } else if (choice > v) {
                System.out.printf("%s, OOPS! You have to guess a smaller number.\n", name);
            } else {
                System.out.printf("%s, OOPS! You have to guess a greater number.\n", name);
            }
            trialsForGame++;
        }
        return trialsForGame;
    }
}

// Main game class

public class ProgramGame {
    public static void main(String[] args) {
        Decoration d = new Decoration();
        d.welcome();
        System.out.println("Please enter the starting number from where you want to guess number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Please enter the ending number from where you want to guess number : ");
        int b = sc.nextInt();
         d.verticalLine(12);
        GuessingGameForPlay game = new GuessingGameImpl();

        System.out.println("Now it's the turn of player one.");
        System.out.println("Player 1, please enter your name: ");
        String name1 = sc.next();
        int g1 = game.playGame(name1, a, b);
       d.verticalLine(12);
        System.out.println("Now it's the turn of player two.");
        System.out.println("Player 2, please enter your name: ");
        String name2 = sc.next();
        int g2 = game.playGame(name2, a, b);

        if (g1 < g2) {
            d.verticalLine(12);
            System.out.println("Congratulations, " + name1 + "! You won the game.");
            d.verticalLine(12);
        } else if (g1 > g2) {
            d.verticalLine(12);
            System.out.println("Congratulations, " + name2 + "! You won the game.");
            d.verticalLine(12);
        } else {
            d.verticalLine(12);
            System.out.println("What a miracle! This is a tie match. You both can enjoy the game again.");
            d.verticalLine(12);
        }
    }
}
