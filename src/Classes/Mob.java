
package Classes;

public class Mob extends Player {
    public Mob(int lvl) {
        maxLife = 40 + 10 * lvl;
        life = 40 + 10 * lvl;
        def = 4 + 1 * lvl;
        str = 13 + 3 * lvl;
        dex = 10;
        this.lvl = lvl;
        weapon = new Sword();
    }

    @Override
    public int GetAttack() {
        return (str + weapon.GetAttack());
    }

    public void LvlUp() {
    };
}
