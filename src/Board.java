import java.util.Vector;

public class Board {

    protected int length;
    protected int height;

    protected Vector<Tile> tiles;

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

    public int getLength() {return length;}
    public int getHeight() {return height;}
}
