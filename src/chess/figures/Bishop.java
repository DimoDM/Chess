package chess.figures;

import chess.TextureManager;

public class Bishop extends PlayingPiece {

    public Bishop(int x, int y, String path) {
        super(x, y, path);
    }

    public Bishop() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
