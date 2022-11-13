package EightPuzzle;
import java.util.*;

public class DFs implements search {

    private BoardNode initalBoardNode;
    public DFs(BoardNode iniBoardNode){
        this.initalBoardNode=iniBoardNode;
    }

    @Override
    public boolean search() {
        DSTS ds=new DSTS();
        BoardNode root=this.initalBoardNode;
        ds.stack.add(root);
        while(!(ds.stack.isEmpty())){
            root=ds.stack.pop();
            ds.incTime();
            ds.visited.put(root.hashCode(), root);
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
                    ds.stackSize();
                    
                   } 
        }
       
    }
    }


        return false;
    }

    
}
