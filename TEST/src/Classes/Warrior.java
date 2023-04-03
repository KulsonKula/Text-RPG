package Classes;

public class Warrior extends Player {
    public Warrior() {
        maxLife = 60;
        life = 60;
        def = 5;
        str = 12;
        dex = 10;
        weapon = new Sword();
    }

    @Override
    public int GetAttack() {
        return (str + weapon.GetAttack());
    }

    public void LvlUp() {
        lvl++;
        maxLife = maxLife + 10;
        life = maxLife;
        def = def + 2;
        str = str + 4;
    }
}
