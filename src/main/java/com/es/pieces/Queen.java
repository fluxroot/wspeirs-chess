package com.es.pieces;

import java.util.Arrays;

import com.es.Board;

public class Queen extends AbstractPiece {

    public Queen(Color color, Board board, int currentPosition) {
        super(color, board, currentPosition);
    }

    public String toString() {
        if(getColor().equals(Color.BLACK)) {
            return "q";
        } else {
            return "Q";
        }
    }

    public int[] getAllMoves() {
        final int pos = getCurPos();
        int[] ret = new int[27]; // can only move in 27 places
        int curPos = 0;

        for(int i = pos; addPos(ret, curPos++, i); i += 9); // move to upper-right
        for(int i = pos; addPos(ret, curPos++, i); i -= 9); // move to lower-left
        for(int i = pos; addPos(ret, curPos++, i); i += 7); // move to upper-left
        for(int i = pos; addPos(ret, curPos++, i); i -= 7); // move to lower-right

        for(int i = pos; addPos(ret, curPos++, i); i += 8); // move forward
        for(int i = pos; addPos(ret, curPos++, i); i -= 8); // move backward
        for(int i = pos; addPos(ret, curPos++, i); i += 1); // move right
        for(int i = pos; addPos(ret, curPos++, i); i -= 1); // move left

        Arrays.fill(ret, -1, curPos, ret.length);   // fill the rest with -1
        Arrays.sort(ret);   // sort the array

        return ret;
    }
}
