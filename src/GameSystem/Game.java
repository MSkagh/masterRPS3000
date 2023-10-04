package GameSystem;

import GameSystem.Enemies.Enemy;
import GameSystem.Enemies.Klockis;
import GameSystem.Enemies.Namnis;
import GameSystem.Enemies.Slumpis;
import GameSystem.Records.Historian;
import GameSystem.Records.Record;
import Utilities.Graphics;
import Utilities.InputParser;
import Utilities.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Enemy enemy = new Enemy();
    public static Player player = new Player();
    private static int winGoal;

    private static final List<Round> rounds = new ArrayList<>();


    //PUBLIC FUNCTIONS FOR ACCESS AND RESET
    public static void start() {
        Game.gamePreparations();
        Game.coreGameLoop();
        displayGameResult();
        displayGameHistory();
        Game.makeRecord();
        Game.resetGame();
    }
    public static void resetGame() {
        winGoal = 0;
        player.resetPlayerStats();
        enemy.resetEnemyStats();
    }


    //PRIVATE FUNCTIONS FOR INPUT FROM USER
    private static void setOpponent() {
        System.out.println("Choose opponent");
        System.out.println("1: Slumpis | 2: Klockis | 3: Namnis");
        switch (InputParser.getAnInt(scanner)) {
            case 1 -> enemy.setBehavior(new Slumpis());
            case 2 -> enemy.setBehavior(new Klockis());
            case 3 -> enemy.setBehavior(new Namnis());
        }
    }
    private static void setWinGoal(){
        System.out.println("How many wins do you want to play to?");
        winGoal = InputParser.getAnInt(scanner);
    }
    private static void prepareForNewRound() {
        player.setHand(null);
        enemy.setHand(null);
        rounds.clear();
    }


    //PRIVATE FUNCTIONS FOR RUNTIME
    private static void gamePreparations(){
        prepareForNewRound();
        Graphics.clearTerminal();
        setWinGoal();
        Graphics.clearTerminal();
        setOpponent();
        Graphics.clearTerminal();
    }
    private static void coreGameLoop() {
        while (!Game.player.isWinner() && !Game.enemy.isWinner()){

            displayCurrentPoints();

            Game.player.chooseHand(scanner);
            Game.enemy.chooseHand();
            displayHands();
            Round round = new Round(player.getHand(), enemy.getHand());
            storeRound(round);
            round.resolveRound();
            distributePoints(round);
            Graphics.clearTerminal();
            checkForWinner();
        }
    }



    //PRIVATE FUNCTIONS FOR LOGIC
    private static void checkForWinner(){
        if (player.getPointCounter() >= Game.winGoal) player.setWinner(true);
        if (enemy.getPointCounter() >= winGoal) enemy.setWinner(true);
    }
    private static void distributePoints(Round round){
        if (round.playerWon) player.addOnePoint();
        if (round.enemyWon) enemy.addOnePoint();
    }
    private static void storeRound(Round round){rounds.add(round);}

    private static void makeRecord(){
        Record record = new Record(player.getName(), enemy.getName(), player.isWinner(), enemy.isWinner());
        Historian.add(record);
    }

    //PRIVATE FUNCTIONS FOR DISPLAYING DATA
    private static void displayCurrentPoints(){
        System.out.println("****Current Score****\n" +
                "Player: " + player.getPointCounter() + "| Opponent: " + enemy.getPointCounter() + "| Goal: " + winGoal+ "\n");
    }
    private static void displayFinalPoints(){
        System.out.println("****Final Score****\n" +
                "Player: " + player.getPointCounter() + "| Opponent: " + enemy.getPointCounter());
    }
    private static void displayGameResult(){

        if (player.isWinner()) {
            System.out.println("Congratulations, you won the game!");
            Timer.wait(4000);
        }
        else {
            System.out.println("Good going but your opponent got out on top, you loose the game!");
            Timer.wait(4000);
        }
    }
    private static void displayHands(){
        System.out.println("You chose: " + player.getHand());
        Timer.wait(500);
        System.out.println("Your opponent chose: " + enemy.getHand());
        Timer.wait(500);
    }
    private static void displayGameHistory() {
        rounds.forEach(r -> {
            System.out.println(r.toString());
            Timer.wait(500);
        });
        displayFinalPoints();
        Timer.wait(2000);
        System.out.println("Returning to main menu");
        Timer.wait(3000);
    }
}
