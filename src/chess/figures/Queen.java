package chess.figures;

import chess.TextureManager;

public class Queen extends PlayingPiece {

    public Queen(TextureManager texture, char color) {
        super(texture, color);
    }

    public Queen() {

    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
