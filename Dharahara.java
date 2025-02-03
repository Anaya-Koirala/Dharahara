import java.lang.StringBuilder;
import java.util.Scanner;

public class Dharahara {
    private int rings;
    private int[][] gameState; // 0 -> " ", 1 -> *, -1 = "|";

    public Dharahara(int rings) {
        this.rings = rings;
        gameState = new int[this.rings][3*((2 * this.rings) - 1) - 2]; //TODO: Find out the right size
        initializeRings();
        initializePipes();
    }

    private void initializeRings() {
        for (int row = 0; row < rings; row += 1) {
            int ringsEndIndex = 2 * (row + 1) - 1;
            int ringsStartIndex = (rings - 1) - row;
            for (int col = 0; col < ringsEndIndex; col += 1) {
                gameState[row][ringsStartIndex + col] = 1;
            }
        }
    }

    private void initializePipes() {
        int offset = 3*this.rings - 2;
        for (int row = 0; row < rings; row +=1){
            gameState[row][offset] = -1;
            gameState[row][2*offset-2] = -1;
        }
    }

    public String toString() {
        StringBuilder tower = new StringBuilder();

        for (int row = 0; row < rings; row+=1) {
            for (int col = 0; col < gameState[row].length; col+=1) {
                if (gameState[row][col] == 1) {
                    tower.append("▄");
                } else if (gameState[row][col] == -1) {
                    tower.append("║");
                } else {
                    tower.append(" ");
                }
            }
            tower.append("\n");
        }

        for (int i=0; i < gameState[0].length+6; i++){
            tower.append("‾");
        }

        return tower.toString();
    }

    public static void printMainMenu(){
        System.out.println(" ____  _                     _");
        System.out.println("|  _ \\| |__   __ _ _ __ __ _| |__   __ _ _ __ __ _");
        System.out.println("| | | | '_ \\ / _` | '__/ _` | '_ \\ / _` | '__/ _` |");
        System.out.println("| |_| | | | | (_| | | | (_| | | | | (_| | | | (_| |");
        System.out.println("|____/|_| |_|\\__,_|_|  \\__,_|_| |_|\\__,_|_|  \\__,_|\n\nThe Tower of Kathmandu. Press h for help \n");
    }

    public static void printHelpMenu(){
        System.out.println("Welcome to Dharahara: 'The Tower of Kathmandu!'\n");
        System.out.println("This game is a terminal based replica of the popular puzzle The Tower of Hanoi.\n");
        System.out.println("Objective: Move all the discs from Peg 1 to Peg 3.");
        System.out.println("\t1. You can only move one disc at a time.");
        System.out.println("\t2. A disc can only be moved to the top of another peg if it is smaller than the disc already on that peg.");
        System.out.println("\t3. You can move discs between three pegs: Peg 1, Peg 2, and Peg 3.\n");
        System.out.println("Game Controls:");
        System.out.println("\t1. The game will prompt you to move a disc from one peg to another.");
        System.out.println("\t2. You will be asked to provide the peg number you are moving the disc from (1, 2, or 3).");
        System.out.println("\t3. Then, you will provide the peg number you want to move the disc to (1, 2, or 3).");
        System.out.println("\tFor example: If you want to move a disc from Peg 1 to Peg 3, you would enter '1 3'.\n\n");
        System.out.println("Good luck ! (P.S wanna learn about the dharahara? : https://w.wiki/CvTS)");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int to, from, rings;

        printMainMenu();
        System.out.print("Enter the number of rings (> 1): ");
        rings  = input.nextInt();

        if (rings <= 1){
            System.out.println("\n**Number of rings MUST BE GREATER THAN 1.**");
            return;
        }

        Dharahara d = new Dharahara(rings);

        do {
            System.out.println(d);
            System.out.print("From/To: ");
            try {
                to = input.nextInt();
                from = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                printHelpMenu();
            }

        } while(false);
    }
}
