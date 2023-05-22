package view;

import model.Chess;
import model.PlayerColor;

import java.awt.*;

public class ChessSpeciesComponent extends ChessComponent{
    private Chess chess;
    private boolean selected;

    public ChessSpeciesComponent(PlayerColor owner, int size, Chess chess) {
        super(owner, size);
        this.chess=chess;
        this.selected = false;
        setLocation(0,0);
        setVisible(true);}
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("楷体", Font.PLAIN, getWidth() / 2);
        g2.setFont(font);
        g2.setColor(owner.getColor());
        if (chess==Chess.Elephant){
            g2.drawString("象", getWidth() / 4, getHeight() * 5 / 8);}// FIXME: Use library to find the correct offset.
        if (chess==Chess.Lion){g2.drawString("狮", getWidth() / 4, getHeight() * 5 / 8);}
        if (chess==Chess.Tiger){g2.drawString("虎", getWidth() / 4, getHeight() * 5 / 8);}
        if (chess==Chess.Leopard){g2.drawString("豹", getWidth() / 4, getHeight() * 5 / 8); }
        if (chess==Chess.Wolf){g2.drawString("狼", getWidth() / 4, getHeight() * 5 / 8);}
        if (chess==Chess.Dog){g2.drawString("狗", getWidth() / 4, getHeight() * 5 / 8); }
        if (chess==Chess.Cat){g2.drawString("猫", getWidth() / 4, getHeight() * 5 / 8);}
        if (chess==Chess.Mouse){g2.drawString("鼠", getWidth() / 4, getHeight() * 5 / 8);}
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }


    }

