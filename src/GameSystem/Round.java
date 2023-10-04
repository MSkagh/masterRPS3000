package GameSystem;

import Utilities.Timer;

public class Round {
    Hand playerHand;
    Hand enemyHand;
    boolean playerWon;
    boolean enemyWon;
    public Round(Hand playerHand, Hand enemyHand) {
        this.playerHand = playerHand;
        this.enemyHand = enemyHand;
    }

    public void resolveRound() {

        if (playerHand.equals(enemyHand)) {
            System.out.println("Its a draw");
        }
        else if (playerHand.equals(Hand.Rock) && enemyHand.equals(Hand.Scissors) ||
                playerHand.equals(Hand.Paper) && enemyHand.equals(Hand.Rock) ||
                playerHand.equals(Hand.Scissors) && enemyHand.equals(Hand.Paper)) {
            System.out.println("You take the point");
            playerWon = true;
        }
        else {System.out.println("Point goes to your opponent");
            enemyWon = true;
        }
        Timer.wait(2000);
    }

    @Override
    public String toString() {
        if (playerWon) return "Player: " + playerHand + " | Opponent: " + enemyHand + "| Win";
        if (enemyWon) return "Player: "  + playerHand + " | Opponent: " + enemyHand + " | Loss";
        return "Player: " + playerHand + " | Opponent: " + enemyHand + " | Draw";
    }
}
