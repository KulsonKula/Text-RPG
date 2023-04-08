import Classes.*;

import java.util.Scanner;
import java.io.File;

public class Game {

    public static void main(String[] args) throws Exception {
        Player player = null;
        File f = null;
        boolean granie = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWitaj w Text RPG!");
        f = new File("Savefile.txt");
        while (true) {
            System.out.println("Co byś chciał zrobić?");
            System.out.println("1: Nowa gra.");
            System.out.println("2: Wczytaj postać.");
            System.out.println("3: Wyjdź.");

            int number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println("\nJaką klasą chcesz grać?");
                    System.out.println("1: Warrior");
                    System.out.println("2: Ranger");
                    number = scanner.nextInt();
                    switch (number) {
                        case 1 -> player = new Warrior();
                        case 2 -> player = new Ranger();
                        default -> System.out.println("Podaj odpowiednią wartość");
                    }
                    if (player != null) {
                        player.Zapisz();
                        granie = true;
                    }
                }
                case 2 -> {
                    int[] data_g = {0, 0, 0, 0, 0, 0, 0};
                    int[] data_b = {0, 0};
                    Scanner myReader = new Scanner(f);
                    String profession = myReader.nextLine();
                    for (int i = 0; i < 7; i++) {
                        data_g[i] = myReader.nextInt();
                    }
                    for (int i = 0; i < 2; i++) {
                        data_b[i] = myReader.nextInt();
                    }
                    if (profession.equals("W")) {
                        player = new Warrior(data_g, data_b);
                    } else {
                        player = new Ranger(data_g, data_b);
                    }
                    myReader.close();
                    granie = true;
                }
                case 3 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Podaj odpowiednią wartość");
                    granie = false;
                }
            }

            while (granie) {
                System.out.println("\nCo chciałbyś zrobić:");
                System.out.println("1: Zobacz statystki swojej postaci.");
                System.out.println("2: Walcz z losowym przeciwnikiem.");
                System.out.println("3: Odpocznij.");
                System.out.println("4: Zapisz i wyjdź");
                scanner.nextLine();
                int tryb = scanner.nextInt();
                switch (tryb) {
                    case 1 -> player.DispStats();
                    case 2 -> {
                        if (player.GetAlive()) {
                            Mob mob = new Mob(player.GetLvl());
                            System.out.println("\nStatystyki twojego przeciwnika:");
                            mob.DispStats();
                            while (mob.GetAlive() && player.GetAlive()) {
                                mob.TakeHit(player.GetAttack());
                                if (mob.GetAlive()) {
                                    player.TakeHit(mob.GetAttack());
                                }
                            }
                            if (player.GetAlive()) {
                                System.out.println("Wygrałeś!");
                                System.out.println("Zdobywasz: " + mob.GetExp() + " doświadczenia!");
                                player.GetExp(mob.GetExp());
                            } else {
                                System.out.println("Niestety przegrałeś :(");
                                System.out.println("Tracisz całe swoje zdobyte doświadczenie");
                                player.SetExp(0);
                            }
                        } else {
                            System.out.println("\nAby walczyć na arenie musisz sie podleczyć.");
                        }
                    }
                    case 3 -> player.Healing();
                    case 4 -> {
                        System.out.println("\nCo chciałbyś zrobić:");
                        System.out.println("1: Wyjdź do menu");
                        System.out.println("2: Wyjdź z programu");
                        scanner.nextLine();
                        tryb = scanner.nextInt();
                        player.Zapisz();
                        switch (tryb) {
                            case 1 -> granie = false;
                            case 2 -> System.exit(0);
                        }
                    }
                    default -> System.out.println("Podaj odpowiednią wartość");
                }
            }
        }
    }
}