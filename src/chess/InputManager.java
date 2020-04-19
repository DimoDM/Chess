package chess;

import chess.figures.PlayingPiece;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.List;


public class InputManager extends JPanel implements ChangeListener {

    private boolean isMouseRealised = false;
    private int currX = -1;
    private int currY = -1;
    private boolean pressed = false;
    List<TextureManager> textures = new ArrayList<>();

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
        else if (isMouseRealised) mouseReleased(xIndex, yIndex);

    }

    private void mousePressed(int x, int y, int xIndex, int yIndex, int width, int height) {
        clean();
        if (Chess.board.board[yIndex][xIndex].getColor() != ' ' && currY == -1 && currX == -1) {
            currX = xIndex;
            currY = yIndex;
        }
        //System.out.println("Mouse Pressed " + Chess.board.board[currY][currX].path);
        else if (currX != -1 && currY != -1) {
            if(Chess.board.board[yIndex][xIndex].getColor() == Chess.board.board[currY][currX].getColor()){
                currX = xIndex;
                currY = yIndex;
            }
                Chess.board.board[currY][currX].setX(x - (width / 2));
                Chess.board.board[currY][currX].setY(y - (width / 2));
                Chess.board.board[currY][currX].render();
        }
    }

    private void mouseReleased(int xIndex, int yIndex) {
        System.out.println("Mouse Released");
        if ((currX != xIndex || currY != yIndex) && currY != -1 && currX != -1) {
            Chess.board.move(currX, currY, xIndex, yIndex);
            currY = -1;
            currX = -1;
        }
        else if(currY == yIndex && currX == xIndex){

            Chess.board.board[currY][currX].setY(currY * PlayingPiece.HEIGHT);
            Chess.board.board[currY][currX].setX(currX * PlayingPiece.WIDTH);

            int index = 0;
            for (int i = 0; i < Chess.board.board.length; i++) {
                for (int j = 0; j < Chess.board.board[i].length; j++) {
                    if(Chess.board.board[currY][currX].isLegalMove(currX, currY, i, j)) {
                        textures.add(new TextureManager(j * PlayingPiece.WIDTH, i * PlayingPiece.HEIGHT, PlayingPiece.WIDTH, PlayingPiece.HEIGHT, "src\\assets\\sprite1.png"));
                        Chess.display.addGraphic(textures.get(index));
                        textures.get(index).render();
                        index++;
                    }
                }
            }
            Chess.board.makeBoardTexBackground();
        }
        isMouseRealised = false;
    }

    public void clean() {
        for (int i = 0; i < textures.size(); i += 0) {
            Chess.display.removeGraphic(textures.get(0));
            textures.remove(0);
            //System.out.println(1);
        }
    }

}
