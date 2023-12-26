package model;

import enums.PIECE_TYPE;

public abstract class Piece {
    PIECE_TYPE pieceType;

    Piece(PIECE_TYPE pieceType) {
        this.pieceType=pieceType;
    }
    public PIECE_TYPE getPieceType() {
        return pieceType;
    }
}
