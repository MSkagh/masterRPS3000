package GameSystem;

import Utilities.InputParser;

import java.util.Scanner;

public class Player {
   private String name;
   private Hand hand;
   private int pointCounter;
   private boolean winner;

   public void setName(String name) {
      this.name = name;
   }

   public String getName(){return name;}

   public void setHand(Hand hand) {
      this.hand = hand;
   }

   public Hand getHand() {
      return hand;
   }

   public void setPointCounter(int pointCounter) {
      this.pointCounter = pointCounter;
   }
   public void addOnePoint(){
      this.pointCounter++;
   }

   public int getPointCounter() {
      return pointCounter;
   }

   public void setWinner(boolean winner) {
      this.winner = winner;
   }

   public boolean isWinner() {
      return winner;
   }

   public void resetPlayerStats() {
      setWinner(false);
      setPointCounter(0);
   }

   public void chooseHand(Scanner scanner){
      System.out.println("Choose hand to play");
      System.out.println("1: Rock | 2: Paper | 3: Scissors");
      switch (InputParser.getAnInt(scanner)) {
         case 1 -> this.setHand(Hand.Rock);
         case 2 -> this.setHand(Hand.Paper);
         case 3 -> this.setHand(Hand.Scissors);
         default -> chooseHand(scanner);
      }

   }
}
