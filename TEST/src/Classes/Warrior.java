package Classes;

public class Warrior extends Player {
    public Warrior() {
        life = 60;
        def = 5;
        str = 18;
        dex = 10;
        Weapon sword = new Sword();
        weapon = sword;
    }

    @Override
    public int GetAttack() {
        return (str + weapon.GetAttack());
    }
}
