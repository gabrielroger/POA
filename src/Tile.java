public class Tile {
    protected int x;
    protected int y;

    protected Piece piece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public Tile Clone() {
        return new Tile(x, y, piece);
    }
}
