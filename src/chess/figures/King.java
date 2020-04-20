package chess.figures;


import chess.Chess;

public class King extends PlayingPiece {

    public King(int x, int y, String path) {
        super(x, y, path);
        isKing = true;
    }

    public King(char color) {
        super(color);
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX) {
        if ((Math.abs(currX - nextX) == 1 || currX == nextX) && (Math.abs(currY - nextY) == 1 || currY == nextY)
                && Chess.board.board[nextY][nextX].getColor() != color && !Chess.board.isKingUnderThreat(nextX, nextY, this)){
            if(color == 'w') Chess.board.whiteKingCords.makeEqual(nextX, nextY);
            else if(color == 'b') Chess.board.blackKingCords.makeEqual(nextX, nextY);
            return true;
        }
        return false;
    }
}
