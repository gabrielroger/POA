package Back;

import java.util.ArrayList;


public class State {

    private Connect4Board board;
    private int score;
    private int move;
    private ArrayList<State> successors=new ArrayList<>();
    private int couleur;

    public State(Connect4Board board,int couleur,int move) {
        this.board=board;
        this.couleur=couleur;
        this.move=move;
    }

    public boolean TerminalTest() {
        return Connect4GameLogic.testMoveWin(move, board);
    }

    public int Utility() {

        if(TerminalTest()) {
            //victoire noire
            if (couleur == 1)
                return -1000;
            //victoire blanc
            else
                return 1000;
        }
        return 0;
    }

    public void setScore(int u) {
        score=u;
    }

    public int getMove() {
        return move;
    }


    public ArrayList<State> getSuccessors() {
        return successors;
    }

    public int getScore() {
        return score;
    }

    public void setSuccessors() {
        for(int j=0;j<board.getLength();j++) {
            if(board.getColumnHeight(j)>0) {
                Connect4Board b= new Connect4Board(board);
                b.addPiece(j, couleur);
                State s= new State(b,Math.abs(couleur-1),j);
                successors.add(s);
            }
        }
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Connect4Board board) {
        this.board = board;
    }

}
