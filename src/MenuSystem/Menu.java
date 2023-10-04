package MenuSystem;

import MenuSystem.Menues.Start;
import Utilities.Graphics;
import Utilities.InputParser;

import java.util.List;
import java.util.Scanner;

public abstract class Menu implements State{
    protected static final Scanner scanner = new Scanner(java.lang.System.in);
    protected static List<MenuLine> menuLines;
    protected static String menuTitle;
    private static State state = new Start();


    public static void setState(State state){
        Menu.state = state;
    }

    public static void start() {
        try {
            state.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Graphics.clearTerminal();
        show();
        int choice = InputParser.getAnInt(scanner);
            menuLines.forEach(menuLine -> {
                if (menuLine.getIndex() == choice) menuLine.run();
            });
    }
    public static void show(){
        System.out.println(menuTitle);
        menuLines.forEach(System.out::println);
    }
}
