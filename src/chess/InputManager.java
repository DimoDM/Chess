package chess;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.MouseInfo;


public class InputManager extends JPanel implements ChangeListener {

    private int pressedFigureIndex = -1;
    private boolean isMouseRealised = false;
    private int currX;
    private int currY;
    private boolean pressed = false;

    InputManager() {
        JButton button = new JButton("");
        button.getModel().addChangeListener(this);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(0, 0, Chess.display.getWidth(), Chess.display.getHeight());
        Chess.display.frame.add(button);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();
        if (model.isPressed() != pressed) {
            pressed = model.isPressed();
            if (!pressed) isMouseRealised = true;
        }
    }


    public void update() {
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - Chess.display.frame.getLocation().x - 8;
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - Chess.display.frame.getLocation().y - 30;
        int xIndex = x / ((Chess.display.width) / 8);
        int yIndex = y / ((Chess.display.height) / 8);
        int width = Chess.display.width / 8;
        int height = Chess.display.height / 8;

        if (pressed) mousePressed(x, y, xIndex, yIndex, width, height);
        else if(isMouseRealised) mouseReleased(xIndex, yIndex);

    }

    private void mousePressed(int x, int y,int xIndex, int yIndex, int width, int height) {
        if (pressedFigureIndex == -1) {
            for (int i = 0; i < Chess.board.textures.size(); i++) {
                if (Chess.board.textures.get(i).x == xIndex * width && Chess.board.textures.get(i).y == yIndex * height) {
                    currX = xIndex;
                    currY = yIndex;
                    pressedFigureIndex = i;
                    break;
                }
            }
        } else {
            Chess.board.textures.get(pressedFigureIndex).setX(x - (width / 2));
            Chess.board.textures.get(pressedFigureIndex).setY(y - (height / 2));
        }
    }

    private void mouseReleased(int xIndex, int yIndex) {
        isMouseRealised = false;
        Chess.board.move(currX, currY, xIndex, yIndex);
        pressedFigureIndex = -1;
    }

}
