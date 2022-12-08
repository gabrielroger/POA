public class Connect4GameManager {

    Connect4Board board;

    Connect4GameManager(int boardLength, int boardHeight) {
        this.board = new Connect4Board(boardLength, boardHeight);
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
        int winningTeam = -1;
        while(winningTeam == -1) {

        }
    }
}
