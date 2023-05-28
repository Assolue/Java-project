package view;

import model.Chess;
import model.PlayerColor;

import javax.swing.*;
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
            if (owner==PlayerColor.BLUE){
                ImageIcon imageIcon=new ImageIcon("imgs/img_8.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
            if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_9.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}

        if (chess==Chess.Lion){
            if (owner==PlayerColor.BLUE){
                ImageIcon imageIcon=new ImageIcon("imgs/img_1.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
            if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_16.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        }
        if (chess==Chess.Tiger){
            if (owner==PlayerColor.BLUE){
            ImageIcon imageIcon=new ImageIcon("imgs/img_4.png");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        } if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_15.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}
        if (chess==Chess.Leopard){
            if (owner==PlayerColor.BLUE){
            ImageIcon imageIcon=new ImageIcon("imgs/img_6.png");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        } if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_11.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}
        if (chess==Chess.Wolf){
            if (owner==PlayerColor.BLUE){
            ImageIcon imageIcon=new ImageIcon("imgs/img_7.png");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        } if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_10.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}
        if (chess==Chess.Dog){
            if (owner==PlayerColor.BLUE){
            ImageIcon imageIcon=new ImageIcon("imgs/img_2.png");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        } if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_14.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}
        if (chess==Chess.Cat){
            if (owner==PlayerColor.BLUE){
            ImageIcon imageIcon=new ImageIcon("imgs/img_5.png");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        } if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_13.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}
        if (chess==Chess.Mouse){
            if (owner==PlayerColor.BLUE){
            ImageIcon imageIcon=new ImageIcon("imgs/img_3.png");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        } if (owner==PlayerColor.RED){
                ImageIcon imageIcon=new ImageIcon("imgs/img_12.png");
                Image image=imageIcon.getImage();
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }}
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }


    }

