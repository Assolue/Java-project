package model;

public enum Chess {
    Elephant(7),Lion(6),Tiger(5),Leopard(4),
    Wolf(3),Dog(2),Cat(1),Mouse(0);
    private int rank;
    Chess(int rank){
        this.rank=rank;
    }
    public int getRank() {
        return rank;
    }
}
