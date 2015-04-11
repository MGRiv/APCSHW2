import java.util.*;
import java.io.*;
public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    public char[][]board;
    public int x,y;
    public ArrayList<Integer> solutionb = new ArrayList<Integer>();
    public MyDeque<LNode<Integer>> Frontier;


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
	    ArrayList<String> b = new ArrayList<String>();
	    while(q.hasNextLine()){
		b.add(q.nextLine());
	    }
	    //System.out.println(b.get(0).length());
	    board = new char[b.size()][b.get(0).length()];
	    for(int i = 0; i < b.size(); i++){
		board[i] = b.get(i).toCharArray();
		System.out.println(Arrays.toString(board[i]));
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
	for(int i = 0; i < board.length * board[0].length; i++){
	    if(i % board[0].length == 0){
		ans += "\n";
	    }
	    char c = board[i / board[0].length][i % board[0].length];
	    ans += " " + Character.toString(c);
	}
	return ans;
    }
    
    public String toString(boolean animate){
	if(animate){
	    wait(200);
	    String ans = "\n";
	    for(int i = 0; i < board.length * board[0].length; i++){
		if(i % board[0].length == 0){
		    ans += "\n";
		}
		//System.out.println(i);
		char c = board[i / board[0].length][i % board[0].length];
		ans += " " + Character.toString(c);
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
	Frontier = new MyDeque<LNode<Integer>>(board.length * board[0].length);
	LNode<Integer> current = new LNode<Integer>(0);
	for(int i = 0; i < board.length;i++){
	    for(int j= 0; j < board[0].length;j++){
		if(board[i][j] == 'S'){
		    current.setxy(j,i);
		    Frontier.addFirst(current);
		    break;
		}
	    }
	}
	addPos(current.getX(),current.getY(),current);
	x = 1;
	y = 1;
	while(Frontier.getSize() != 0){
	    //System.out.println("beep");
	    if(bfs){
		current = Frontier.removeFirst();
	    }else{
		current = Frontier.removeLast();
	    }
	    x = current.getX();
	    y = current.getY();
	    //System.out.println(board[y][x]);
	    if(board[y][x] == 'E'){
		while(current.getNext() != null){
		    System.out.println("beep");
		    board[current.getY()][current.getX()] = '@';
		    solutionb.add(0,current.getY());
		    solutionb.add(0,current.getX());
		    current = current.getNext();
		    if(animate){
			System.out.println(toString(true));
		    }
		}
		System.out.println(toString(false));
		return true;
	    }
	    if(board[y][x] == ' '){
		addPos(x,y,current);
		board[y][x] = '.';
	    }/*
	    if(animate){
		System.out.println("beep");
		System.out.println(toString(true));
		}*/
	}
	return false;
    }	
    
    public void addPos(int a, int b, LNode<Integer> next){
	LNode<Integer> up = new LNode<Integer>(next.getValue() + 1);
	up.setxy(a,b + 1);
	up.setNext(next);
	LNode<Integer> down = new LNode<Integer>(next.getValue() + 1);
	down.setxy(a,b - 1);
	down.setNext(next);
	LNode<Integer> left = new LNode<Integer>(next.getValue() + 1);
	left.setxy(a - 1,b);
	left.setNext(next);
	LNode<Integer> right = new LNode<Integer>(next.getValue() + 1);
	right.setxy(a + 1,b);
	right.setNext(next);
	Frontier.addLast(up);
	Frontier.addLast(down);
	Frontier.addLast(left);
	Frontier.addLast(right);
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
    public static void main(String[]args){
	Maze q = new Maze(args[0]);
	q.solveDFS(false);
	System.out.println(Arrays.toString(q.solutionCoordinates()));
    }
    
}
