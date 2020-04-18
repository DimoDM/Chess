package chess;

import chess.figures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Board {

    TextureManager boardTex = new TextureManager(0, 0, Chess.display.width,
            Chess.display.height, "src/assets/ChessBoard.png");
    List<TextureManager> textures = new ArrayList<TextureManager>();

    int[][] board = {
            {51, 31, 41, 101, 91, 41, 31, 51},
            {11, 11, 11, 11, 11, 11, 11, 11},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {10, 10, 10, 10, 10, 10, 10, 10},
            {50, 30, 40, 100, 90, 40, 30, 50},
    };

    Board() {
        init();
    }

    public void init() {
        update();
    }

    public void update() {

        int width = Chess.display.width / 8;
        int height = Chess.display.height / 8;
        clean();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                StringBuilder path = new StringBuilder("src\\assets\\");
                path.append(board[i][j] % 10 == 0 ? "white" : "black");
                switch (board[i][j] / 10) {
                    case 1:
                        path.append("Pawn.png");
                        break;
                    case 3:
                        path.append("Knight.png");
                        break;
                    case 4:
                        path.append("Bishop.png");
                        break;
                    case 5:
                        path.append("Rook.png");
                        break;
                    case 9:
                        path.append("Queen.png");
                        break;
                    case 10:
                        path.append("King.png");
                        break;
                }
                textures.add(new TextureManager(height * j, width * i, width, height, path.toString()));
                Chess.display.addGraphic(textures.get(textures.size() - 1));

            }
        }
        Chess.display.addGraphic(boardTex);
        //for(int[] b: board)System.out.println(Arrays.toString(b));

    }

    public void move(int currX, int currY, int nextX, int nextY) {
        if(checkFigure(board[currY][currX]).isLegalMove(currX, currY, nextX, nextY)) {
            board[nextY][nextX] = board[currY][currX];
            board[currY][currX] = 0;
        } else System.out.println("can't move");
        update();

    }

    public PlayingPiece checkFigure(int number) {
        switch (number / 10) {
            case 1:
                return new Pawn();
            case 3:
                return new Knight();
            case 4:
                return new Bishop();
            case 5:
                return new Rook();
            case 9:
                return new Queen();
            case 10:
                return new King();
            default:return new Pawn();

        }
    }

    public void render() {
        boardTex.render();
        for (int i = 0; i < textures.size(); i++) {
            textures.get(i).render();
        }
    }

    public void clean() {
        Chess.display.removeGraphic(boardTex);
        for (int i = 0; i < textures.size(); i+=0) {
            Chess.display.removeGraphic(textures.get(i));
            textures.remove(0);
        }
    }

}
