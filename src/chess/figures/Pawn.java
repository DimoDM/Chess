package chess.figures;

import chess.TextureManager;

public class Pawn extends PlayingPiece {


    public Pawn(TextureManager texture, char color) {
        super(texture, color);
    }
    public Pawn() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
