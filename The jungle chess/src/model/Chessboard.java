package model;

import javax.swing.*;
import java.awt.*;

/**
 * This class store the real chess information.
 * The Chessboard has 9*7 cells, and each cell has a position for chess
 */
public class Chessboard {
    private Cell[][] grid;
    public Chessboard() {
        this.grid = new Cell[Constant.CHESSBOARD_ROW_SIZE.getNum()][Constant.CHESSBOARD_COL_SIZE.getNum()];//19X19
        initGrid();
        initPieces();
        initRivers();
        initBlueTrapPiece();
        initRedTrapPiece();
        initBlueHomePiece();
        initRedHomePiece();
    }

    private void initGrid() {//将该点用grid[][]表示出来
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void initRivers(){//放置河单元格
        grid[3][1].setRiverPiece(new RiverPiece());
        grid[3][2].setRiverPiece(new RiverPiece());
        grid[4][1].setRiverPiece(new RiverPiece());
        grid[4][2].setRiverPiece(new RiverPiece());
        grid[5][1].setRiverPiece(new RiverPiece());
        grid[5][2].setRiverPiece(new RiverPiece());
        grid[3][4].setRiverPiece(new RiverPiece());
        grid[3][5].setRiverPiece(new RiverPiece());
        grid[4][4].setRiverPiece(new RiverPiece());
        grid[4][5].setRiverPiece(new RiverPiece());
        grid[5][4].setRiverPiece(new RiverPiece());
        grid[5][5].setRiverPiece(new RiverPiece());
    }

    private void initBlueTrapPiece(){//放置蓝色陷阱格
        grid[0][2].setBlueTrapPiece(new BlueTrapPiece());
        grid[0][4].setBlueTrapPiece(new BlueTrapPiece());
        grid[1][3].setBlueTrapPiece(new BlueTrapPiece());
    }
    private void initRedTrapPiece(){//放置红色陷阱格
        grid[8][2].setRedTrapPiece(new RedTrapPiece());
        grid[8][4].setRedTrapPiece(new RedTrapPiece());
        grid[7][3].setRedTrapPiece(new RedTrapPiece());
    }

    private void initBlueHomePiece(){//放置蓝色基地
        grid[0][3].setBlueHomePiece(new BlueHomePiece());
    }

    private void initRedHomePiece(){//放置红色基地
        grid[8][3].setRedHomePiece(new RedHomePiece());
    }

    private void initPieces() {//放置棋子
        grid[0][0].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Lion));
        grid[8][6].setPiece(new ChessPiece(PlayerColor.RED, Chess.Lion));
        grid[0][6].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Tiger));
        grid[8][0].setPiece(new ChessPiece(PlayerColor.RED, Chess.Tiger));
        grid[1][1].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Dog));
        grid[7][5].setPiece(new ChessPiece(PlayerColor.RED, Chess.Dog));
        grid[1][5].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Cat));
        grid[7][1].setPiece(new ChessPiece(PlayerColor.RED, Chess.Cat));
        grid[2][0].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Mouse));
        grid[6][6].setPiece(new ChessPiece(PlayerColor.RED, Chess.Mouse));
        grid[2][2].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Leopard));
        grid[6][4].setPiece(new ChessPiece(PlayerColor.RED, Chess.Leopard));
        grid[2][4].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Wolf));
        grid[6][2].setPiece(new ChessPiece(PlayerColor.RED, Chess.Wolf));
        grid[2][6].setPiece(new ChessPiece(PlayerColor.BLUE, Chess.Elephant));
        grid[6][0].setPiece(new ChessPiece(PlayerColor.RED, Chess.Elephant));

    }

    public ChessPiece getChessPieceAt(ChessboardPoint point) {
        return getGridAt(point).getPiece();
    }//得到该点棋子类型

    private Cell getGridAt(ChessboardPoint point) {
        return grid[point.getRow()][point.getCol()];
    }//得到该点坐标

    private int calculateDistance(ChessboardPoint src, ChessboardPoint dest) {//计算距离，具体方法为横坐标差的绝对值加纵坐标差的绝对值 不大于1即可以移动
        return Math.abs(src.getRow() - dest.getRow()) + Math.abs(src.getCol() - dest.getCol());
    }

    private boolean rowCrossRiver(ChessboardPoint a,ChessboardPoint d){//是否是横渡河
        int x = a.getCol() - d.getCol();
        if(a.getRow() == d.getRow()){
            if(x == 3){
                ChessboardPoint b = new ChessboardPoint(a.getRow(),a.getCol() - 1);
                ChessboardPoint c = new ChessboardPoint(a.getRow(),a.getCol() - 2);
                if(getChessPieceAt(b) != null || getChessPieceAt(c) != null){return false;}
                return (isRiver(b) && isRiver(c) && (getChessPieceAt(a).getName() == Chess.Tiger || getChessPieceAt(a).getName() == Chess.Lion));
            }
            if(x == -3){
                ChessboardPoint b = new ChessboardPoint(a.getRow(),a.getCol() + 1);
                ChessboardPoint c = new ChessboardPoint(a.getRow(),a.getCol() + 2);
                if(getChessPieceAt(b) != null || getChessPieceAt(c) != null){return false;}
                return (isRiver(b) && isRiver(c) && (getChessPieceAt(a).getName() == Chess.Tiger || getChessPieceAt(a).getName() == Chess.Lion));
            }
        }
        return false;
    }

    private boolean columnCrossRiver(ChessboardPoint a,ChessboardPoint e){//是否是纵渡河
        int x = a.getRow() - e.getRow();
        if(a.getCol() == e.getCol()){
            if(x == 4){
                ChessboardPoint b = new ChessboardPoint(a.getRow() - 1,a.getCol());
                ChessboardPoint c = new ChessboardPoint(a.getRow() - 2,a.getCol());
                ChessboardPoint d = new ChessboardPoint(a.getRow() - 3,a.getCol());
                if(getChessPieceAt(b) != null || getChessPieceAt(c) != null || getChessPieceAt(d) != null){return false;}
                return (isRiver(b) && isRiver(c) && isRiver(d) && (getChessPieceAt(a).getName() == Chess.Tiger || getChessPieceAt(a).getName() == Chess.Lion));
            }
            if(x == -4){
                ChessboardPoint b = new ChessboardPoint(a.getRow() + 1,a.getCol());
                ChessboardPoint c = new ChessboardPoint(a.getRow() + 2,a.getCol());
                ChessboardPoint d = new ChessboardPoint(a.getRow() + 3,a.getCol());
                if(getChessPieceAt(b) != null || getChessPieceAt(c) != null || getChessPieceAt(d) != null){return false;}
                return (isRiver(b) && isRiver(c) && isRiver(d) && (getChessPieceAt(a).getName() == Chess.Tiger || getChessPieceAt(a).getName() == Chess.Lion));
            }
        }
        return false;
    }

    public ChessPiece removeChessPiece(ChessboardPoint point) {//移走该点棋子，并得到该点棋子数据
        ChessPiece chessPiece = getChessPieceAt(point);
        getGridAt(point).removePiece();
        return chessPiece;
    }

    private void setChessPiece(ChessboardPoint point, ChessPiece chessPiece) {//在该点放置指定棋子
        getGridAt(point).setPiece(chessPiece);
    }

    public void moveChessPiece(ChessboardPoint src, ChessboardPoint dest) {//棋子由src点移到dest点
        if (!isValidMove(src, dest)) {//不能移动那么打出下面这行字
            throw new IllegalArgumentException("Illegal chess move!");
        }//true那么把src棋子移到dest
        else setChessPiece(dest, removeChessPiece(src));//是不是少了else 这是我自己加的
    }

    public void captureChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isValidCapture(src, dest)) {//不能捕获那么打出下面这字  ！我自己加的也是
            throw new IllegalArgumentException("Illegal chess capture!");
        }else getGridAt(dest).setPiece(null);
            moveChessPiece(src,dest);//检查是否可以捕获，然后检查是否可以移动那么就将src棋子移到dest
        // TODO: Finish the method.

    }

    public Cell[][] getGrid() {
        return grid;
    }
    public PlayerColor getChessPieceOwner(ChessboardPoint point) {
        return getGridAt(point).getPiece().getOwner();
    }

    public boolean isValidMove(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        if (isRiver(dest)){
            if(getChessPieceAt(src).getName().equals(Chess.Mouse)){
                return true;
            }else{
                return false;
            }
        }
        if(rowCrossRiver(src,dest)){
            return true;
        }
        if(columnCrossRiver(src,dest)){
            return true;
        }
        return calculateDistance(src, dest) == 1;
    }


    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        // TODO:Fix this method
        if(getChessPieceAt(src).getOwner() == PlayerColor.BLUE && getChessPieceAt(dest).getOwner() == PlayerColor.RED && isBlueTrap(dest) && calculateDistance(src, dest) == 1){return true;}
        if(getChessPieceAt(src).getOwner() == PlayerColor.RED && getChessPieceAt(dest).getOwner() == PlayerColor.BLUE && isRedTrap(dest) && calculateDistance(src, dest) == 1){return true;}
        return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
    }

    public boolean isRiver(ChessboardPoint point){//判断此单元格是否为河
        if((point.getRow() == 3 || point.getRow() == 4 || point.getRow() == 5)&&(point.getCol() == 1 || point.getCol() == 2 || point.getCol() == 4 || point.getCol() == 5)){
            return true;
        }
        return false;
    }

    public boolean isBlueTrap(ChessboardPoint point){//判断此单元格是否为蓝色陷阱
        if((point.getRow() == 0 && point.getCol() == 2)||(point.getRow() == 0 && point.getCol() == 4)||(point.getRow() == 1 && point.getCol() == 3)){
            return true;
        }
        return false;
    }

    public boolean isRedTrap(ChessboardPoint point){//判断此单元格是否为红色陷阱
        if((point.getRow() == 8 && point.getCol() == 2)||(point.getRow() == 8 && point.getCol() == 4)||(point.getRow() == 7 && point.getCol() == 3)){
            return true;
        }
        return false;
    }

    public boolean isRedHome(ChessboardPoint point){//判断此单元格是否为蓝色基地
        if(point.getRow() == 0 && point.getCol() == 3){
            return true;
        }
        return false;
    }

    public boolean isBlueHome(ChessboardPoint point){//判断此单元格是否为红色基地
        if(point.getRow() == 8 && point.getCol() == 3){
            return true;
        }
        return false;
    }
}
