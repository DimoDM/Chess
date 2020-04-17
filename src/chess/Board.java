package chess;

import chess.figures.*;

import java.util.ArrayList;
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
        Chess.display.addGraphic(boardTex);

    }

    public void init() {
        update();
    }

    public void update() {

        clean();

        int width = Chess.display.width / 8;
        int height = Chess.display.height / 8;

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
                System.out.println(height * j + " " + width * i + " " + path.toString());
                textures.add(new TextureManager(height * j, width * i, width, height, path.toString()));
                Chess.display.addGraphic(textures.get(textures.size() - 1));

            }
        }

    }

    public void move(int currX, int currY, int nextX, int nextY) {
        if(checkFigure(board[currX][currY], currX, currY).isLegalMove(currX, currY, nextX, nextY)) {
            board[nextX][nextY] = board[currX][currY];
            board[currX][currY] = 0;
            update();
        }

    }

    private PlayingPiece checkFigure(int number, int x, int y) {
        switch (number / 10) {
            case 1:
                return new Pawn(x, y);
            case 3:
                return new Knight(x, y);
            case 4:
                return new Bishop(x, y);
            case 5:
                return new Rook(x, y);
            case 9:
                return new Queen(x, y);
            case 10:
                return new King(x, y);
            default:
                return new PlayingPiece(x, y);
        }
    }

    public void render() {
        boardTex.render();
        for (int i = 0; i < textures.size(); i++) {
            textures.get(i).render();
        }
    }

    public void clean() {
        for (int i = 0; i < textures.size(); i++) {
            textures.remove(0);
        }
    }

}
