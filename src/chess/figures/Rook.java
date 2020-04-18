package chess.figures;

import chess.TextureManager;

public class Rook extends PlayingPiece {

    public Rook(int x, int y, String path) {
        super(x, y, path);
    }

    public Rook() {

    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
