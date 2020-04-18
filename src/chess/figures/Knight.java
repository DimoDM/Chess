package chess.figures;

import chess.TextureManager;

public class Knight extends PlayingPiece {

    public Knight(int x, int y, String path) {
        super(x, y, path);
    }
    public Knight() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
