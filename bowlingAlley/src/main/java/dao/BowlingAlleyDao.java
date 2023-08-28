package dao;

import model.Player;

public interface BowlingAlleyDao {
    void addPlayer(Player player);
    int getTotalPlayers();
    void printScoreCard();

    void updateScoreCard();

    public void startGame() ;

}
