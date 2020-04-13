package chess;


import javax.swing.*;
import java.awt.*;

public class Display{
    JFrame frame = new JFrame();
    int width;
    int height;

    Display(int widthSize, int heightSize, String name) {
        this.width = widthSize;
        this.height = heightSize;

        frame.setSize(widthSize, heightSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new TextureManager());
        frame.setTitle(name);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void addGraphic(TextureManager t) {
        frame.add(t);
    }


}
