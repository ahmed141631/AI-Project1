import java.util.LinkedList;


public class BFS {
    /* this method will return list of nodes that represent the path 
     * to the goal state
     */
    public LinkedList<Node> BreadthFirst(Node root){

        LinkedList<Node> pathToSol=new LinkedList<Node>();
        LinkedList<Node>queue=new LinkedList<Node>();
        LinkedList<Node>visited=new LinkedList<Node>();
        queue.add(root);
        boolean goal_found=false;
        while(!queue.isEmpty() && !goal_found){
            Node currentState=queue.poll();
            visited.add(currentState);
          

           
            //expand the node "neighbours of the current state "
            currentState.ExpandNode();
            

            for (int i = 0; i < currentState.children.size(); i++)
             {
        //search each state(child) of current state to check if it is goal state 
              Node currentchild=currentState.children.get(i);
              if(currentchild.goalTest()){
                 goal_found=true;
                // trace path to root state
                path(pathToSol, currentchild);
              }  
              //check if queue and visited contains current child
              if ( !contain(queue, currentchild)&& !contain(visited, currentchild)) {
                queue.add(currentchild);
              }
              
            }
        }
        return pathToSol;
    }
      public boolean contain(LinkedList<Node> list,Node c){
          boolean contain=false;
          for (int i = 0; i < list.size(); i++) {
            if(list.get(i).IS_samePuzzle(c.puzzle)){
              contain=true;
            }
            
          }
          return contain;
        }

            
         
  /* method to trace path to inital state  where n is the goal state*/
  public void path(LinkedList<Node>path,Node n){
      Node current=n;
      path.add(current);
      while (current.parent!=null) {
        current=current.parent;
        path.add(current);       
      }

  }      
    
}
