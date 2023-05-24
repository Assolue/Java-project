package model;

import java.io.Serializable;
/**
 * This class describe the slot for Chess in Chessboard
 * */
public class Cell implements Serializable {
    // the position for chess
    private ChessPiece piece;
    private RiverPiece riverPiece;
    private BlueTrapPiece blueTrapPiece;
    private RedTrapPiece redTrapPiece;
    private BlueHomePiece blueHomePiece;
    private RedHomePiece redHomePiece;
    public ChessPiece getPiece() {
        return piece;
    }
    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }

    public RiverPiece getRiverPiece() {
        return riverPiece;
    }

    public void setRiverPiece(RiverPiece riverPiece) {
        this.riverPiece = riverPiece;
    }

    public BlueTrapPiece getBlueTrapPiece() {
        return blueTrapPiece;
    }

    public void setBlueTrapPiece(BlueTrapPiece blueTrapPiece) {
        this.blueTrapPiece = blueTrapPiece;
    }

    public RedTrapPiece getRedTrapPiece() {
        return redTrapPiece;
    }

    public void setRedTrapPiece(RedTrapPiece redTrapPiece) {
        this.redTrapPiece = redTrapPiece;
    }

    public BlueHomePiece getBlueHomePiece() {
        return blueHomePiece;
    }

    public void setBlueHomePiece(BlueHomePiece blueHomePiece) {
        this.blueHomePiece = blueHomePiece;
    }

    public RedHomePiece getRedHomePiece() {
        return redHomePiece;
    }

    public void setRedHomePiece(RedHomePiece redHomePiece) {
        this.redHomePiece = redHomePiece;
    }
}
