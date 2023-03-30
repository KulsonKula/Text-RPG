import Classes.*;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {

        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Jaką klasą chcesz grać?");
            System.out.println("1: Ranger");
            System.out.println("2: Warrior");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    Player player = new Ranger();
                    break;
                case 2:
                    Player player = new Warrior();
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(player.GetAttack());
    }
}
