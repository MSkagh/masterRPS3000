package MenuSystem;

public class MenuLine {
    private final int index;
    private final String text;
    private final Runnable action;

    public MenuLine(int index, String text, Runnable action) {
        this.index = index;
        this.text = text;
        this.action = action;
    }

    public int getIndex() {
        return index;
    }

    public void run(){
        action.run();
    }

    @Override
    public String toString() {
        return index + ": " + text;
    }
}
