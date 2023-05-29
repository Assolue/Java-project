package view;

import controller.GameController;

import saveandload.Recorder;


import model.Chessboard;


import javax.swing.*;
import java.awt.*;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;

    private final int ONE_CHESS_SIZE;

    private ChessboardComponent chessboardComponent;
    private Chessboard chessboard;
    public ChessGameFrame(int width, int height) {
        setTitle("2023 CS109 Project by Assoule and Tian"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.ONE_CHESS_SIZE = (HEIGTH * 4 / 5) / 9;
        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.窗口在屏幕中间打开
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);


        addChessboard();
        addLabel();addlable();
        addHelloButton();
        addLoadButton3();
        addUndoButton();
        addSaveButton();
        loadButton();

        addTurn();addTurn2();
    }
    public int turn=1;
    private int caculateTurn(){
        turn= GameController.number/4;
        return turn;

    }

    public int getTurn() {
        caculateTurn();
        return turn;
    }

    public ChessboardComponent getChessboardComponent() {
        return chessboardComponent;
    }

    public void setChessboardComponent(ChessboardComponent chessboardComponent) {
        this.chessboardComponent = chessboardComponent;
    }

    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        chessboardComponent = new ChessboardComponent(ONE_CHESS_SIZE);
        chessboardComponent.setLocation(HEIGTH / 5, HEIGTH / 10);
        add(chessboardComponent);
    }
    private void addTurn(){
        JLabel statusLabel = new JLabel("Turn: ");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10+60);
        statusLabel.setSize(200, 20);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }
    private static JLabel label;
    private void addTurn2(){
        label = new JLabel("1");
        label.setLocation(HEIGTH+60, HEIGTH / 10+60);
        label.setSize(200,20);
        label.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label);
    }
    public static void setNumber(int number) { // 定义方法更新数字显示
        label.setText(Integer.toString(number)); // 更新标签文字内容
    }
    private static JLabel label2;
    private void addlable(){
        label2 = new JLabel("It is BLUE's turn ");
        label2.setLocation(HEIGTH, HEIGTH / 10+90);
        label2.setSize(200, 20);
        label2.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label2);
    }
    public static void SetText(){
        label2.setText("It is "+GameController.getAnotherPlayer()+"'s turn");
    }
    public static void SetText2(){
        label2.setText("It is "+GameController.getCurrentPlayer()+"'s turn");
    }

    /**
     * 在游戏面板中添加标签
     */
    private void addLabel() {
        JLabel statusLabel = new JLabel("The Jungle Chess");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("斗兽棋规则");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "1、鼠吃象法：八兽的吃法除按照大小次序外，惟鼠能吃象。\n" +
                " 2、互吃法：凡同类相遇，可互相吃。\n" +
                " 3、陷阱：棋盘设陷阱，专为限制敌兽的战斗力（自己的兽，不受限制），敌兽走入陷阱，即失去战斗力，本方的任意兽类都可以吃去陷阱里的兽类。\n"
        +"4.当狮子和老虎在河边时，可以横向和纵向跳跃河流，直接到达河对岸,老鼠可以进河，其他动物不得进河。"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("SimSun", Font.BOLD, 20));
        add(button);
    }

    public JButton button1 = new JButton("重新开始");
    private void addLoadButton3() {
        button1.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button1.setSize(200, 60);
        button1.setFont(new Font("SimSun", Font.BOLD, 20));
        GameController.number=4;
        button1.addActionListener((e) ->{ ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
        GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard(1));
        mainFrame.setVisible(true);});
        add(button1);

    }


    private void addSaveButton(){
        JButton button = new JButton("保存进度");
        button.setLocation(HEIGTH,HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("SimSun", Font.BOLD, 20));
        button.addActionListener((e) -> Recorder.recordFile());
        add(button);

    }
    private void addUndoButton(){
        JButton button = new JButton("Undo");
        button.setLocation(HEIGTH, HEIGTH / 10 + 600);
        button.setSize(200, 60);
        button.setFont(new Font("SimSun", Font.BOLD, 20));
        button.addActionListener((e) ->{ ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
            GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard(1),1);
            mainFrame.setVisible(true);});
        add(button);
    }

    private void loadButton() {
        JButton button = new JButton("继续游戏");
        button.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button.setSize(200, 60);
        button.setFont(new Font("SimSun", Font.BOLD, 20));
        button.addActionListener((e) ->{ ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
            GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard(1),1);
            mainFrame.setVisible(true);});
        add(button);

    }
    public void reNew(ChessboardComponent chessboardComponent){
        chessboardComponent.initiateGridComponents();
    }



   /* private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this,"Input Path here");
            GameController gameController=;
            gameController.loadGameFromFile(path);
        });
    }*/


}
