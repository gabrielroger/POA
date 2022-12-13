package Back;

import java.util.Arrays;

public class Connect4Board extends Board {

    Connect4Board(int length, int height)   {
        super(length, height);
    }

    Connect4Board(Connect4Board connect4Board)   {
        super(connect4Board);
    }
    public int getColumnHeight(int column) {
        if (column >= 0 && column < length) {
            for (int i = 0; i < tiles[column].length ; i++) {
                if (tiles[column][i] == -1) {
                    return i;
                }
            }
            return -1;
        } else return -2;
    }

    boolean addPiece(int column, int team) {
        int columnHeight = getColumnHeight(column);
        if (column >= 0 && column < length) {
            if (columnHeight > -1 && columnHeight < height) {
                tiles[column][columnHeight] = team;
                return true;
            } else return false;
        } else throw new IndexOutOfBoundsException();
    }

    public int[][] serialize() {
        int[][] ret = tiles.clone();
        /*
        for (int[] c : tiles) {
            for (int i = 0; i <= c.length/2; i++) {
                int temp = c[i];
                c[i] = c[c.length - i - 1];
                c[c.length - i - 1] = temp;
            }
        }
        */
        return ret;
    }
}
