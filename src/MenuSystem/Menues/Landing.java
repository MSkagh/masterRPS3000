package MenuSystem.Menues;

import GameSystem.Game;
import MenuSystem.MenuLine;
import MenuSystem.Menu;
import java.util.List;

public class Landing extends Menu{

    @Override
    public void run() {
        Game.resetGame();
        menuTitle = "Main menu";
        menuLines = List.of(
                new MenuLine(1, "Play a game", Game::start),
                new MenuLine(2, "View statistics", () -> Menu.setState(new Statistics())),
                new MenuLine(0, "Exit program", () -> System.exit(0))
        );
    }
}