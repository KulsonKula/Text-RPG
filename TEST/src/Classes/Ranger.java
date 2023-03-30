package Classes;

public class Ranger extends Player {
    public Ranger() {
        life = 40;
        def = 3;
        str = 10;
        dex = 20;
        Weapon bow = new Bow();
        weapon = bow; // spytac sie czy to da sie zrobić lepiej XD!
    }

    @Override
    public int GetAttack() {
        return (dex + weapon.GetAttack());
    }
}