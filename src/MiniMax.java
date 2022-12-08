
public class MiniMax {
    public static int MAX_DEPTH=4;

    public static int AlphaBetaSearch(State state) {
        Pair mv=null;

        if(state.getCouleur()==1)
            mv=MaxValue(state,Integer.MIN_VALUE,Integer.MAX_VALUE,MAX_DEPTH);
        else
            mv=MinValue(state,Integer.MIN_VALUE,Integer.MAX_VALUE,MAX_DEPTH);

        return mv.getMove();
    }

    public static Pair MaxValue(State state,int alpha, int beta,int depth) {
        if( state.TerminalTest() || depth==0 )
            return new Pair(state.getMove(),state.Utility());

        int v=Integer.MIN_VALUE;
        int bestmove=0;
        int bestscore;

        state.setSuccessors();
        for(State s : state.getSuccessors()) {

            bestscore=MinValue(s,alpha,beta,depth-1).getScore();

            if(v<bestscore) {
                v=bestscore;
                bestmove=s.getMove();
            }
            if(v >= beta )
                return new Pair(bestmove,v);

            alpha=Math.max(alpha, v);
        }
        return new Pair(bestmove,v);
    }

    public static Pair MinValue(State state,int alpha,int beta,int depth) {

        if(state.TerminalTest() || depth==0)
            return new Pair(state.getMove(),state.Utility());


        int v=Integer.MAX_VALUE;
        int bestmove=0;
        int bestscore;

        state.setSuccessors();
        for(State s : state.getSuccessors()) {
            bestscore=MaxValue(s,alpha,beta,depth-1).getScore();

            if(v>bestscore) {
                v=bestscore;
                bestmove=s.getMove();
            }
            if(v <= alpha )
                return new Pair(bestmove,v);

            beta=Math.min(beta, v);
        }
        return new Pair(bestmove,v);
    }
}

