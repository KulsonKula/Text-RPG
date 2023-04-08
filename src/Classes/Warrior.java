package Classes;

public class Warrior extends Player {
    public Warrior() {
        maxLife = 60;
        life = 60;
        def = 5;
        str = 12;
        dex = 10;
        exp = 0;
        profession = "W";
        weapon = new Sword();
    }

    public Warrior(int[] stats, int[] bron) {
        profession = "W";
        str = stats[0];
        dex = stats[1];
        def = stats[2];
        maxLife = stats[3];
        life = stats[4];
        exp = stats[5];
        lvl = stats[6];
        weapon = new Sword(bron);
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
        System.out.println("Awansujesz!");
        System.out.println("Aktualnie masz: " + lvl + ". poziom!");
    }
}
