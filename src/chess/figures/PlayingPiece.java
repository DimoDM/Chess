package chess.figures;

import chess.Chess;
import chess.TextureManager;

public abstract class PlayingPiece {

    TextureManager texture;
    char color;
    int x;
    int y;
    public String path;
    public final static int WIDTH = Chess.display.getWidth() / 8;
    public final static int HEIGHT = Chess.display.getHeight() / 8;

    public PlayingPiece(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
        if(path.contains("white")) color = 'w';
        else if(path.contains("black")) color = 'b';
        else color = ' ';
        texture = new TextureManager(this.x, this.y, WIDTH, HEIGHT, path);
    }

    public PlayingPiece() {
    }

    public TextureManager getTexture() {
        return texture;
    }

    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return false;
    }
    public void render() {
        texture.render();
    }

    public void setX(int x) {
        this.x = x;
        texture.setX(x);
    }

    public void setY(int y) {
        this.y = y;
        texture.setY(y);
    }

    public char getColor() {
        return color;
    }
}
