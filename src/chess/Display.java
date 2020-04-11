package chess;

import javax.swing.*;
import java.awt.*;

public class Display{
    JFrame frame = new JFrame();

    Display(int widthSize, int heightSize, String name) {
        frame.setSize(widthSize, heightSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(name);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void renderImage(TextureManager graphic) {
        frame.add(graphic);
    }
}
