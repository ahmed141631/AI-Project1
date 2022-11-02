import java.util.LinkedList;

/**
 * Node class to represent 
 * each state of the problem
 */
public class Node {
    /* to represent the board */
    public int[] puzzle=new int[9];
    /*  to represent nodes that go from the inital 
    state by taking actions(left,right,up,down) */
    public LinkedList<Node> children=new LinkedList<Node>();
    /* when we will find goal state we need to track back our way to inital states by tracking 
    the  of each state*/
    public Node parent;
    public int x=0;
    public int col=3;

    public Node(int []p){
        setpuzzle(p);
    }
    //we are copying the inital state that user enter to puzzle
    public void setpuzzle(int []p){
        for (int i = 0; i < puzzle.length; i++) {
            this.puzzle[i]=p[i];
        }
    }
    public boolean goalTest(){
        boolean is_goal=true;
        int m=this.puzzle[0];
        for (int i = 1; i < puzzle.length; i++) {
            if(m>puzzle[i]){
                is_goal=false;
                m=puzzle[i];
            }
        }
        return is_goal;
    }
    // we now need to expand the board by run actions in it 
    public void MoveRight(int []p,int i){
        if(i%col<col-1){
            int psol[]=new int[9];
            copyPuzzle(psol, p);
            //swap step
            int temp=psol[i+1];
             psol[i+1]=psol[i];
             psol[i]=temp;
            Node child=new Node(psol);
            children.add(child);
            child.parent=this;
        }
    }
    public void MoveLeft(int []p,int i){
        if (i % col> 0){
            int psol[]=new int[9];
            copyPuzzle(psol, p);
            //swap step
            int temp=psol[i-1];
             psol[i-1]=psol[i];
             psol[i]=temp;
            Node child=new Node(psol);
            children.add(child);
            child.parent=this;
        }
    }
    public void MoveUp(int []p,int i){
        if(i-col>=0){
            int psol[]=new int[9];
            copyPuzzle(psol, p);
            //swap step
            int temp=psol[i-3];
             psol[i-3]=psol[i];
             psol[i]=temp;
            Node child=new Node(psol);
            children.add(child);
            child.parent=this;
        }
    }
    public void MoveDown(int []p,int i){
        if(i+col<puzzle.length){
            int psol[]=new int[9];
            copyPuzzle(psol, p);
            //swap step
            int temp=psol[i+3];
             psol[i+3]=psol[i];
             psol[i]=temp;
            Node child=new Node(psol);
            children.add(child);
            child.parent=this;
        }
    }
    public void copyPuzzle(int[] a,int [] b){
        for (int i = 0; i < b.length; i++) {
            a[i]=b[i];
        }
   
    }
    public void print() {
        int m=0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(puzzle[m]+" ");
                    m++;
            }  
            System.out.println(); 
        }
    }
    public boolean IS_samePuzzle(int []p){
        // to check if the current state ,we already have in chlidren list we won't put it agin
        boolean samePuzzle=true;
        for (int i = 0; i < p.length; i++) {
         if(puzzle[i]!=p[i]){
            samePuzzle=false;
         }   
        }
        return samePuzzle;
    } 

    public void ExpandMove(){
        for (int i = 0; i < puzzle.length; i++) {
            if(puzzle[i]==0){
                x=i;
            }
            MoveRight(puzzle, x);
            MoveLeft(puzzle, x);
            MoveUp(puzzle, x);
            MoveDown(puzzle, x);
        }
    }
}
