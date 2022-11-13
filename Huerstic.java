package EightPuzzle;



public class Huerstic {
    /* this class will help us to define manhattan and ecludin 
     * distance 
     */

     public int manhattan(BoardNode node){
        int  goal[][]={{0,1,2},{3,4,5},{6,7,8}};
        int sum=0;
        int state[][]=node.getstate();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                int v=state[i][j];
                sum+=Math.abs(i-node.getRow(v)+Math.abs(j-node.getCol(v)));
            }
        } 
        return sum;
    }

    int euclideanDistH(BoardNode puzzle){
        //formula: square root --> ((a1-b1)^2 + (a2-b2)^2)
        int sum = 0 ;
        int  goal[][]={{0,1,2},{3,4,5},{6,7,8}};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(puzzle.getstate()[i][j] == 0){
                    continue;
                }
                if(puzzle.getstate()[i][j] != goal[i][j]){
                    int n=0;
                    int m=0;
    
                    for(int y=0;y<3;y++){
                        for(int z=0;z<3;z++){
                            if(goal[y][z] == puzzle.getstate()[i][j]){
                                n = y;
                                m = z;
                            }
                        }
                    }
                    n = (int)Math.pow(n-m,2);
                    m =(int)Math.pow(i-j,2);
                    while(n != 0 || m != 0){
                        if(n<0){
                            sum++;
                            n++;
                        }
                        if(n>0){
                            sum++;
                            n--;
                        }
                        if(m<0){
                            sum++;
                            m++;
                        }
                        if(m>0){
                            sum++;
                            m--;
                        }
                    }
                    
                }
            }
        }
        return sum;
    }
}

