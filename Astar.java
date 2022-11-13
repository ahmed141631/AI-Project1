package EightPuzzle;
import java.util.*;


/* create Astar search */
public class Astar implements search {
    private BoardNode initBoardNode;
    int i ; //this i value helps determine which heuristic will be used
    
    public Astar(BoardNode initBoardNode,int i){
        this.initBoardNode=initBoardNode;
        this.i=i;

    }
    public class f1Comparator implements Comparator<BoardNode>{  //comparator for ecludin heuristic that will be used in Priority Queue
		
		Huerstic h=new Huerstic();
		
		public int compare(BoardNode a, BoardNode b) {
			return (a.getMaxCost() + h.euclideanDistH(a)) - (b.getMaxCost()+h.euclideanDistH(b));
		}
	}
	

	public class f2Comparator implements Comparator<BoardNode>{			//comparator for manhattan heuristic and totalCost 
		
        Huerstic h=new Huerstic();
		
		public int compare(BoardNode a, BoardNode b) {
			return (a.getMaxCost() + h.manhattan(a)) - (b.getMaxCost()+h.manhattan(b));
		}
	}


    @Override
    public boolean search() {
        
       //Astar search which creates a priority queue which sorts according to h(n)
				DSTS ds=new DSTS();
				if(this.i==1) {
					ds.makePQueue(new f1Comparator());
				}
				else {
					ds.makePQueue(new f2Comparator());
				}
				 //making a priority queue with one of the heuristics determine the Comparator
				BoardNode node = initBoardNode;
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
					
					Expand s=new Expand(); // Successor class created to provide next possible moves from current node
					List<BoardNode> list = s.successor(node); // list of potential children
					
					for(BoardNode temp: list) {
						boolean ans = ds.visited.containsKey(temp.hashCode()); //Uses temporary node's hashCode to check if it has been expanded or not.
						if(ans==false) { //if it hasn't been expanded then we can now check if there is a node in the Priority Queue with a higher Cost
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
    
