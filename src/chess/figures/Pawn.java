package chess.figures;

import chess.TextureManager;

public class Pawn extends PlayingPiece {


    public Pawn(int x, int y, String path) {
        super(x, y, path);
    }
    public Pawn() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
