public class Tile {
    protected int x;
    protected int y;

    protected Piece piece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, Piece p) {
        this.x = x;
        this.y = y;
        piece = p;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public Piece getPiece(){return piece;}
    public Tile Clone() {
        return new Tile(x, y, piece);
    }
}
