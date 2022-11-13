package EightPuzzle;

import java.util.ArrayList;

public class BFs implements search {

    private BoardNode initalBoardNode;
    public BFs(BoardNode iniBoardNode){
        this.initalBoardNode=iniBoardNode;
    }

    @Override
    public boolean search() {
        DSTS ds=new DSTS(); // class that has queue and hashmap

        BoardNode root=this.initalBoardNode;
        ds.queue.add(root); // add root to queue 
        while (!ds.queue.isEmpty()) {
           root= ds.queue.remove();
           ds.incTime();
           ds.visited.put(root.hashCode(), root); //place root in visited hashmap
            if(root.is_goal()){ // if goal is found path is create and will print 
                Path p=new Path(initalBoardNode, root, ds);
                p.printPath();
                return true;
            }
            // else we will expand the root
            Expand expand=new Expand();
            ArrayList<BoardNode> al=new ArrayList<>();
            al=expand.successor(root);
            for(BoardNode temp: al){
                boolean check = ds.visited.containsKey(temp.hashCode());
                if(check==false){
                   if(!ds.queue.contains(temp)){
                    ds.queue.add(temp);
                    ds.queueSize();
                    
                   }
                   Path p=new Path(initalBoardNode,temp, ds);
            p.printPath(); 
                }
            }
            
        }
      
        return false;
    }

    
}
