package GameSystem.Enemies;
import GameSystem.Hand;

public class Slumpis implements Behavior{

    @Override
    public Hand run() {
        Enemy.setName("Slumpis");
        int choice = (int)(Math.floor(Math.random()*3) + 1);
        if (choice == 1) return Hand.Rock;
        if (choice == 2) return Hand.Paper;
        return Hand.Scissors;
    }
}
