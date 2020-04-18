package chess;

import chess.figures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Board {

    TextureManager boardTex = new TextureManager(0, 0, Chess.display.width,
            Chess.display.height, "src/assets/ChessBoard.png");

    PlayingPiece[][] board = new PlayingPiece[8][8];

    Board() {
        init();
    }

    public void init() {
        int figureWidth = PlayingPiece.WIDTH;
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(PlayingPiece.WIDTH * i, PlayingPiece.HEIGHT, "src\\assets\\blackPawn.png");
            board[6][i] = new Pawn(PlayingPiece.WIDTH * i, PlayingPiece.HEIGHT * 6, "src\\assets\\whitePawn.png");
        }
        board[0][0] = new Rook(0,0,"src\\assets\\blackRook.png");
        board[0][1] = new Knight(figureWidth, 0, "src\\assets\\blackKnight.png");
        board[0][2] = new Bishop(figureWidth * 2, 0, "src\\assets\\blackBishop.png");
        board[0][3] = new Queen(figureWidth * 3, 0, "src\\assets\\blackQueen.png");
        board[0][4] = new King(figureWidth * 4, 0, "src\\assets\\blackKing.png");
        board[0][5] = new Bishop(figureWidth * 5, 0, "src\\assets\\blackBishop.png");
        board[0][6] = new Knight(figureWidth * 6, 0, "src\\assets\\blackKnight.png");
        board[0][7] = new Rook(figureWidth * 7,0,"src\\assets\\blackRook.png");

        board[7][0] = new Rook(0,figureWidth * 7,"src\\assets\\whiteRook.png");
        board[7][1] = new Knight(figureWidth, figureWidth * 7, "src\\assets\\whiteKnight.png");
        board[7][2] = new Bishop(figureWidth * 2, figureWidth * 7, "src\\assets\\whiteBishop.png");
        board[7][3] = new Queen(figureWidth * 3, figureWidth * 7, "src\\assets\\whiteQueen.png");
        board[7][4] = new King(figureWidth * 4, figureWidth * 7, "src\\assets\\whiteKing.png");
        board[7][5] = new Bishop(figureWidth * 5, figureWidth * 7, "src\\assets\\whiteBishop.png");
        board[7][6] = new Knight(figureWidth * 6, figureWidth * 7, "src\\assets\\whiteKnight.png");
        board[7][7] = new Rook(figureWidth * 7,figureWidth * 7,"src\\assets\\whiteRook.png");
        for (int i = 2; i < board.length - 2; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new EmptyFigure(i * figureWidth, j*figureWidth, "src\\assets\\empty.png");
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Chess.display.addGraphic(board[i][j].getTexture());
            }
        }
        Chess.display.addGraphic(boardTex);

    }

    public void update() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setX(j * PlayingPiece.HEIGHT);
                board[i][j].setY(i * PlayingPiece.WIDTH);

            }
        }
        Chess.display.addGraphic(boardTex);
        render();
    }

    public void move(int currX, int currY, int nextX, int nextY) {
        if(board[currY][currX].isLegalMove(currX, currY, nextX, nextY)) {
            board[nextY][nextX] = board[currY][currX];
            Chess.display.removeGraphic(board[currX][currY].getTexture());
            board[currY][currX] = new EmptyFigure(currX * PlayingPiece.WIDTH,currY * PlayingPiece.HEIGHT,"src\\assets\\empty.png");
            Chess.display.addGraphic(board[currX][currY].getTexture());
        } else System.out.println("can't move");
        update();

    }


    public void render() {
        boardTex.render();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].render();
            }
        }
    }

}
