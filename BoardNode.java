package EightPuzzle;

import java.util.ArrayList;

import EightPuzzle.moves.MOVES;

public class BoardNode {
  private  int [][]state=new int[3][3];
  private ArrayList<BoardNode>children;
  private BoardNode parent;
  private int zr; //zerorow
  private int zc; //zerocol
  private int cost;
  private int max_Cost;
  private String StringState;
  private int depth;
  private MOVES move;

  public BoardNode(int [][] state){
    this.state=state;
    this.depth=1;
    this.children=new ArrayList<BoardNode>();
    this.parent=null;
    this.cost=0;
    this.StringState=stringState();
    //determine the postion of the zero
    for (int i = 0; i <=2; i++) {
     for (int j = 0; j <=2; j++) {
        if(state[i][j]==0){
            zr=i;
            zc=j;
            break;
        }
        
     }   
    }

  }


  public String stringState(){
    StringBuilder sb=new StringBuilder();
    for ( int i = 0; i < state.length; i++) {
        for (int j = 0; j < state[i].length; j++) {
            sb.append(state[i][j]);
        }
    }
    return sb.toString();
  }

  public void setParent(BoardNode parent) { //setting the Parent of the node
    this.parent = parent;
}

public void setDepth(int depth) {  //setting the Depth of the node
    this.depth = depth;
}
public int getDepth() {  //getting the Depth of the node
    return depth;
}

public BoardNode getParent() {  //getting the Parent of the node
    return parent;
}

public int getzr() {  //getting the Row of the zero tile
    return zr;
}

public int getzc() { //getting the Column of the zero tile
    return zc;
}

public int [][] getstate(){ //getting the state in array form
    return state;
}
public int getCost() { //getting the cost of last move
    return this.cost;
}
public ArrayList<BoardNode> getChildren(){ //getting the children
    return children;
}
public void setChildren(ArrayList<BoardNode> childrens) { //setting the children
    this.children =  childrens;
}
public String getString() {			//getting String version of Board
    return StringState;
}

public void setCost(int i) {					//setting cost
    this.cost = i;
}
public void setMaxCost(int i) {
    this.max_Cost = this.getParent().getMaxCost() + i;			//setting MaxCost
}

public int getMaxCost() { //getting the current MaxCode to get to current Node
    return max_Cost;
}

public void addchild(BoardNode child){ //add child to the node
    child.setParent(this);
    child.setDepth(this.getDepth()+1);
    child.setMaxCost(child.getCost());
    this.children.add(child);
}

public boolean is_goal(){ //checking if node is goal node
    boolean result=false;
    int [][] goal={{0,1,2},{3,4,5},{6,7,8}};
    BoardNode goalNode=new BoardNode(goal);
    result=this.equals(goalNode);
    return result;
}

public int getRow(int value) {	//getting the Row of a value in goalState
    int row = 0;
    int [][] goal = {{0,1,2},{3,4,5},{6,7,8}};
    for(int i=0; i<=2; i++) {
        for(int j=0; j<=2; j++) {
            if(goal[i][j]==value) {
                row = i;
            }
        }
    }
        return row;
}

public int getCol(int value) {//getting the Column of value in goal state used for Manhattan computation
    int col = 0;
    int [][] goal = {{0,1,2},{3,4,5},{7,6,5}};
    for(int i=0; i<=2; i++) {
        for(int j=0; j<=2; j++) {
            if(goal[i][j]==value) {
                col = j;
            }
        }
    }
        return col;
}
    public BoardNode createchild(int a,int b){ // create possible state
        int temp[][] = new int[3][3];
        for(int i=0; i<state.length; i++){ // copy to temp
			  for(int j=0; j<state[i].length; j++){
			    temp[i][j]=state[i][j];
              }}
              temp[zr][zc] = temp[a][b];
              int cost = state[a][b]; //0
              temp[a][b]=0;
             BoardNode child = new BoardNode(temp);
		child.setCost(cost);
        addchild(child);
		return child;

    }
    @Override
	public boolean equals(Object object ) {    //equals for HashMap
		
		if(!(object instanceof BoardNode)) {
			return false;
		}
		BoardNode check = (BoardNode) object;
		
		return check.getString().equals(this.getString());
	}
    @Override
	public int hashCode() {			//Hashcode generated from String version of board
		int result = 17;
		result = 37 * result + this.getString().hashCode();
		return result;
	}

    public void setMove(MOVES m) {				//setting the  moveing whether left/right/..etc
		this.move = m;
	}
	public MOVES getMove() {				//getting the  moveing
		return move;
	}
}
