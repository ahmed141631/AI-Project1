package EightPuzzle;

import java.util.ArrayList;
import java.util.Arrays;

/* this class provides an object that is used 
  to trace back the path from the goal  ,then it print  the path*/

public class Path {
    ArrayList <BoardNode>path;
    DSTS info; // to get the time and space details

    public Path(BoardNode initialNode, BoardNode goalNode, DSTS inf) {  //the arguments are goalNode, info and intialNode so a path can be found.
		path = this.getPath(initialNode, goalNode);
		this.info = inf;
	}

    public ArrayList<BoardNode> getPath(BoardNode initialNode, BoardNode goalNode) {  //given a goalNode and initialNode this method uses node's parents to trace it's way back up
    ArrayList<BoardNode> list = new ArrayList<BoardNode>();
    BoardNode tempNode=goalNode;
		
    while(!(tempNode.equals(initialNode))) {
        list.add(tempNode);
        tempNode = tempNode.getParent();
        
    }
    list.add(initialNode);
    return list;  // a list of the path is returned in reverse order
}

public void printPath() {   //this method enables us to print the path in correct order from start node to goal node with sufficient details. 
    int size = path.size();

    for(int i= size-1;i>=0;i--) {
        System.out.println();
        System.out.println();
        System.out.println("Direction Moved: " + path.get(i).getMove());
        System.out.println("Depth: " + path.get(i).getDepth());
        System.out.println("Cost: " + path.get(i).getCost());

        System.out.println();
        System.out.println("Current Node: \n");
        System.out.println(Arrays.deepToString(path.get(i).getstate()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println();
    }
    System.out.println("Time: " + info.getTime());
    System.out.println("ExpandedNodes " + info.getSpace());
}


    
}
