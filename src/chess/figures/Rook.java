package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class Rook extends PlayingPiece {

    public Rook(int x, int y, String path) {
        super(x, y, path);
    }

    public Rook() {

    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX) {
        //columns move
        if(currY == nextY && nextX != currX) {
            if(nextX > currX) {
                for (int i = currX + 1; i < nextX; i++) {
                    if (Chess.board.board[currY][i].getColor() != ' ') return false;
                }
                return Chess.board.board[nextY][nextX].getColor() != color;
            }
            else for (int i = currX - 1; i > nextX ; i--) {
                if (Chess.board.board[currY][i].getColor() != ' ') return false;
            }
            return Chess.board.board[nextY][nextX].getColor() != color;

        }

        //rows move
        else if(currX == nextX && currY != nextY) {
            if(nextY > currY) {
                for (int i = currY + 1; i < nextY; i++) {
                    if (Chess.board.board[i][currX].getColor() != ' ') return false;
                }
                return Chess.board.board[nextY][nextX].getColor() != color;
            }
            else for (int i = currY - 1; i > nextY ; i--) {
                if (Chess.board.board[i][currX].getColor() != ' ') return false;
            }
            return Chess.board.board[nextY][nextX].getColor() != color;
        }

        return false;
    }
}
