package chess;


import javax.swing.*;
import java.awt.*;

public class Display{
    JFrame frame = new JFrame();
    int width;
    int height;

    Display(int widthSize, int heightSize, String name) {
        this.width = widthSize - 40;
        this.height = heightSize - 40;

        frame.setSize(widthSize - 24, heightSize - 2);
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.add(new TextureManager());
        frame.setTitle(name);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public void addGraphic(TextureManager t) {
        frame.add(t);
        frame.setVisible(true);
    }


}
