package org.aditya;

import business.BowlingAlleyGame;
import business.StandardGame;
import dao.BowlingAlleyDao;
import dao.BowlingAlleyDaoImpl;
import model.Player;

public class Main {
    public static void main(String[] args) {
        BowlingAlleyDao bowlingAlleyDao = new BowlingAlleyDaoImpl(new StandardGame(3, 2, 10, 5, 2));
        bowlingAlleyDao.addPlayer(new Player("1", "Priyam"));
        bowlingAlleyDao.addPlayer(new Player("2", "Shoyeb"));
        bowlingAlleyDao.startGame();

    }
}