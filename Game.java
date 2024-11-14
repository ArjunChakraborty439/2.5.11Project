import java.util.Random;
import java.util.Scanner;

public class Game {
    private int pileSize;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private static final Random random = new Random();

    // Constructor initializes the game with random pile size and sets up players
    public Game(Player player1, Player player2) {
        this.pileSize = random.nextInt(41) + 10; // Random pile size between 10 and 50
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = random.nextBoolean() ? player1 : player2; // Random first player
    }

    // Main game loop
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting Game of Nim with " + pileSize + " pieces.");
        while (pileSize > 0) {
            System.out.println("\nPile size: " + pileSize);
            System.out.println(currentPlayer.getName() + "'s turn.");

            int piecesToRemove;
            if (currentPlayer.isComputer()) {
                piecesToRemove = getComputerMove();
                System.out.println("Computer removes " + piecesToRemove + " pieces.");
            } else {
                piecesToRemove = getPlayerMove(scanner);
            }

            pileSize -= piecesToRemove;

            if (pileSize == 0) {
                System.out.println(currentPlayer.getName() + " took the last piece and loses!");
                System.out.println("Winner: " + getOtherPlayer().getName());
            } else {
                switchPlayer();
            }
        }

        scanner.close();
    }

    // Get a valid move from the player
    private int getPlayerMove(Scanner scanner) {
        int maxRemovable = Math.max(1, pileSize / 2);
        int piecesToRemove = 0;

        while (piecesToRemove < 1 || piecesToRemove > maxRemovable) {
            System.out.print("Enter pieces to remove (1 to " + maxRemovable + "): ");
            if (scanner.hasNextInt()) {
                piecesToRemove = scanner.nextInt();
                if (piecesToRemove < 1 || piecesToRemove > maxRemovable) {
                    System.out.println("Invalid choice. Try again.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        return piecesToRemove;
    }

    // Computer's random move
    private int getComputerMove() {
        int maxRemovable = Math.max(1, pileSize / 2);
        return random.nextInt(maxRemovable) + 1;
    }

    // Switch to the other player
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // Get the other player
    private Player getOtherPlayer() {
        return (currentPlayer == player1) ? player2 : player1;
    }
}
