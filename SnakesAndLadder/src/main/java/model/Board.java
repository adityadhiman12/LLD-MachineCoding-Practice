package model;

import jdk.nashorn.internal.ir.JumpStatement;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int numOfSnakes, int noOfLadders) {
        initialiseCells(boardSize);
        addSnakeLadders(cells, numOfSnakes, noOfLadders);
    }

    private void initialiseCells(int boardSize) {
        cells= new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                Cell celObj=new Cell();
                cells[i][j]=celObj;
            }
        }
    }

    private void addSnakeLadders(Cell[][] cells, int numOfSnakes, int numOfLadders) {
        while(numOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            if(snakeTail >= snakeHead) {
                continue;
            }
            Jump snakeObj = new Jump();
            snakeObj.start=snakeHead;
            snakeObj.end=snakeTail;

            Cell cell = getCells(snakeHead);
            cell.jump = snakeObj;
            numOfSnakes--;
        }

        while(numOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }
            Jump ladderObj = new Jump();
            ladderObj.start=ladderStart;
            ladderObj.end=ladderEnd;

            Cell cell = getCells(ladderStart);
            cell.jump = ladderObj;
            numOfLadders--;
        }
    }

    Cell getCells(int playerPosition) {
        int boardRow = playerPosition/cells.length;
        int boardCol = playerPosition % cells.length;
        return cells[boardRow][boardCol];
    }
}
