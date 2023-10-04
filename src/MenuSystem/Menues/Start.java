package MenuSystem.Menues;

import GameSystem.Game;
import MenuSystem.Menu;
import MenuSystem.MenuLine;

import java.util.List;


public class Start extends Menu {
    @Override
    public void run() {
        menuTitle =
                "+-------------------------------+\n" +
                "|***********  MASTER  **********|\n" +
                "|******** RPS SIMULATOR ********|\n" +
                "|************  3000  ***********|\n" +
                "+-------------------------------+";
        menuLines = List.of(
                new MenuLine(1, "Start", () -> {
                    setPlayerName();
                    Menu.setState(new Landing());
                }),
                new MenuLine(0, "Exit program", () -> System.exit(0))
        );
    }
    private static void setPlayerName(){
        System.out.println("Enter your name");
        Game.player.setName(scanner.next());
    }
}
