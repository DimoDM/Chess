package chess;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    JFrame frame = new JFrame();
    Image image;

    Display() {
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("chess");
        frame.setResizable(false);

        frame.setVisible(true);
    }
}
