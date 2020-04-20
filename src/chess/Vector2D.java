package chess;

public class Vector2D {
    int x;
    int y;

    Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Vector2D() {}

    public boolean compare (Vector2D vec) {
        return this.x == vec.x && this.y == vec.y;
    }
    public void makeEqual(int x, int y) {
        this.x = x;
        this.y = y;
    }
}