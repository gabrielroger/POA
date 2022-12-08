public class Connect4GameLogic {

    public static Connect4GameLogic instance;

    public boolean testMoveWin(int column, Connect4Board board) {
        return testTileWin(board.tiles.elementAt(column + board.length*board.getColumnHeight(column)), board);
    }

    public boolean testTileWin(Tile t, Connect4Board board) {
        if (t.piece != null) {
            int x = t.x;
            int y = t.y;
            int team = t.piece.team;
            if (y <= board.height - 4 && board.getTile(x, y + 1).piece.team == team && board.getTile(x, y + 2).piece.team == team && board.getTile(x, y + 3).piece.team == team) {
                return true;
            }
            if (x < board.length - 4 && y <= board.height - 4 && board.getTile(x + 1, y + 1).piece.team == team && board.getTile(x + 2, y + 2).piece.team == team && board.getTile(x + 3, y + 3).piece.team == team) {
                return true;
            }
            if (x < board.length - 4 && board.getTile(x + 1, y).piece.team == team && board.getTile(x + 2, y).piece.team == team && board.getTile(x + 3, y).piece.team == team) {
                return true;
            }
            if (x < board.length - 4 && y >= 3 && board.getTile(x + 1, y - 1).piece.team == team && board.getTile(x + 2, y - 2).piece.team == team && board.getTile(x + 3, y - 3).piece.team == team) {
                return true;
            }
            if (y >= 3 && board.getTile(x, y - 1).piece.team == team && board.getTile(x, y - 2).piece.team == team && board.getTile(x, y - 3).piece.team == team) {
                return true;
            }
            if (x >= 4 && y <= board.height - 4 && board.getTile(x - 1, y + 1).piece.team == team && board.getTile(x - 2, y + 2).piece.team == team && board.getTile(x - 3, y + 3).piece.team == team) {
                return true;
            }
            if (x >= 4 && board.getTile(x - 1, y).piece.team == team && board.getTile(x - 2, y).piece.team == team && board.getTile(x - 3, y).piece.team == team) {
                return true;
            }
            if (x >= 4 && y >= 3 && board.getTile(x - 1, y - 1).piece.team == team && board.getTile(x - 2, y - 2).piece.team == team && board.getTile(x - 3, y - 3).piece.team == team) {
                return true;
            }
            return false;
        } else return false;
    }

}
