
package Classes;

public class Mob extends Player {
    public Mob(int lvl) {
        maxLife = 40 + 10 * lvl;
        life = 40 + 10 * lvl;
        def = 4 + lvl;
        str = 11 + 3 * lvl;
        dex = 10;
        exp = 25 + 10 * lvl;
        this.lvl = lvl;
        weapon = new Sword();
    }

    @Override
    public int GetAttack() {
        return (str + weapon.GetAttack());
    }

    public void DispStats() {
        System.out.println("Życie: " + life);
        System.out.println("Siła: " + str);
        System.out.println("Obrono: " + def);
        System.out.println("Poziom: " + lvl);
    }

    @Override
    public void TakeHit(int dmg) {
        if (dmg > def) {
            life += def - dmg;
        }
        if (life <= 0) {
            alive = false;
            life = 0;
        }
        System.out.println("\nPrzeciwnik ma: " + life + " zdrowia.");
    }

    public void LvlUp() {
    }
    
}
