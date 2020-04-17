package chess.figures;

import chess.Chess;
import chess.TextureManager;

public class PlayingPiece {

    TextureManager texture;
    char color;

    public PlayingPiece(TextureManager texture, char color) {
        this.texture = texture;
        this.color = color;
    }

    public PlayingPiece() {
    }

    public TextureManager getTexture() {
        return texture;
    }

    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return false;
    }

}
