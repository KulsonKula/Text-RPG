package Classes;

abstract public class Player {
    int life;
    int str;
    int dex;
    int def;
    int exp;
    String profession;
    Weapon weapon;

    public Player() {
        exp = 0;
    }

    public int GetLife() {
        return life;
    }

    public int GetDef() {
        return def;
    }

    public int GetExp() {
        return exp;
    }

    public int GetDex() {
        return dex;
    }

    public int GetStr() {
        return str;
    }

    abstract int GetAttack();
}

class Ranger extends Player {
    public Ranger() {
        life = 40;
        def = 3;
        str = 10;
        dex = 20;
        Weapon bow = new Bow();
        weapon = bow; // spytac sie czy to da sie zrobić lepiej XD!
    }

    public int GetAttack() {
        return (dex + weapon.GetAttack());
    }
}

class Warrior extends Player {
    public Warrior() {
        life = 60;
        def = 5;
        str = 20;
        dex = 10;
        Weapon sword = new Sword();
        weapon = sword;
    }

    public int GetAttack() {
        return (str + weapon.GetAttack());
    }
}
