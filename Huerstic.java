package EightPuzzle;

/**
 * to perform ManhattanDistance Huerstic and EuclideanDistance
 */
public class Huerstic {
    private int hn;
    private int gn;
    private int fn;
  

    public Huerstic(){
       
        fn=0;
        gn=0;
    }
    public int getHn(){
		return hn;
	}
    public void setGn(int g){
		gn = g;
	}
    public int getGn(){
		return gn;
	}
    public void setFCost(){
		fn = gn+hn;
	}
    public void setFCost(int fc){
		fn = fc;
	}
    public int getFCost(){
		return fn;
	}


public int ManhattanDistance(BoardNode node){
    hn=0;
   
    int state[][]=node.getstate();
    int goal[][]={{0,1,2},{3,4,5},{6,7,8}};
    int x1,x2=0;
   int  y1,y2=0;
    
    //convert current and goal into a 2D array for easier calculation
		for(int i=0; i<state.length; i++){
            
			for(int j=0; j<state[0].length; j++){
               
				int value=state[i][j];
                //state values
                 x1=i;
                
                 y1=j;
                
                
                //find the goal coordinates
				for(int l=0; l<goal.length; l++){
					for(int m=0; m<goal[0].length; m++){
						int goalValue = goal[l][m];
						if(value==goalValue){
							x2=l;
							y2=m;
                           
							break;
						}
					}
                     
				}
                hn +=  Math.abs(x1-x2) + Math.abs(y1-y2); 
			}
            
	    }
    return hn;
}
public int EuclideanDistance(BoardNode node){ 
    hn=0;
   
    int state[][]=node.getstate();
    int goal[][]={{0,1,2},{3,4,5},{6,7,8}};
    int x1,x2=0;
   int  y1,y2=0;
    
    //convert current and goal into a 2D array for easier calculation
		for(int i=0; i<state.length; i++){
            
			for(int j=0; j<state[0].length; j++){
               
				int value=state[i][j];
                //state values
                 x1=i;
                
                 y1=j;
                
                
                //find the goal coordinates
				for(int l=0; l<goal.length; l++){
					for(int m=0; m<goal[0].length; m++){
						int goalValue = goal[l][m];
						if(value==goalValue){
							x2=l;
							y2=m;
                           
							break;
						}
					}
                     
				}
                hn +=  Math.sqrt((x1-x2)^2) + Math.sqrt((y1-y2)^2); 
			}
            
	    }
    return hn;
}
}
