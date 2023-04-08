package Classes;

import java.util.Random;

abstract class Weapon {
    int str;
    int dex;
    char typ;

    abstract public int GetAttack();

    Random rand = new Random();

    public int ReturnStr() {
        return str;
    }

    public int ReturnDex() {
        return dex;
    }

}

class Bow extends Weapon {
    public Bow() {
        str = 0;
        dex = 10;
        typ = 'B';
    }

    public Bow(int[] stats) {
        str = stats[0];
        dex = stats[1];
        typ = 'B';

    }

    public Bow(int lvl, char r) {
        str = 0;
        typ = 'B';
        switch (r) {
            case 'C' -> dex = 10 + 2 * lvl + rand.nextInt(4);
            case 'R' -> dex = 10 + 3 * lvl + rand.nextInt(4);
            case 'L' -> dex = 10 + 5 * lvl + rand.nextInt(4);
            default -> dex = 10 + 2 * lvl;
        }
    }

    public int GetAttack() {
        return dex;
    }
}

class Sword extends Weapon {
    public Sword() {
        str = 10;
        dex = 0;
        typ = 'S';
    }

    public Sword(int[] stats) {
        str = stats[0];
        dex = stats[1];
        typ = 'S';
    }

    public Sword(int lvl, char r) {
        dex = 0;
        typ = 'S';
        switch (r) {
            case 'C' -> str = 10 + 2 * lvl + rand.nextInt(4);
            case 'R' -> str = 10 + 3 * lvl + rand.nextInt(4);
            case 'L' -> str = 10 + 5 * lvl + rand.nextInt(4);
            default -> str = 10 + 2 * lvl;
        }
    }

    public int GetAttack() {
        return str;
    }

}
