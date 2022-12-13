package Back;

public class Connect4GameManager {

    Connect4Board board;


    public Connect4GameManager(int boardLength, int boardHeight) {
        this.board = new Connect4Board(boardLength, boardHeight);
    }

    public int turn;

    public boolean addPiece(int column, int team) {
        if (board.addPiece(column, team)) {
            ++turn;
            return true;
        } else return false;
    }

    public int runTurn(int column) {

        int ret = 0;
        if (addPiece(column, 1)) {
            if (Connect4GameLogic.testMoveWin(column, board)) {
                ret = 1;
            } else {
                int iaPlay = MiniMax.AlphaBetaSearch(new State(new Connect4Board(board), 0, 0));

                System.out.println("IaPlay : " + iaPlay);

                addPiece(iaPlay, 0);
                if (Connect4GameLogic.testMoveWin(iaPlay, board)) {
                    ret = 2;
                }
            }
        } else {
            ret = -1;
        }
        return ret;
    }

    public int[][] getSerializedBoard() {
        return board.serialize();
    }
}
