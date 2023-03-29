package Classes;

abstract class Weapon {
    int str;
    int dex;

    abstract public int GetAttack();
}

class Bow extends Weapon {
    public Bow() {
        str = 0;
        dex = 10;
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

    public int GetAttack() {
        return str;
    }
}
