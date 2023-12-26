package org.aditya;

import service.TicTacToeService;

public class Main {
    public static void main(String[] args) {
        TicTacToeService ticTacToeService = new TicTacToeService();
        ticTacToeService.initialiseGame(3);
        System.out.println("Game is won by: " + ticTacToeService.startGame());
    }
}