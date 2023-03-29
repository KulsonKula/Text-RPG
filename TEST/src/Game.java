import Classes.*;

public class Game {
    public static void main(String[] args) throws Exception {
        Player player = new Warrior();
        System.out.println(player.GetLife());
    }
}
