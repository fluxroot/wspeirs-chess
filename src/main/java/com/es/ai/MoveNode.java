package com.es.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.es.Board;

public class MoveNode {

    private static final Logger LOG = LoggerFactory.getLogger(MoveNode.class);

    private static final MoveNodeComparitor increasingComparitor = new MoveNodeComparitor(true);
    private static final MoveNodeComparitor decreasingComparitor = new MoveNodeComparitor(false);

    private final Board board;
    private final int[] move;
    private int score;
    private int retVal;
    private int depth;
    private MoveNode parent;
    private List<MoveNode> children = new ArrayList<MoveNode>();
    private boolean isSorted = false;

    public MoveNode(Board board, MoveNode parent, int[] move) {
        this.board = board;
        this.move = move;
        this.parent = parent;
    }

    public MoveNode getParent() {
        return parent;
    }

    public Board getBoard() {
        return board;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRetVal() {
        return retVal;
    }

    public void setRetVal(int retVal) {
        this.retVal = retVal;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int[] getMove() {
        return move;
    }

    public int getChildCount() {
        return children.size();
    }

    public MoveNode getFirstChild() {
        return children.get(0);
    }

    public MoveNode getBestChild() {
        if(!isSorted) {
            Collections.sort(children, increasingComparitor);
        }

        return children.get(0);
    }

    public MoveNode getWorstChild() {
        if(!isSorted) {
            Collections.sort(children, decreasingComparitor);
        }

        return children.get(0);
    }

    public void addChild(MoveNode node) {
        isSorted = false;
        children.add(node);
    }
    
    public int[] getChildrenPieces() {
        int[] ret = new int[children.size()];
        int i =0;
        
        for(MoveNode child:children) {
            ret[i++] = child.getMove()[0];
        }
        
        return ret;
    }

    public void printChildren() {
        Iterator<MoveNode> it = children.iterator();

        while(it.hasNext()) {
            MoveNode curNode = it.next();
            int[] move = curNode.getMove();

            System.out.println(curNode.getScore() + ": " + Integer.toHexString(move[0]) + " -> " + Integer.toHexString(move[1]));
        }
    }

    public int getNodeCount() {
        return getNodeCount(0, this.depth);
    }

    private int getNodeCount(int count, int depth) {
        for(MoveNode c:children) {
            // only recurse if it's not a transposition
            if(c.depth > depth) {
                continue;
            }

            count = c.getNodeCount(count, depth-1);
        }

        return count + 1;
    }

    private static class MoveNodeComparitor implements Comparator<MoveNode> {

        private boolean increasing;

        public MoveNodeComparitor(boolean increasing) {
            this.increasing = increasing;
        }

        public int compare(MoveNode node1, MoveNode node2) {
            if(increasing) {
                return (node2.score < node1.score) ? -1 : ((node2.score > node1.score) ? 1 : 0);
            } else {
                return (node1.score < node2.score) ? -1 : ((node1.score > node2.score) ? 1 : 0);
            }
        }
    }
}
