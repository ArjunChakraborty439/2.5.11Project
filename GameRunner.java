import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();

        // Create Player objects
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        // Start a new game
        Game game = new Game(player1, player2);
        game.playGame();
    }
}
