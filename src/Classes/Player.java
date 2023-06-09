package Classes;

import java.lang.Math;
import java.io.FileWriter;

abstract public class Player {

    int maxLife;
    int life;
    int str;
    int dex;
    int def;
    int exp;
    int lvl = 1;
    Weapon weapon;
    boolean alive = true;
    String profession;

    public Player() {
        exp = 0;
    }

    public int GetExp() {
        return exp;
    }

    public int GetLvl() {
        return lvl;
    }

    public boolean GetAlive() {
        return alive;
    }

    public void SetExp(int pd) {
        exp = pd;
    }

    abstract public int GetAttack();

    public void DispStats() {
        System.out.println("\nMaksymalne życie: " + maxLife);
        System.out.println("Życie: " + life);
        System.out.println("Siła: " + str);
        System.out.println("Dexterity: " + dex);
        System.out.println("Obrono: " + def);
        System.out.println("Poziom: " + lvl);
        System.out.println("Doświadczenie: " + exp);
        System.out.println(
                "Do następnego poziomu potrzebne ci będzie: " + ((int) Math.pow(this.lvl, 1.5) + 50 - this.exp)
                        + " doświadczenia");
    }

    abstract public void LvlUp();

    public void GetExp(int pd) {

        exp += pd;
        while (exp > (int) Math.pow(lvl, 1.5) + 50) {
            LvlUp();
            exp -= (int) Math.pow(lvl, 1.5) + 50;
        }
        System.out.println(
                "\nDo następnego poziomu potrzebne ci będzie: " + ((int) Math.pow(lvl, 1.5) +
                        50 - exp)
                        + " doświadczenia");
    }

    public void Healing() {
        while (life < maxLife) {

            System.out.println("Leczenie...");
            life += 5 + 3 * lvl;
            if (life > maxLife) {
                life = maxLife;
            }

        }
        alive = true;
        System.out.println("\nAktualnie masz: " + life + " zdrowia.");
    }

    public void TakeHit(int dmg) {
        if (dmg > def) {
            life += def - dmg;
        }
        if (life <= 0) {
            alive = false;
            life = 0;
        }
        System.out.println("\nAktualnie masz: " + life + " zdrowia.");
    }

    public void Zapisz() {
        try (FileWriter f = new FileWriter("Savefile.txt")) {
            f.write(profession);
            f.write("\n" + str);
            f.write("\n" + dex);
            f.write("\n" + def);
            f.write("\n" + maxLife);
            f.write("\n" + life);
            f.write("\n" + exp);
            f.write("\n" + lvl);

            f.write("\n" + weapon.ReturnStr());
            f.write("\n" + weapon.ReturnDex());

            System.out.println("\nUdało sie zapisać postać!\n");
        } catch (Exception e) {
            System.out.println("Błąd:" + e);
        }
    }
}
