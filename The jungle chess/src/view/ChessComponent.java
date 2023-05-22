package view;

import model.PlayerColor;

import javax.swing.*;

public class ChessComponent extends JComponent {
    public PlayerColor owner;
    public boolean selected;
    public ChessComponent(PlayerColor owner,  int size){
        this.owner = owner;
        this.selected = false;
        setSize(size/2, size/2);
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }



}
