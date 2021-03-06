package com.es;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.Before;

import com.es.ai.search.AlphaBetaAI;
import com.es.pieces.Piece.Color;

public class AlphaBetaAITest {

    Board board = new Board();
    //WorkingAlphaBetaAI workingAB = new WorkingAlphaBetaAI(Color.WHITE, board);
    BaseConfiguration defaults = new BaseConfiguration();
    AlphaBetaAI alphaBeta = new AlphaBetaAI(Color.WHITE, board);

    static final int DEPTH = 4;

    @Before
    public void setup() {
        defaults.addProperty(CmdConfiguration.DEPTH, DEPTH);
        LogManager.getRootLogger().setLevel(Level.DEBUG);
    }

    public void setupBoard() throws IllegalMoveException {
        board = new Board();
//        board.clearBoard();

//        board.makeMove(0x13, 0x33);
/*
        board.addPiece(new Pawn(Color.BLACK), 0x63);
        board.addPiece(new Pawn(Color.BLACK), 0x64);
        board.addPiece(new Queen(Color.BLACK), 0x73);

        board.addPiece(new Pawn(Color.WHITE), 0x13);
//        board.addPiece(new Pawn(Color.WHITE), 0x14);
        board.addPiece(new Queen(Color.WHITE), 0x03);
*/
    }

/*
    @Test
    public void test() throws Exception {
        setupBoard();
        MoveNode alphaBetaNode = new MoveNode(null, Board.MAX_SQUARE);

        long start = System.currentTimeMillis();
        int ret = alphaBeta.computeNextMove(alphaBetaNode, Color.WHITE);
        alphaBetaNode.getBestChild();
        long time = System.currentTimeMillis() - start;

        System.out.println(alphaBetaNode.childrenToString());
    }
*/
/*
    @Test
    public void testAlphabeta() throws IllegalMoveException {
        long start, time;
        int ret;
        String from, to;

        //
        // setup alpha-beta
        //
        setupBoard();
        MoveNode workingAlphaBetaNode = new MoveNode(board, null, new int[] { Board.MAX_SQUARE, Board.MAX_SQUARE });

        start = System.currentTimeMillis();
        ret = workingAB.alphabeta(workingAlphaBetaNode, DEPTH, -1000000, 10000000, Color.WHITE);
        workingAlphaBetaNode.getBestChild();
        time = System.currentTimeMillis() - start;

        System.out.println("RET: " + ret + " TRANS HIT: " + workingAB.getTransHit());

        from = Integer.toHexString(workingAlphaBetaNode.getBestChild().getMove()[0]);
        to = Integer.toHexString(workingAlphaBetaNode.getBestChild().getMove()[1]);

        System.out.println("MOVE: " + from + " -> " + to);
        //
        // print the results
        //
        System.out.println("* WORKING ALPHA BETA: " + time + " " + workingAlphaBetaNode.getNodeCount());
        System.out.println(workingAlphaBetaNode.childrenToString());
        printMoves(workingAlphaBetaNode.getBestChild());
        System.out.println();

        //
        // setup alpha-beta
        //
        setupBoard();
        MoveNode alphaBetaNode = new MoveNode(board, null, new int[] { Board.MAX_SQUARE, Board.MAX_SQUARE });

        start = System.currentTimeMillis();
        ret = alphaBeta.alphabeta(alphaBetaNode, DEPTH, -1000000, 10000000, Color.WHITE);
        alphaBetaNode.getBestChild();
        time = System.currentTimeMillis() - start;

        System.out.println("RET: " + ret + " TRANS HIT: " + alphaBeta.getTransHit());

        from = Integer.toHexString(alphaBetaNode.getBestChild().getMove()[0]);
        to = Integer.toHexString(alphaBetaNode.getBestChild().getMove()[1]);

        System.out.println("MOVE: " + from + " -> " + to);
        //
        // print the results
        //
        System.out.println("* ALPHA BETA: " + time + " " + alphaBetaNode.getNodeCount());
        System.out.println(alphaBetaNode.childrenToString());
        printMoves(alphaBetaNode.getBestChild());
        System.out.println();
    }

    public void printMoves(MoveNode node) {
        while(true) {
            System.out.println(node.getBoard().toString());
            System.out.println("SCORE: " + alphaBeta.computeScore(node) + " DEPTH: " + node.getDepth());

            if(node.getChildCount() == 0)
                break;
            node = node.getFirstChild();
            System.out.println();
        }
    }
*/
}
