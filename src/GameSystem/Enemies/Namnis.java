package GameSystem.Enemies;

import GameSystem.Game;
import GameSystem.Hand;

public class Namnis implements Behavior{

    @Override
    public Hand run() {
        Enemy.setName("Namnis");
        if (Game.player.getName().matches("\\w*\\d{1,}\\w*")){
            return Hand.Rock;
        }


        int choice = (int)(Math.floor(Math.random()*3) + 1);
        Hand hand = Hand.Rock;
        switch (choice) {
            case 1 -> hand = Hand.Rock;
            case 2 -> hand = Hand.Paper;
            case 3 -> hand = Hand.Scissors;
        }

        return hand;

    }
}
