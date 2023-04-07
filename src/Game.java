import Classes.*;
import java.util.Scanner;
import java.io.File;

public class Game {

    public static void main(String[] args) throws Exception {
        Player player = null;
        File f = null;

        f = new File("Postać.txt");
        System.out.println("Witaj w Text RPG!");
        System.out.println("Co byś chciał zrobić?");
        System.out.println("1: Nowa gra.");
        System.out.println("2: Wczytaj postać.");
        System.out.println("3: Wyjdz.");

        try (Scanner scanner = new Scanner(System.in);) {
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Jaką klasą chcesz grać?");
                    System.out.println("1: Ranger");
                    System.out.println("2: Warrior");
                    number = scanner.nextInt();
                    switch (number) {
                        case 1:
                            player = new Ranger();
                            break;
                        case 2:
                            player = new Warrior();
                            break;
                    }

                    f.createNewFile();
                    player.Zapisz();
                    break;
                case 2:
                    int[] data_g = { 0, 0, 0, 0, 0, 0, 0 };
                    int[] data_b = { 0, 0 };
                    Scanner myReader = new Scanner(f);
                    String profesion = myReader.nextLine();

                    for (int i = 0; i < 7; i++) {
                        data_g[i] = myReader.nextInt();
                    }

                    for (int i = 0; i < 2; i++) {
                        data_b[i] = myReader.nextInt();
                    }
                    if (profesion.equals("W")) {
                        player = new Warrior(data_g, data_b);
                    } else {
                        player = new Ranger(data_g, data_b);
                    }
                    myReader.close();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }

        catch (

        Exception e) {
            System.out.println("Bład:" + e);
        }
        player.DispStats();
    }
}
