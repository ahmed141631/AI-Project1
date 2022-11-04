import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int []puzzle={
            1,2,4,
            3,0,5,
            7,6,8
        };
        Node InitalState=new Node(puzzle);
        BFS BfsTraversal=new BFS(); 
        LinkedList <Node> list=BfsTraversal.BreadthFirst(InitalState);

        if(list.size()>0){
            int size=list.size();
            for (int i = 0; i <size ; i++) {
                list.get(i).print();
                System.out.println();
            }
        }
        else{
            System.out.println("no path to goal");
            System.exit(0);
        }
    }
    
}
