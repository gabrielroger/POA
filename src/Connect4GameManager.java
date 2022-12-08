public class Connect4GameManager {

    Connect4Board board;
    Connect4GameLogic logic;

    Connect4GameManager(int boardLength, int boardHeight) {
        this.board = new Connect4Board(boardLength, boardHeight);
        this.logic = Connect4GameLogic.instance;
    }

    public int turn;

    public boolean addPiece(int column) {
        if (board.addPiece(column, turn%2)) {
            ++turn;
            return true;
        } else return false;
    }

    public void run() {
        //Initialize IA player

    }
}
