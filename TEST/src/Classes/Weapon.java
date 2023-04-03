package Classes;

import java.util.Random;

abstract class Weapon {
    int str;
    int dex;

    abstract public int GetAttack();

    Random rand = new Random();
}

class Bow extends Weapon {
    public Bow() {
        str = 0;
        dex = 10;
    }

    public Bow(int lvl, char r) {
        str = 0;

        switch (r) {
            case 'C':
                dex = 10 + 2 * r + rand.nextInt(4);
                break;
            case 'R':
                dex = 10 + 3 * r + rand.nextInt(4);
                break;
            case 'L':
                dex = 10 + 5 * r + rand.nextInt(4);
                break;
            default:
                dex = 10 + 2 * r;
                break;
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
    }

    public Sword(int lvl, char r) {
        dex = 0;
        switch (r) {
            case 'C':
                str = 10 + 2 * r + rand.nextInt(4);
                break;
            case 'R':
                str = 10 + 3 * r + rand.nextInt(4);
                break;
            case 'L':
                str = 10 + 5 * r + rand.nextInt(4);
                break;
            default:
                str = 10 + 2 * r;
                break;
        }
    }

    public int GetAttack() {
        return str;
    }

}
