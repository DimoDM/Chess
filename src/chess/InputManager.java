package chess;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputManager implements MouseListener {
    
    InputManager(){
        Chess.display.frame.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed; # of clicks: "
                + e.getClickCount()+ e);
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released; # of clicks: "
                + e.getClickCount() + e);
        //e.getLocationOnScreen();
        System.out.println("x: " + e.getX() + " y: " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    

}
