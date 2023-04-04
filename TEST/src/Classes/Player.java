package Classes;

import java.lang.Math;
import java.io.FileWriter;

abstract public class Player {

    int maxLife;
    int life;
    int str;
    int dex;
    int def;
    int exp = 0;
    int lvl = 1;
    Weapon weapon;
    int alive = 1;
    char profesion;

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

    abstract public void LvlUp();

    public void GetExp(int exp) {
        if (this.exp + exp > (int) Math.pow(this.lvl, 1.5) + 50) {
            LvlUp();
            this.exp = this.exp + exp - (int) Math.pow(this.lvl, 1.5) + 50;
        } else {
            this.exp = this.exp + exp;
        }
    }

    public void TakeHit(int dmg) {
        life = life - dmg;
        if (life <= 0) {
            alive = 0;
            life = 0;
        }
    }

    public void Zapisz() {
        try (FileWriter f = new FileWriter("Postać.txt");) {
            f.write("Profesion: " + profesion);
            f.write("\nStr: " + str);
            f.write("\nDex: " + dex);
            f.write("\nDef: " + def);
            f.write("\nMaxlife: " + maxLife);
            f.write("\nLife: " + life);
            f.write("\nExp: " + exp);
            f.write("\nLvl: " + lvl);

            f.write("\n\nTyp: " + weapon.ReturnTyp());
            f.write("\nStr: " + weapon.ReturnStr());
            f.write("\nDex: " + weapon.ReturnDex());

            System.out.println("Udało sie zapisać postać!");
        } catch (Exception e) {
            System.out.println("Bład:" + e);
        }
    }
}
