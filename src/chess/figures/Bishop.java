package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class Bishop extends PlayingPiece {

    public Bishop(int x, int y, String path) {
        super(x, y, path);
    }

    public Bishop() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX) {
        //upper left
        if(currX - nextX == currY - nextY && currX - nextX > 0) {
            for (int i = 1; i < currX - nextX; i++) {
                if (Chess.board.board[currY - i][currX - i].getColor() != ' ') return false;
            }
            return Chess.board.board[nextY][nextX].getColor() != color;
        }
        //upper right
        else if(nextX - currX == currY - nextY && nextX - currX > 0) {
            for (int i = 1; i < nextX - currX; i++) {
                if (Chess.board.board[currY - i][currX + i].getColor() != ' ') return false;
            }
            return Chess.board.board[nextY][nextX].getColor() != color;
        }
        //lower left
        else if(currX - nextX == nextY - currY && currX - nextX > 0) {
            for (int i = 1; i < currX - nextX; i++) {
                if (Chess.board.board[currY + i][currX - i].getColor() != ' ') return false;
            }
            return Chess.board.board[nextY][nextX].getColor() != color;
        }
        //lower right
        else if(nextX - currX == nextY - currY && nextX - currX > 0) {
            for (int i = 1; i < nextX - currX; i++) {
                if (Chess.board.board[currY + i][currX + i].getColor() != ' ') return false;
            }
            return Chess.board.board[nextY][nextX].getColor() != color;
        }
        return false;
    }
}
