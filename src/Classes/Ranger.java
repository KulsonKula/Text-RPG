package Classes;

public class Ranger extends Player {
    public Ranger() {
        maxLife = 40;
        life = 40;
        def = 3;
        str = 10;
        dex = 20;
        profesion = "R";
        weapon = new Bow();
    }

    public Ranger(int[] stats, int[] bron) {
        profesion = "R";
        str = stats[0];
        dex = stats[1];
        def = stats[2];
        maxLife = stats[3];
        life = stats[4];
        exp = stats[5];
        lvl = stats[6];
        weapon = new Bow(bron);
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
        System.out.println("Awansujesz!");
        System.out.println("Aktualnie masz: " + lvl + ". poziom!");
    }
}