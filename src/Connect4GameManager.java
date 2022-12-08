public class Connect4GameManager {

    Connect4Board board;

    public int turn;

    public boolean addPiece(int column) {
        if (board.addPiece(column, turn%2)) {
            ++turn;
            return true;
        } else return false;
    }

    public int testWinner() {
        for (int i = 0; i < board.tiles.size(); i++) {
            Tile t = board.tiles.elementAt(i);
            if (testTileWinningRight(t)) {
                return t.piece.team;
            }
        }
        return -1;
    }

    private boolean testTileWinningRight(Tile t) {
        if (t.piece != null) {
            int x = t.x;
            int y = t.y;
            int team = t.piece.team;
            if (y <= board.height-4 && board.getTile(x, y+1).piece.team == team && board.getTile(x, y+2).piece.team == team && board.getTile(x, y+3).piece.team == team) {
                return true;
            }
            if (x < board.length - 4 && y <= board.height-4 &&  board.getTile(x+1, y+1).piece.team == team && board.getTile(x+2, y+2).piece.team == team && board.getTile(x+3, y+3).piece.team == team) {
                return true;
            }
            if (x < board.length - 4 && board.getTile(x+1, y).piece.team == team && board.getTile(x+2, y).piece.team == team && board.getTile(x+3, y).piece.team == team) {
                return true;
            }
            if (x < board.length - 4 && y >= 3 && board.getTile(x+1, y-1).piece.team == team && board.getTile(x+2, y-2).piece.team == team && board.getTile(x+3, y-3).piece.team == team) {
                return true;
            }
            if (y >= 3 && board.getTile(x, y-1).piece.team == team && board.getTile(x, y-2).piece.team == team && board.getTile(x, y-3).piece.team == team) {
                return true;
            }
            return false;
        }
        else return false;
    }
}
