import java.util.*;
import java.io.*;
public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    public char[][]board;
    public int x,y;
    public int[] solutionb;


    public String name(){
	return "rivera.michael";
    }
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    /** Same constructor as before...*/
    public Maze(String filename){
	try{
	    File file = new File(filename);
	    Scanner q = new Scanner(file);
	    for(int i = 0; q.hasNextLine();i++){
		board[i] = q.nextLine().toCharArray();
	    }
	}catch (FileNotFoundException e){
	    System.err.println("FileNotFoundException: " + e.getMessage());
	}
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
    public boolean solveBFS(boolean animate){
	return solve(animate,true);
    }
    

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){ 
	return solve(animate,false);
    }

    public boolean solve(boolean animate,boolean bfs){
	MyDeque<LNode<Integer>> Frontier = new MyDeque(board.length * board[0].length);
	LNode<Integer> current;
	int c = 0;
	for(int i = 0; i < board.length;i++){
	    for(int j= 0; j < board[0].length;j++){
		if(board[i][j] == 'S'){
		    current = new LNode<Integer>();
		    current.setxy(j,i);
		    c++;
		    break;
		}
	    }
	}
	x,y = 1;
	while(Frontier.size() != 0){
	    if(bfs){
		current = Frontier.removeFirst();
	    }else{
		current = Frontier.removeLast();
	    }
	    current.getX() = x;
	    current.getY() = y;
	    int m = 1;
	    try{
		if(board[y][x] == 'E'){
		    solutionb = new int[c * 2];
		    while(current.getNext() != null){
			board[current.getY()][current.getX()] = '@';
			solutionb[c - m] = current.getX();
			solution[c - m - 1]; current.getY();
			m -= 2;
		    }
		}

		
		
	    }
	    
	}	
    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){
	
    }
}
