package com.es;


import org.junit.Test;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void testGetSquare() {
        for(int i=0; i < 64; ++i) {
            System.out.println(i + ": " + board.getPiece(i));
        }
    }

    @Test
    public void testPrintBoard() {
        board.printBoard();
    }
}
