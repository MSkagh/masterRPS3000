package GameSystem.Records;

import java.util.*;

public abstract class Historian {
    private static final List<Record> records = new ArrayList<>();

    public static void add(Record record){
       records.add(record);
    }

    public static Record getLast(){
        int lastIndex = records.size() -1;
        return records.get(lastIndex);
    }
    public static List<Record> getAll(){
        return records;
    }
    public static int totalPlayerWins(){
        List<Record> wins = records.stream()
            .filter(Record::isPlayerWin)
                .toList();
    return wins.size();
    }
    public static int totalPlayerLosses(){
        List<Record> losses = records.stream()
                .filter(Record::isEnemyWin)
                .toList();
        return losses.size();
    }
    public static int totalWinPercentage(){
        int totalGames = records.size();
        int totalWins = totalPlayerWins();
        return totalWins * 100 / totalGames ;
    }
    public static void winLossAgainst(String enemyName){
        List<Record> gamesAgainstEnemy = records.stream()
                .filter(record -> record.getEnemyName().equals(enemyName))
                .toList();
        List<Record> gamesWon = gamesAgainstEnemy.stream()
                .filter(Record::isPlayerWin)
                .toList();
        System.out.println("Wins against " + enemyName + ": " + gamesWon.size()) ;
        System.out.println("Losses against " + enemyName +": " + (gamesAgainstEnemy.size()-gamesWon.size()));
    }
}
