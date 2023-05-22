package listener;

import model.ChessboardPoint;
import view.CellComponent;
import view.ChessSpeciesComponent;

public interface GameListener {

    void onPlayerClickCell(ChessboardPoint point, CellComponent component);


    void onPlayerClickChessPiece(ChessboardPoint point, ChessSpeciesComponent component);

    // click a cell with a chess

}
