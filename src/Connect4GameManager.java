public class Connect4GameManager {

    Connect4Board board;


    Connect4GameManager(int boardLength, int boardHeight) {
        this.board = new Connect4Board(boardLength, boardHeight);
    }

    public int turn;

    public boolean addPiece(int column) {
        if (board.addPiece(column, turn%2)) {
            ++turn;
            notifyAll();
            return true;
        } else return false;
    }

    public int runTurn(int column) {
        int ret = -1;
        if (addPiece(column)) {
            if (Connect4GameLogic.testMoveWin(column, board)) {
                ret = 0;
            } else {
                //Ia.Play()
            }
        }
        return ret;
    }

    public int[][] getSerializedBoard() {
        return board.serialize();
    }
}
