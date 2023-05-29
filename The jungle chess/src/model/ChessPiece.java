package model;


public class ChessPiece {
    // the owner of the chess
    private PlayerColor owner;
    // Elephant? Cat? Dog? ...
    private Chess name;


    public ChessPiece(PlayerColor owner, Chess name) {
        this.owner = owner;
        this.name = name;
    }

    public boolean canCapture(ChessPiece target) {
        // TODO: Finish this method!
        boolean examine=false;

        if (target.getOwner()==this.getOwner()){examine=false;}
        else {
            if (this.getName()==Chess.Elephant){
                if (target.getName()==Chess.Mouse){examine=false;}
            else  if (this.getName().getRank()>=target.getName().getRank()){examine=true;}
                else examine=false;}
            else if (this.getName()==Chess.Mouse){
                if (target.getName()==Chess.Elephant){examine=true;}}
            else {
                if (this.getName().getRank()>=target.getName().getRank()){examine=true;}
                else examine=false;}}
        return examine;
    }

    public Chess getName() {
        return name;
    }

    public int getRank(Chess chess){
        return chess.getRank();
    }


    public PlayerColor getOwner() {
        return owner;
    }

    public char getOwner2(PlayerColor playerColor){
        if(playerColor == PlayerColor.BLUE){return 'B';}
        if(playerColor == PlayerColor.RED){return 'R';}
        return 0;
    }
    public void setOwner(PlayerColor owner) {
        this.owner = owner;
    }
    public void setName(Chess name) {
        this.name = name;
    }

}
