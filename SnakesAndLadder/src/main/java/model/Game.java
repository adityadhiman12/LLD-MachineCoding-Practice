package model;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList=new LinkedList<>();
    Player winner;

    public Game() {
        initialiseGame();
    }

    private void initialiseGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1= new Player("p1", 0);
        Player player2= new Player("p2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void start() {
        while(winner == null) {
            Player currentPlayer = findPlayerTurn();
            System.out.println("Player turn is: " + currentPlayer.id + " current position: " + currentPlayer.currentPosition);
            int diceNumber= dice.rollDice();
            int playerNewPosition = currentPlayer.currentPosition + diceNumber;
            playerNewPosition=jumpCheck(playerNewPosition);
            currentPlayer.currentPosition = playerNewPosition;
            System.out.println("Player turn is: " + currentPlayer.id + " new Position is: " + playerNewPosition);
            if(playerNewPosition >= board.cells.length * board.cells.length - 1) {
                winner = currentPlayer;
            }
        }
        System.out.println("winner is: " + winner.id);
    }

    private Player findPlayerTurn() {
        Player playerTurn = playersList.removeFirst();
        playersList.addLast(playerTurn);
        return playerTurn;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length -1 ){
            return playerNewPosition;
        }
        Cell cell = board.getCells(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump done by: "+ jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
