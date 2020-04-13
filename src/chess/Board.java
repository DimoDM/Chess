package chess;

public class Board {

    Board(){
        printBoard();
    }

    public void printBoard() {
        TextureManager board = new TextureManager(0,0,Chess.display.width,
                Chess.display.height, "src/assets/ChessBoard.png");
        Chess.display.addGraphic(board);

        board.render();
    }

}
