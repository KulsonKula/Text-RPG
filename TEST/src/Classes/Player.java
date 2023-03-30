package Classes;

abstract public class Player {
    int life;
    int str;
    int dex;
    int def;
    int exp;
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

    abstract public int GetAttack();
}
