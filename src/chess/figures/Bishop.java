package chess.figures;

import chess.TextureManager;

public class Bishop extends PlayingPiece {

    public Bishop(TextureManager texture, char color) {
        super(texture, color);
    }

    public Bishop() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
