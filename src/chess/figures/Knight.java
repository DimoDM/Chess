package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class Knight extends PlayingPiece {

    public Knight(int x, int y, String path) {
        super(x, y, path);
    }
    public Knight() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX) {
        return ((nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8)
            && ((nextX - currX == 2 && nextY - currY == 1)
                || (nextX - currX == 2 && currY - nextY == 1)
                || (nextY - currY == 2 && nextX - currX == 1)
                || (nextY - currY == 2 &&currX - nextX  == 1)
                || (currX - nextX == 2 && nextY - currY == 1)
                || (currX - nextX == 2 &&currY - nextY == 1)
                || (currY - nextY == 2 && nextX - currX == 1)
                || (currY - nextY == 2 &&currX - nextX == 1))
                && color != Chess.board.board[nextY][nextX].getColor());
    }
}
