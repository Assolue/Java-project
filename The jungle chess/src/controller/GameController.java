package controller;


import listener.GameListener;
import model.*;
import saveandload.*;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Controller is the connection between model and view,
 * when a Controller receive a request from a view, the Controller
 * analyzes and then hands over to the model for processing
 * [in this demo the request methods are onPlayerClickCell() and onPlayerClickChessPiece()]
 *
 */
public class GameController implements GameListener {


    private Chessboard model;
    private ChessboardComponent view;
    private PlayerColor currentPlayer;

    // Record whether there is a selected piece before
    private ChessboardPoint selectedPoint;
    public Vector<Node> nodes = new Vector<>(); //此nodes记录存档的数据，用于恢复存档


    public Set<ChessboardPoint> getCanMoveCell() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint point=new ChessboardPoint(i,j);
                if (model.isValidMove(selectedPoint,point)){
                    view.canMoveCell.add(new ChessboardPoint(i,j));
                    }
                }
            }view.setCanMoveCell();
        return null;
    }



    public GameController(ChessboardComponent view, Chessboard model) {
        this.view = view;
        this.model = model;
        this.currentPlayer = PlayerColor.BLUE;
        view.registerController(this);
        initialize();
        view.initiateChessComponent(model);
        view.repaint();
        Recorder.setNow(model);
        nodes = Recorder.loadGame();
    }

    private void initialize() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {

            }
        }
    }

    // after a valid move swap the player
    private void swapColor() {
        currentPlayer = currentPlayer == PlayerColor.BLUE ? PlayerColor.RED : PlayerColor.BLUE;
        Recorder.setRecordPlayer(currentPlayer);
    }

    private boolean redWin() {
        ChessboardPoint blueHome = new ChessboardPoint(0,3);
        if(model.getChessPieceAt(blueHome) != null){
            if(model.getChessPieceAt(blueHome).getOwner() == PlayerColor.RED){
                return true;
            }
        }
        return false;
    }

    private boolean blueWin() {
        ChessboardPoint redHome = new ChessboardPoint(8,3);
        if(model.getChessPieceAt(redHome) != null){
            if(model.getChessPieceAt(redHome).getOwner() == PlayerColor.BLUE){
                return true;
            }
        }
        return false;
    }


    public void whenRedWin(){

            if (redWin()){
                JOptionPane.showMessageDialog(button, "RED Win!!!");
            }
        }

    JButton button = new JButton("对战模式");
    public void whenBlueWin(){
            if (blueWin()){
                JOptionPane.showMessageDialog(button, "Blue Win!!!");
            }
        }


    // click an empty cell
    @Override
    public void onPlayerClickCell(ChessboardPoint point, CellComponent component) {
        if (selectedPoint != null && model.isValidMove(selectedPoint, point)) {
            model.moveChessPiece(selectedPoint, point);
            view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            selectedPoint = null;
            swapColor();
            view.repaint();
            // TODO: if the chess enter Dens or Traps and so on

        }
    }

    // click a cell with a chess
    @Override
    public void onPlayerClickChessPiece(ChessboardPoint point, ChessSpeciesComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {       //if->这里是指还未选定棋子情况下，如果点击的棋子是当前玩家的棋子的话，选中该棋子
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {                              //else if->这里是指如果鼠标连续点击同一棋子两次，此棋子取消选中，selectedPoint = null
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if(selectedPoint != null  && model.isValidCapture(selectedPoint,point) && !model.isRiver(point) && !model.isRiver(selectedPoint)){
            view.removeChessComponentAtGrid(point);
            view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            model.removeChessPiece(point);
            model.moveChessPiece(selectedPoint,point);
            selectedPoint = null;
            swapColor();
            view.repaint();
        }
    }
    public void onPlayerClickButton(JButton button,ChessGameFrame chessGameFrame){
        if (button.getName()=="重新开始"){
            initialize();
            view.initiateChessComponent(model);
            view.repaint();
        }

    }

}