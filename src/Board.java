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
}
