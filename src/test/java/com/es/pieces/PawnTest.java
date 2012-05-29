package com.es.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.es.Board;

public class PawnTest {

    private Board board = new Board();

    @Test
    public void testGenerateAllMoves() {
        Pawn p = (Pawn) board.getPiece(1, 1);

        int[] moves = p.generateAllMoves();

        assertEquals(17, moves[0]);
        assertEquals(25, moves[1]);

        for(int i=2; i < moves.length; ++i) {
            assertEquals(Board.MAX_SQUARE, moves[i]);
        }
    }

}