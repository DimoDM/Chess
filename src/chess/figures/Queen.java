package chess.figures;

import chess.TextureManager;

public class Queen extends PlayingPiece {

    public Queen(int x, int y, String path) {
        super(x, y, path);
    }

    public Queen() {

    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
