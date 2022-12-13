package Back;

import java.util.Vector;

public class Board {

    protected int length;
    protected int height;

    int[][] tiles;

    public Board(int length, int height) {
        this.length = length;
        this.height = height;
        initTiles();
    }
    public Board(Board b) {
        this.length = b.getLength();
        this.height = b.getHeight();
        this.tiles = new int[length][height];
        for (int i = 0; i < length; i++) {
            tiles[i] = b.tiles[i].clone();
        }
    }

    Board(int[][] board) {
        this.length = board.length;
        this.height = board[0].length;
        this.tiles = board;
    }

    protected void initTiles() {
        this.tiles = new int[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = -1;
            }
        }
    }

    public int getTile(int x, int y) {
        if (x < length && y < height) {
            return tiles[x][y];
        } else return -1;
    }

    public int[][] getTiles(){return tiles;}
    public int getLength() {return length;}
    public int getHeight() {return height;}

    public int[][] serialize() {
        return tiles;
    }

    public static Board deserialize(int[][] serializedBoard) {
        return new Board(serializedBoard);
    }
}
