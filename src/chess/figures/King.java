package chess.figures;

import chess.TextureManager;

public class King extends PlayingPiece {

    public King(int xPos, int yPos, TextureManager texture, char color) {
        super(xPos, yPos, texture, color);
    }

    public King(int xPos, int yPos) {
        super(xPos, yPos);
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return true;
    }
}
