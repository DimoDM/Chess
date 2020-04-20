package chess;

import chess.figures.*;

public class Board {

    TextureManager boardTex = new TextureManager(0, 0, Chess.display.width,
            Chess.display.height, "src/assets/ChessBoard.png");


    public PlayingPiece[][] board = new PlayingPiece[8][8];
    public Vector2D whiteKingCords = new Vector2D();
    public Vector2D blackKingCords = new Vector2D();

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
        blackKingCords.x = 4;
        blackKingCords.y = 0;
        board[0][5] = new Bishop(figureWidth * 5, 0, "src\\assets\\blackBishop.png");
        board[0][6] = new Knight(figureWidth * 6, 0, "src\\assets\\blackKnight.png");
        board[0][7] = new Rook(figureWidth * 7,0,"src\\assets\\blackRook.png");

        board[7][0] = new Rook(0,figureWidth * 7,"src\\assets\\whiteRook.png");
        board[7][1] = new Knight(figureWidth, figureWidth * 7, "src\\assets\\whiteKnight.png");
        board[7][2] = new Bishop(figureWidth * 2, figureWidth * 7, "src\\assets\\whiteBishop.png");
        board[7][3] = new Queen(figureWidth * 3, figureWidth * 7, "src\\assets\\whiteQueen.png");
        board[7][4] = new King(figureWidth * 4, figureWidth * 7, "src\\assets\\whiteKing.png");
        whiteKingCords.x = 4;
        whiteKingCords.y = 7;
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
        render();
    }

    public void move(int currX, int currY, int nextX, int nextY) {
        if(board[currY][currX].isLegalMove(currX, currY, nextY, nextX)) {

            Chess.display.removeGraphic(board[nextY][nextX].getTexture());
            board[nextY][nextX] = board[currY][currX];
            board[currY][currX] = new EmptyFigure(currX * PlayingPiece.WIDTH,currY * PlayingPiece.HEIGHT,"src\\assets\\empty.png");
        } else System.out.println("can't move");
        update();
    }

    public boolean isKingUnderThreat(int kingX, int kingY, King king) {

        PlayingPiece help = board[kingY][kingX];
        PlayingPiece help2 = board[king.getY() / PlayingPiece.HEIGHT][king.getX() / PlayingPiece.WIDTH];
        board[kingY][kingX] = king;
        board[king.getY() / PlayingPiece.HEIGHT][king.getX() / PlayingPiece.WIDTH] = new EmptyFigure(king.getX(), king.getY(), " ");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                PlayingPiece figure = board[i][j];
                if(figure.getColor() != king.getColor() && figure.getColor() != ' ')
                //System.out.println("test: " + figure.path + " i: " + i + " j: " + j + " board-length: " + board.length + " board[i]-length: " + board[i].length );
                if(figure.isLegalMove(figure.getX() / PlayingPiece.WIDTH, figure.getY() / PlayingPiece.HEIGHT, kingY, kingX)) {
                    board[kingY][kingX] = help;
                    board[king.getY() / PlayingPiece.HEIGHT][king.getX() / PlayingPiece.WIDTH] = help2;
                    System.out.println("threat: " + figure.path);
                    return true;
                }
            }
        }
        System.out.println("help: " + help.path);
        board[kingY][kingX] = help;
        board[king.getY() / PlayingPiece.HEIGHT][king.getX() / PlayingPiece.WIDTH] = help2;

        return false;
    }

    public void render() {
        boardTex.render();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].render();
            }
        }
    }

    public void clean() {
        Chess.display.removeGraphic(boardTex);
        for (PlayingPiece[] playingPieces : board) {
            for (PlayingPiece playingPiece : playingPieces) {
                Chess.display.removeGraphic(playingPiece.getTexture());
            }
        }
    }

    public void makeBoardTexBackground() {
        Chess.display.removeGraphic(boardTex);
        Chess.display.addGraphic(boardTex);
        //boardTex.render();
    }

}
