
package EightPuzzle;
import java.util.*;
  /* will be used in each search algorithms
   * this class has datastructures such as queue, stack, and priority Queue in order to keep track of time, space and which
   *  nodes are in it and which are not
   */
public class DSTS {
    public Queue<BoardNode> queue; // this class has datastructures such as queue, stack, and priority Queue in order to keep track of time, space and which nodes are in the queue 
	public Stack<BoardNode> stack;
	public PriorityQueue<BoardNode> pQueue;
	public int time;
	private int maxsize;
	public HashMap<Integer,BoardNode> visited; 
    

public DSTS() {
    queue = new LinkedList<BoardNode>();
    stack = new Stack<BoardNode>();
    pQueue = new PriorityQueue<BoardNode>();
    time = 0;
    maxsize = 0;
    visited = new HashMap<Integer,BoardNode>();
}

    public void incTime() {  //timer method that begins timer
		time += 1;
	}
	
	public void queueSize() {   //queue size that constantly checks for maximum size, this will tell us the space
		if(queue.size()>maxsize) {
			maxsize = queue.size();
		}
	}
	
	public void stackSize() {   //behaves similar to queueSize() but for stack
		if(stack.size()>maxsize) {
			maxsize = stack.size();
		}
	}
	
	public void pQueueSize() {  //behaves similar to queueSize() but for priority queue
		if(pQueue.size()>maxsize) {
			maxsize = pQueue.size();
		}
	}
    
    
    public int getTime() { //time is returned
		return time;
	}
	
	public int getSpace() {  //space is returned
		return maxsize;
	}

	public void  makePQueue(Comparator c) {   //creates a prioirty queue with a comparator as an argument to decidee the order in which the queue will organize elements
		pQueue = new PriorityQueue<BoardNode>(c);
	}
}