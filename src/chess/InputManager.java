package chess;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class InputManager implements MouseListener {

    private boolean mouseDown = false;
    private int pressedFigureIndex = -1;
    private int currX;
    private int currY;

    InputManager() {
        Chess.display.frame.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        mouseDown = true;
    }

    public void update() {

        int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - Chess.display.frame.getLocation().x - 8;
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - Chess.display.frame.getLocation().y - 30;
        int xIndex = x / ((Chess.display.width) / 8);
        int yIndex = y / ((Chess.display.height) / 8);
        int width = Chess.display.width / 8;
        int height = Chess.display.height / 8;

        if (mouseDown) {
            if (pressedFigureIndex == -1) {
                System.out.println("Picking figure");
                for (int i = 0; i < Chess.board.textures.size(); i++) {
                    if (Chess.board.textures.get(i).x == xIndex * width && Chess.board.textures.get(i).y == yIndex * height) {
                        currX = xIndex;
                        currY = yIndex;
                        pressedFigureIndex = i;
                        break;
                    }
                }
            } else {
                Chess.board.textures.get(pressedFigureIndex).setX(x);
                Chess.board.textures.get(pressedFigureIndex).setY(y);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        mouseDown = false;


        int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - Chess.display.frame.getLocation().x - 8;
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - Chess.display.frame.getLocation().y - 30;
        int xIndex = x / ((Chess.display.width) / 8);
        int yIndex = y / ((Chess.display.height) / 8);

        //System.out.println("moving figure cX: " + currX + " cY: " + currY + " nX: " + xIndex + " nY: " + yIndex);

        Chess.board.move(currX, currY, xIndex, yIndex);

        pressedFigureIndex = -1;
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

}
