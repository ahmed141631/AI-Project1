import java.util.Scanner;

import EightPuzzle.*;
public class Main {

    public static void main(String[] args) {
        int [][] puzzle = {
            {2,1,0},{3,4,5},{6,7,8}
        };

        System.out.println("Please chose an Algorithm below:");
		System.out.println();
		System.out.println();
		System.out.println("1. BFS");
		System.out.println();
		System.out.println("2. DFS");
		System.out.println();
		System.out.println("3. Astar");
        int choose=0;
        Scanner sc=new Scanner(System.in);
        choose=sc.nextInt();
        BoardNode root=new BoardNode(puzzle);
        search sear=null;
        switch (choose) {
            case 1:
                BFs bfs=new BFs(root);
                bfs.search();
                break;
            case 2:
            DFs dfs=new DFs(root);
            dfs.search();
            break;   
            case 3:
            System.out.println();
			System.out.println("This is the A* algorithm, please pick a heuristic: ");
			System.out.println();
			System.out.println("1. Manhattan ");
			System.out.println("2. Eculdian");
			System.out.println();
			int in = sc.nextInt();
            switch (in) {
                case 1:
                    sear=new Astar(root, 2);
                    break;
                case 2:
                sear=new Astar(root, 1);
                default:
                System.out.println("invalid");
                    break;
            }
              
               break; 
        
            default:
                System.out.println("invalid");
                break;
        }
      
    }
    
}