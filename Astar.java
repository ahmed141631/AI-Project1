package EightPuzzle;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * to perform A* Algorithms
 */
public class Astar implements search {
	private BoardNode initBoardNode;
	private int i; // to determine which heuristic to use
	public Astar(BoardNode initBoardNode,int i){
		this.initBoardNode=initBoardNode;
		this.i=i;

	}
	private class MComparator implements Comparator<BoardNode>{			//comparator for manhattan heuristic and totalCost 
		
		Huerstic h = new Huerstic();
		
		public int compare(BoardNode a, BoardNode b) {
			return (a.getMaxCost() + h.ManhattanDistance(a)) - (b.getMaxCost()+h.ManhattanDistance(b));
		}
	}
	private class EComparator implements Comparator<BoardNode>{			//comparator for manhattan heuristic and totalCost 
		
		Huerstic h = new Huerstic();
		
		public int compare(BoardNode a, BoardNode b) {
			return (a.getMaxCost() + h.EuclideanDistance(a)) - (b.getMaxCost()+h.EuclideanDistance(b));
		}
	}
	@Override
	public boolean search() {
		DSTS ds=new DSTS();
		if(this.i==1){
			ds.makePQueue( new MComparator());
		}
		else{
			ds.makePQueue(new EComparator());
		}
		BoardNode node = this.initBoardNode;
		ds.pQueue.add(node);
		while(!(ds.pQueue.isEmpty())) {
			node = ds.pQueue.poll();
			ds.incTime();
			ds.visited.put(node.hashCode(), node);
			if(node.is_goal()) {
				Path p = new Path(initBoardNode,node,ds); // class that creates a path from goal to start Node if goal is reached.
				p.printPath(); // the path is then printed
				return true;
			}
			Expand s = new Expand(); // EXpand class created to provide next possible moves from current node
					ArrayList<BoardNode> list = s.successor(node); // list of potential children
					
					for(BoardNode temp: list) {
						boolean answer = ds.visited.containsKey(temp.hashCode()); //Uses temporary node's hashCode to check if it has been expanded or not.
						if(answer==false) { //if it hasn't been expanded then we can now check if there is a node in the Priority Queue with a higher Cost
							if(!(ds.pQueue.contains(temp))){
								ds.pQueue.add(temp);
								ds.pQueueSize();
							}
		}
	}
}

		return false;
	}

	
}
    
