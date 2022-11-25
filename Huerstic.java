package EightPuzzle;

/**
 * to perform ManhattanDistance Huerstic and EuclideanDistance
 */
public class Huerstic {
/*h = abs(current cell:x - goal:x) +
   abs(current cell:y - goal:y) */
    public int ManhattanDistance(BoardNode node){
        int[][]Goal={{0,1,2},{3,4,5},{6,7,8}};
        int result=0;
        int [][] state=node.getstate();
        for (int i = 0; i < Goal.length; i++) {
            for (int j = 0; j < Goal.length; j++) {
                int value=state[i][j];
                result+=Math.abs(i-node.getRow(value))+Math.abs(j-node.getCol(value));
            }

        }
        return result;
    }
    public int EuclideanDistance(BoardNode node){
        /* */
        int[][]Goal={{0,1,2},{3,4,5},{6,7,8}};
        int result=0;
        int [][] state=node.getstate();
        for (int i = 0; i < Goal.length; i++) {
            for (int j = 0; j < Goal.length; j++) {
                int value=state[i][j];
                result+=Math.sqrt((i-node.getRow(value))^2)+Math.sqrt((j-node.getCol(value))^2);
            }

        }
        return result;    }
}
