import java.util.LinkedList;
import java.util.Stack;
public class DFS {
    public LinkedList<Node>DepthFirst(Node root){
        LinkedList <Node> pathToGoal=new LinkedList<Node>();
        LinkedList <Node>visited=new LinkedList<>();
        Stack<Node>stack=new Stack<>();
        stack.add(root);
        boolean goal_found=false;
        while (!stack.isEmpty()&!goal_found) {
            Node currNode=stack.pop();
            visited.add(currNode);
            currNode.ExpandNode();
            for (int i = 0; i < currNode.children.size(); i++) {
                Node curchild=currNode.children.get(i);
                if(curchild.goalTest()){
                    goal_found=true;
                   // trace path to root state
                   path(pathToGoal, curchild);
                 }  
                 if ( !contain(stack, curchild)&&!contains(visited,curchild)) {
                   stack.add(curchild);
                 }

                
            }

          
            
     
        }
        return pathToGoal;
    }
    public boolean contains(LinkedList<Node>list,Node n){
        boolean contains=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).IS_samePuzzle(n.puzzle)){
                contains=true;
              }            
        }
        return contains;
    }

    public boolean contain(Stack<Node>stack,Node n){
        boolean contains=false;
        for (int i = 0; i < stack.size(); i++) {
            if(stack.get(i).IS_samePuzzle(n.puzzle)){
                contains=true;
              }            
        }
        return contains;
    }
    public void path(LinkedList<Node>path,Node n){
        Node current=n;
        //path.add(current);
        while (current.parent!=null) {
          current=current.parent;
          path.add(current);       
        }
  
    }   
}
