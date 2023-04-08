import Classes.*;

import java.util.Scanner;
import java.io.File;

public class Game {

    public static void main(String[] args) throws Exception {
        Player player = null;
        File f = null;
        boolean granie;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWitaj w Text RPG!");
        f = new File("Savefile.txt");
        while (true) {
            System.out.println("Co byś chciał zrobić?");
            System.out.println("1: Nowa gra.");
            System.out.println("2: Wczytaj postać.");
            System.out.println("3: Wyjdz.");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("\nJaką klasą chcesz grać?");
                    System.out.println("1: Warrior");
                    System.out.println("2: Ranger");
                    number = scanner.nextInt();
                    switch (number) {
                        case 1:
                            player = new Warrior();
                            break;
                        case 2:
                            player = new Ranger();
                            break;
                    }

                    f.createNewFile();
                    player.Zapisz();
                    break;
                case 2:
                    int[] data_g = {0, 0, 0, 0, 0, 0, 0};
                    int[] data_b = {0, 0};
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
                    scanner.close();
                    System.exit(0);
                    break;
            }
            granie = true;
            while (granie) {
                System.out.println("\nCo chciałbyś zrobić:");
                System.out.println("1: Zobacz statystki swojej postaci.");
                System.out.println("2: TEST.");
                System.out.println("3: Odpocznij.");
                System.out.println("4: Zapisz i wyjdź");
                scanner.nextLine();
                int tryb = scanner.nextInt();
                switch (tryb) {
                    case 1:
                        player.DispStats();
                        break;
                    case 2:
                        if (player.GetAlive()) {
                            player.TakeHit(30);
                        } else {
                            System.out.println("\nAby walczyć na arenie musisz sie podleczyć.");
                        }
                        break;
                    case 3:
                        player.Healing();
                        break;
                    case 4:
                        System.out.println("\nCo chciałbyś zrobić:");
                        System.out.println("1: Wyjdz do menu");
                        System.out.println("2: Wyjdz z programu");
                        scanner.nextLine();
                        tryb = scanner.nextInt();
                        player.Zapisz();
                        switch (tryb) {
                            case 1:
                                granie = false;
                                break;
                            case 2:
                                System.exit(0);
                                break;
                        }
                        break;
                }
            }
        }
    }
}