import java.util.*;
public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    public int[][]board;
    
    public String name(){
	return "rivera.michael";
    }
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    /** Same constructor as before...*/
    public Maze(String filename){
	
    }
    
    public void wait(int millis){
	try{
	    Thread.sleep(millis);
	}catch (InterruptedException e){
	}
    }
    
    public String toString(){
	String ans = "\n";
	for(int i = 0; i < board.length * board.length; i++){
	    if(i % board.length == 0){
		ans += "\n";
	    }
	    int c = board[i / board.length][i % board.length];
	    if(c<100){
		ans += " ";
	    }
	    if(c<10){
		ans += " ";
	    }
	    ans += c;
	}
	return ans;
    }
    
    public String toString(boolean animate){
	if(animate){
	    String ans = "\n";
	    for(int i = 0; i < board.length * board.length; i++){
		if(i % board.length == 0){
		    ans += "\n";
		}
		int c = board[i / board.length][i % board.length];
		if(c<100){
		    ans += " ";
		}
		if(c<10){
		    ans += " ";
		}
		ans += c;
	    }
	    return hide + clear + go(0,0) + ans + "\n" + show;
	    
	}else{
	    return toString();
	}
    }
    
    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){
	
    }
}