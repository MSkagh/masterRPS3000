package GameSystem.Enemies;

import GameSystem.Hand;

public class Enemy {
    private static String name;
    private Behavior behavior;
    private Hand hand;
    private boolean winner;
    private int pointCounter;

    public static void setName(String name){
        Enemy.name = name;
    }
    public String getName(){
        return name;
    }
    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getPointCounter() {
        return pointCounter;
    }
    public void addOnePoint(){
        this.pointCounter++;
    }

    public Hand getHand() {
        return hand;
    }

    public void setPointCounter(int pointCounter) {
        this.pointCounter = pointCounter;
    }

    public void setBehavior(Behavior behavior){
        this.behavior = behavior;
    }

    public void run(){
        behavior.run();
    }

    public void resetEnemyStats() {
        setWinner(false);
        setPointCounter(0);
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public void chooseHand() {
        this.hand = behavior.run();
    }
}
