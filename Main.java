
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player 1 name (X): ");
        String name1 = sc.nextLine();

        System.out.print("Enter Player 2 name (O): ");
        String name2 = sc.nextLine();

        if (name1.trim().isEmpty()) {
            name1 = "Player 1";
        }

        if (name2.trim().isEmpty()) {
            name2 = "Player 2";
        }

        Player p1 = new Player(name1, 'X');
        Player p2 = new Player(name2, 'O');

        Game game = new Game(sc, p1, p2);
        game.start();

        sc.close();
    }
}
