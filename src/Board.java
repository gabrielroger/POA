import java.util.Vector;

public class Board {

    protected int length;
    protected int height;

    protected Vector<Tile> tiles;

    public Board(int length, int height) {
        this.length = length;
        this.height = height;
        initTiles();
    }
    public Board(Board b) {
        this.length = b.getLength();
        this.height = b.getHeight();
        this.tiles = new Vector<>();
        for (int i = 0; i < length * height; i++) {
            tiles.add(b.getTiles().get(i).Clone());
        }
    }

    Board(int[][] board) {
        this.length = board.length;
        this.height = board[0].length;
        initTiles();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == -1) {
                    tiles.set(i + j*length, new Tile(i,j));
                } else tiles.set(i + j*length, new Tile(i,j, new Piece(board[i][j])));
            }
        }
    }

    protected void initTiles() {
        this.tiles = new Vector<>();
        for (int i = 0; i < length*height; i++) {
            Tile t = new Tile(i%length, i/length);
            tiles.add(t);
        }
    }

    public Tile getTile(int x, int y) {
        if (x < length && y < height) {
            return tiles.elementAt(x + y*length);
        } else return null;
    }

    public Vector<Tile> getTiles(){return tiles;}
    public int getLength() {return length;}
    public int getHeight() {return height;}

    public int[][] serialize() {
        int[][] ret = new int[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (tiles.elementAt(i + j*length).piece == null) {
                    ret[i][j] = -1;
                } else ret[i][j] = tiles.elementAt(i + j*length).piece.team;
            }
        }
        return ret;
    }

    public static Board deserialize(int[][] serializedBoard) {
        return new Board(serializedBoard);
    }
}
