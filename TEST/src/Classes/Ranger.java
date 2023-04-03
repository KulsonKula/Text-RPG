package Classes;

public class Ranger extends Player {
    public Ranger() {
        maxLife = 40;
        life = 40;
        def = 3;
        str = 10;
        dex = 20;
        weapon = new Bow();
    }

    @Override
    public int GetAttack() {
        return (dex + weapon.GetAttack());
    }

    public void LvlUp() {
        lvl++;
        maxLife = maxLife + 7;
        life = maxLife;
        def = def + 1;
        str = str + 8;
    }
}