package chess.figures;

public class EmptyFigure extends PlayingPiece {

    public EmptyFigure(int x, int y, String path) {
        super(x, y, path);
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextX, int nextY) {
        return false;
    }
}
