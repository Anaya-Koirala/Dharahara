import java.lang.StringBuilder;

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
                    tower.append("│");
                } else {
                    tower.append(" ");
                }
            }
            tower.append("\n");
        }
        return tower.toString();
    }

    public static void main(String[] args) {
        int rings = 4;
        Dharahara d = new Dharahara(rings);
        System.out.printf("%s", d);
    }
}
