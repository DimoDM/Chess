package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class Queen extends PlayingPiece {

    public Queen(int x, int y, String path) {
        super(x, y, path);
    }

    public Queen() {

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

        //upper left
        else if(currX - nextX == currY - nextY && currX - nextX > 0) {
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
