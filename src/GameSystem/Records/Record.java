package GameSystem.Records;


public class Record {
    private final String playerName;
    private final String enemyName;
    private final boolean playerWin;
    private final boolean enemyWin;

    public Record(String playerName, String enemyName, boolean playerWin, boolean enemyWin) {
        this.playerName = playerName;
        this.enemyName = enemyName;
        this.playerWin = playerWin;
        this.enemyWin = enemyWin;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }
    public boolean isEnemyWin() {
        return enemyWin;
    }

    public String getEnemyName() {
        return enemyName;
    }

    @Override
    public String toString() {
        if(playerWin) {
            return "Player: " + playerName + " | Opponent: " + enemyName + " ---- Win ----";
        }
         return "Player: " + playerName +" | Opponent: " + enemyName +" ---- Loss ----";
    }
}
