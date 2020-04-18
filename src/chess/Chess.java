package chess;

public class Chess {

    public static Display display;
    public static Board board;
    InputManager input;

    public void init() {
        display = new Display(600, 600, "Chess");
        board = new Board();
        input = new InputManager();
    }

    public void update() {
        input.update();
    }

    public void render() {
        //board.render();


        try {Thread.sleep(10);} catch (Exception ex) {}
    }

    public void clean() {
    }
}
