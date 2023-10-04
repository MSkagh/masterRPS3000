package GameSystem.Enemies;

import GameSystem.Hand;
import java.time.LocalTime;

public class Klockis implements Behavior{


    @Override
    public GameSystem.Hand run() {
        Enemy.setName("Klockis");
        int currentSecond = LocalTime.now().getSecond();
        int choice = (int)(Math.floor(Math.random()*3) + 1);

        if (currentSecond % 2 == 0){
            switch (choice) {
                case 1, 2 -> {
                    return Hand.Rock;
                }
                case 3 -> {
                    return Hand.Scissors;
                }
        }}
        else {
            switch (choice) {
                case 1, 2 -> {
                    return Hand.Paper;
                }
                case 3 -> {
                    return Hand.Scissors;
                }
            }}
        //This return is only here to placate the devilish compiler. By logic this point will never be reached.
        return Hand.Paper;


    }
}
