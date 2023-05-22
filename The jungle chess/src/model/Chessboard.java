package model;

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
    }

    private void initGrid() {//将该点用grid[][]表示出来
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j] = new Cell();
            }
        }
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

    private ChessPiece getChessPieceAt(ChessboardPoint point) {
        return getGridAt(point).getPiece();
    }//得到该点棋子类型

    private Cell getGridAt(ChessboardPoint point) {
        return grid[point.getRow()][point.getCol()];
    }//得到该点坐标

    private int calculateDistance(ChessboardPoint src, ChessboardPoint dest) {//计算距离，具体方法为横坐标差的绝对值加纵坐标差的绝对值 不大于1即可以移动
        return Math.abs(src.getRow() - dest.getRow()) + Math.abs(src.getCol() - dest.getCol());
    }

    private ChessPiece removeChessPiece(ChessboardPoint point) {//移走该点棋子，并得到该点棋子数据
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
        return calculateDistance(src, dest) == 1;
    }


    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        // TODO:Fix this method

        return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
    }
}
