package chess;

import java.util.Scanner;

public class Chess {

    public static Display display;
    Board board;

    public void init() {
        display = new Display(600, 600, "Chess");
        board = new Board();
    }

    public void update() {

    }

    public void render() {
        board.render();


        try {Thread.sleep(10);} catch (Exception ex) {}
    }
}
