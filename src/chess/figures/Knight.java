package chess.figures;

import chess.TextureManager;

public class Knight extends PlayingPiece {

    public Knight(TextureManager texture, char color) {
        super(texture, color);
    }

    public Knight() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
