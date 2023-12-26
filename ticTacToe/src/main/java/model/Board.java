package model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private Piece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean addPiece(int row, int col, Piece piece) {
        if(board[row][col]==null) {
            board[row][col]=piece;
            return true;
        }
        return false;
    }

    public List<Pair<Integer, Integer>> findEmptyPlaces() {
        List<Pair<Integer, Integer>> emptyPlaces = new ArrayList<>();
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j]==null) {
                    emptyPlaces.add(new Pair<>(i, j));
                }
            }
        }
        return emptyPlaces;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j]!=null)
                    System.out.print(board[i][j].getPieceType().name());
                else
                    System.out.print(" ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
