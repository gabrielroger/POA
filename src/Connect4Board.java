public class Connect4Board extends Board {

    Connect4Board(int length, int height)   {
        super(length, height);
    }

    public int getColumnHeight(int column) {
        if (column > 0 && column < length) {
            int i = 0;
            while (tiles.elementAt(column + i*length).piece != null) {
                ++i;
            }
            if (i >= height) {
                return -1;
            }
            return i;
        } else return -1;
    }

    boolean addPiece(int column, int team) {
        int columnHeight = getColumnHeight(column);
        if (column > 0 && column < length && columnHeight != -1 && columnHeight < height-1) {
            tiles.elementAt(column + length*columnHeight+1).piece = new Piece(team);
            return true;
        } else return false;
    }
}
