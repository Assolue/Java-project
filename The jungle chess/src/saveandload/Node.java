package saveandload;

public class Node {
    private int x;
    private int y;
    private int itRank;
    private char owner;

    public Node(int x,int y,int itRank,char owner){
        this.x = x;
        this.y = y;
        this.itRank = itRank;
        this.owner = owner;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getItRank() {
        return itRank;
    }

    public void setItRank(int itRank) {
        this.itRank = itRank;
    }

    public char getOwner() {
        return owner;
    }

    public void setOwner(char owner) {
        this.owner = owner;
    }

}
