import java.util.*;
import java.io.*;
public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    public char[][]board;
    public int x,y;
    public ArrayList<Integer> solutionb;


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
	for(int i = 0; i < board.length;i++){
	    for(int j= 0; j < board[0].length;j++){
		if(board[i][j] == 'S'){
		    current = new LNode<Integer>();
		    current.setxy(j,i);
		    Frontier.addFirst(current);
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
	    if(board[y][x] == 'E'){
		while(current.getNext() != null){
		    board[current.getY()][current.getX()] = '@';
		    solutionb.add(0,current.getY());
		    solutionb.add(0,current.getX());
		}
		return true;
	    }
	    if(board[y][x] == ' '){
		LNode<Integer> up = new LNode<Integer>();
		up.setxy(x,y + 1);
		up.setNext(current);
		LNode<Integer> down = new LNode<Integer>();
		down.setxy(x,y - 1);
		down.setNext(current);
		LNode<Integer> left = new LNode<Integer>();
		left.setxy(x - 1,y);
		left.setNext(current);
		LNode<Integer> right = new LNode<Integer>();
		right.setxy(x + 1,y);
		right.setNext(current);
		Frontier.addLast(up);
		Frontier.addLast(down);
		Frontier.addLast(left);
		Frontier.addLast(right);
		board[y][x] = '.';
	    }
	}
	return false;
    }	
    
    
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){
	int[] ret = new int[solutionb.size()];
	for(int i = 0;i < solutionb.size();i++){
	    ret[i] = solutionb.get(i);
	}
	return ret;
    }
    
}
