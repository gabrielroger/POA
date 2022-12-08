import java.util.Vector;

public class Board {

    public int length;
    public int height;

    public Vector<Tile> tiles;

    public Board(int length, int height) {
        this.length = length;
        this.height = height;
        this.tiles = new Vector<>(length*height);
    }

    public Tile getTile(int x, int y) {
        if (x < length && y < height) {
            return tiles.elementAt(x + y*length);
        } else return null;
    }
}
