package chess.figures;

import chess.TextureManager;

public class Rook extends PlayingPiece {

    public Rook(TextureManager texture, char color) {
        super( texture, color);
    }

    public Rook() {

    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
