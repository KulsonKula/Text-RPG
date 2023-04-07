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
    String profesion;

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

    public void DispStats() {
        System.out.println("Życie: " + life);
        System.out.println("Maksymalne życie: " + maxLife);
        System.out.println("Siła: " + str);
        System.out.println("Dexterity: " + dex);
        System.out.println("Obrono: " + def);
        System.out.println("Poziom: " + lvl);
        System.out.println("Doświadczenie: " + exp);
        System.out.println(
                "Do nastepnego poziomu potrzebne ci będzie: " + ((int) Math.pow(this.lvl, 1.5) + 50 - this.exp)
                        + " doświadczenia");
    }

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
        try (FileWriter f = new FileWriter("Savefile.txt");) {
            f.write(profesion);
            f.write("\n" + str);
            f.write("\n" + dex);
            f.write("\n" + def);
            f.write("\n" + maxLife);
            f.write("\n" + life);
            f.write("\n" + exp);
            f.write("\n" + lvl);

            f.write("\n" + weapon.ReturnStr());
            f.write("\n" + weapon.ReturnDex());

            System.out.println("Udało sie zapisać postać!");
        } catch (Exception e) {
            System.out.println("Bład:" + e);
        }
    }
}
