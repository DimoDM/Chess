package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class PlayingPiece {

    int xPos;
    int yPos;
    TextureManager texture;
    char color;

    public PlayingPiece(int xPos, int yPos, TextureManager texture, char color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.texture = texture;
        this.color = color;
    }

    public PlayingPiece(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        int width = Chess.display.getWidth() / 8;
        int height = Chess.display.getWidth() / 8;
        texture = new TextureManager(xPos * width, yPos*height, width,height,"src\\assets\\empty.png");
    }


    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return false;
    }

}
