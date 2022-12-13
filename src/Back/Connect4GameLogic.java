package Back;

public class Connect4GameLogic {

    public static boolean testMoveWin(int column, Connect4Board board) {
        return testTileWin(column,board.getColumnHeight(column) - 1, board);
    }

    public static boolean testTileWin(int x, int y, Connect4Board board) {
        if (x >= 0 && x < board.length && y >= 0 && y < board.length) {
            int team = board.getTile(x, y);
            if (y <= board.height - 4 && board.getTile(x, y + 1) == team && board.getTile(x, y + 2) == team && board.getTile(x, y + 3) == team) {
                return true;
            }
            if (x < board.length - 4 && y <= board.height - 4 && board.getTile(x + 1, y + 1) == team && board.getTile(x + 2, y + 2) == team && board.getTile(x + 3, y + 3) == team) {
                return true;
            }
            if (x < board.length - 4 && board.getTile(x + 1, y) == team && board.getTile(x + 2, y) == team && board.getTile(x + 3, y) == team) {
                return true;
            }
            if (x < board.length - 4 && y >= 3 && board.getTile(x + 1, y - 1) == team && board.getTile(x + 2, y - 2) == team && board.getTile(x + 3, y - 3) == team) {
            return true;
            }
            if (y >= 3 && board.getTile(x, y - 1) == team && board.getTile(x, y - 2) == team && board.getTile(x, y - 3) == team) {
            return true;
            }
            if (x >= 3 && y <= board.height - 4 && board.getTile(x - 1, y + 1) == team && board.getTile(x - 2, y + 2) == team && board.getTile(x - 3, y + 3) == team) {
                return true;
            }
            if (x >= 3 && board.getTile(x - 1, y) == team && board.getTile(x - 2, y) == team && board.getTile(x - 3, y) == team) {
            return true;
            }
            if (x >= 3 && y >= 3 && board.getTile(x - 1, y - 1) == team && board.getTile(x - 2, y - 2) == team && board.getTile(x - 3, y - 3) == team) {
                return true;
            }

            return false;
        }
        return false;
    }

}
