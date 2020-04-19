package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class Pawn extends PlayingPiece {


    public Pawn(int x, int y, String path) {
        super(x, y, path);
    }
    public Pawn() {
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX) {
        if(color == 'w') {
            if(((currY == 6 && nextY == 4 && Chess.board.board[nextY][currX].color == ' ')
                    ||(currY - nextY == 1)) && Chess.board.board[currY - 1][currX].color == ' ' && currX == nextX) return true;
            else return currY - nextY == 1 && (currX - nextX == 1 || nextX - currX == 1)
                    && Chess.board.board[nextY][nextX].color == 'b';
        }
        else if(color == 'b') {
            if(((currY == 1 && nextY == 3 && Chess.board.board[nextY][currX].color == ' ')
                    ||(nextY - currY == 1)) && Chess.board.board[currY + 1][currX].color == ' ' && currX == nextX) return true;
            else return nextY - currY == 1 && (currX - nextX == 1 || nextX - currX == 1)
                    && Chess.board.board[nextY][nextX].color == 'w';
        }
        return false;
    }
}
