package EightPuzzle;
import java.util.ArrayList;

import EightPuzzle.moves.MOVES;


public class Expand {
    /*
     * //successor function that takes a state and returns a
     *  list of possible states that can be reached
     */
    public ArrayList<BoardNode>successor(BoardNode node) {
		
    ArrayList<BoardNode> list=new ArrayList<>();
    int row=node.getzr();
    int col=node.getzc();
    //up
		
		if((col !=0 || col != 1 || col != 2) && (row !=0) ) {  //uses information about the nature of 2d arrays to dictate the zero movemnt. 
        BoardNode upNode = node.createchild(row-1, col);
        upNode.setMove(MOVES.UP);
        list.add(upNode);
    }   
    //down
		
		if((col !=0 || col != 1 || col != 2) && (row !=2) ) {
			BoardNode downNode = node.createchild(row+1, col);
			downNode.setMove(MOVES.DOWN);
			list.add(downNode);
		}    

        //right
		
		if((row != 0 || row != 1 || row != 2) && (col !=2)) {
			BoardNode rightNode = node.createchild(row, col+1);
			rightNode.setMove(MOVES.RIGHT);
			list.add(rightNode);
		}
		
		//left
		if((row != 0 || row != 1 || row != 2) && (col !=0)) {
			BoardNode leftNode = node.createchild(row, col-1); // a child is created if the zero tile can move left.
			leftNode.setMove(MOVES.LEFT);  
			list.add(leftNode);
		}
            return  list; //list of children is returned
    }
}
