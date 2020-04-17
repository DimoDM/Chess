package chess;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.init();

        while(true) {
            chess.update();
            chess.render();
            chess.clean();
        }
    }
}
