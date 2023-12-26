package service;

import enums.PIECE_TYPE;
import javafx.util.Pair;
import model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeService {
    private Board board;
    private Deque<Player>players;

    public TicTacToeService() {
    }


    public void initialiseGame(int size) {
        this.players= new LinkedList<>();
        PieceO pieceO = new PieceO(PIECE_TYPE.O);
        PieceX pieceX = new PieceX(PIECE_TYPE.X);
        Player player1 = new Player("atts", pieceO);
        Player player2 = new Player("nawus", pieceX);
        players.add(player1);
        players.add(player2);
        board = new Board(size);
    }

    public boolean isWinner(int row, int column, PIECE_TYPE pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.getSize();i++) {

            if(board.getBoard()[row][i] == null || board.getBoard()[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.getSize();i++) {

            if(board.getBoard()[i][column] == null || board.getBoard()[i][column].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.getSize();i++,j++) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.getSize()-1; i<board.getSize();i++,j--) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            List<Pair<Integer, Integer>> emptyPlaces = board.findEmptyPlaces();
            if(emptyPlaces.isEmpty()) {
                noWinner = false;
                continue;
            }
            //read user input
            System.out.print(currentPlayer.getPlayerName() + " enter the position: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] values = input.split(",");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);

            //add piece
            boolean pieceAddedSuccessfully = board.addPiece(x, y, currentPlayer.getPiece());
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position, please choose new coordinates");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean isCurrentPlayerWinner = isWinner(x, y, currentPlayer.getPiece().getPieceType());
            if(isCurrentPlayerWinner) {
                return (currentPlayer.getPlayerName());
            }
        }
        return "tie";
    }
}
