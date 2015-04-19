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
    public int fx,fy;


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
		//System.out.println(Arrays.toString(board[i]));
	    }
	    int[] tug = new int[2];
	    tug = findP('E');
	    fx = tug[0];
	    fy = tug[1];
	    //System.out.println(fx);
	    //System.out.println(fy);
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
	    wait(50);
	    return hide + clear + go(0,0) + toString() + "\n" + show;
	}else{
	    return toString();
	}
    }
    
    /**Solve the maze using a frontier in a BFS manner.
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){
	return solve(animate,0);
    }
    

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){ 
	return solve(animate,1);
    }
    public int[] findP(char q){
	int[] r = new int[2];
	for(int i = 0; i < board.length;i++){
	    for(int j= 0; j < board[0].length;j++){
		if(board[i][j] == q){
		    r[0] = j;
		    r[1] = i;
		    break;
		}
	    }
	}
	return r;
    }
    
    public boolean solve(boolean animate,int mode){
	Frontier = new MyDeque<LNode<Integer>>(board.length * board[0].length);
	LNode<Integer> current = new LNode<Integer>(0);
	int[] tug = new int[2];
	tug = findP('S');
	current.setxy(tug[0],tug[1]);
	//Frontier.add(current,0);
	addPos(current.getX(),current.getY(),current,mode);
	while(Frontier.getSize() != 0){
	    //System.out.println("beep");
	    if(mode == 0){
		current = Frontier.removeFirst();
	    }else if(mode == 1){
		current = Frontier.removeLast();
	    }else{
		current = Frontier.removeSmallest();
	    }
	    System.out.println(Frontier.toString(true));
	    System.out.println(Frontier.debug());
	    x = current.getX();
	    y = current.getY();
	    //System.out.println(board[y][x]);
	    if(board[y][x] == 'E'){
		solutionb.clear();
		while(current.getNext() != null){
		    //System.out.println("beep");
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
		addPos(x,y,current,mode);
		board[y][x] = 'x';
	    }
	    if(animate){
		//System.out.println("beep");
		System.out.println(toString(true));
	    }
	}
	return false;
    }	
    
    public void addPos(int a, int b, LNode<Integer> next,int mode){
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
	if(mode <= 1){
	    Frontier.addLast(up);
	    Frontier.addLast(down);
	    Frontier.addLast(left);
	    Frontier.addLast(right);
	}else if(mode == 2){
	    Frontier.add(up,findD(up.getX(),up.getY()) + next.getValue());
	    Frontier.add(down,findD(down.getX(),down.getY()) + next.getValue());
	    Frontier.add(left,findD(left.getX(),left.getY()) + next.getValue());
	    Frontier.add(right,findD(right.getX(),right.getY()) + next.getValue());
	    
	}else{
	    System.out.println(Frontier.head);
	    System.out.println(Frontier.tail);
	    System.out.println(Frontier.toString(true));
	    System.out.println(Frontier.debug());
	    Frontier.add(up,findD(up.getX(),up.getY()));
	    System.out.println(Frontier.head);
	    System.out.println(Frontier.tail);
	    System.out.println(Frontier.toString(true));
	    System.out.println(Frontier.debug());
	    Frontier.add(down,findD(down.getX(),down.getY()));
	    System.out.println(Frontier.head);
	    System.out.println(Frontier.tail);
	    System.out.println(Frontier.toString(true));
	    System.out.println(Frontier.debug());
	    Frontier.add(left,findD(left.getX(),left.getY()));
	    System.out.println(Frontier.head);
	    System.out.println(Frontier.tail);
	    System.out.println(Frontier.toString(true));
	    System.out.println(Frontier.debug());
	    Frontier.add(right,findD(right.getX(),right.getY()));
	    System.out.println(Frontier.head);
	    System.out.println(Frontier.tail);
	    System.out.println(Frontier.toString(true));
	    System.out.println(Frontier.debug());
	}
    }

    public int findD(int a,int b){
	return Math.abs(fx - a) + Math.abs(fy - b);
    }
    
    public boolean solveAStar(){
	return solveAStar(false);
    }
    public boolean solveAStar(boolean animate){
	return solve(animate,2);
    }
    
    public boolean solveBest(){
	return solveBest(false);
    }
    public boolean solveBest(boolean animate){
	return solve(animate,3);
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
	q.solveBest(true);
	System.out.println(Arrays.toString(q.solutionCoordinates()));
    }
    
}
