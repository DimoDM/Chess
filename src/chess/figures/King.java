package chess.figures;

import chess.TextureManager;

public class King extends PlayingPiece {

    public King(TextureManager texture, char color) {
        super(texture, color);
    }

    public King() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
