package MenuSystem.Menues;

import GameSystem.Records.Historian;
import MenuSystem.Menu;
import MenuSystem.MenuLine;
import Utilities.Timer;


import java.util.List;

public class Statistics extends Menu {
    @Override
    public void run() {
        menuTitle = "Statistics menu";
        menuLines = List.of(
                new MenuLine(1, "View all past Games", () -> {
                    Historian.getAll().forEach(r -> System.out.println(r.toString()));
                    Timer.wait(5000);
                }),
                new MenuLine(2, "View last game", () -> {
                    System.out.println(Historian.getLast().toString());
                    Timer.wait(3000);
                }),
                new MenuLine(3, "View number of Wins", () -> {
                    System.out.println(Historian.totalPlayerWins());
                    System.out.println(Historian.totalWinPercentage() + "%");
                    Timer.wait(2000);
                }),new MenuLine(4, "View win/loss ratio", () -> {
                    System.out.println("Win / Loss\n"
                            + Historian.totalPlayerWins() +" / "+ Historian.totalPlayerLosses());
                    Timer.wait(2000);
                }),new MenuLine(5, "View win/loss ratio against Slumpis", () -> {
                    Historian.winLossAgainst("Slumpis");
                    Timer.wait(2000);
                }),new MenuLine(6, "View win/loss ratio against Namnis", () -> {
                    Historian.winLossAgainst("Namnis");
                    Timer.wait(2000);
                }),new MenuLine(7, "View win/loss ratio against Klockis", () -> {
                    Historian.winLossAgainst("Klockis");
                    Timer.wait(2000);
                }),
                new MenuLine(8, "Go back", () -> Menu.setState(new Landing())),
                new MenuLine(0, "Exit program", () -> System.exit(0))
        );
    }
}
