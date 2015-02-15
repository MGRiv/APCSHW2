import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    
    
    public String name(){
	return "rivera.michael";
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
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
	return hide + clear + go(0,0) + ans + "\n" + show;
    }
    
    public KnightsTour(int size){
	if(size > 0){
	    board = new int[size][size];
	    for(int j = 0; j < board.length;j++){
		for(int i = 0; i < board[0].length;i++){
		    board[j][i]=0;
		}
	    }
	}
    }
    
    public boolean solve(){
	return solve(0,0,1);
    }
    
    public boolean solve(int startx, int starty){
	return solve(startx,starty,1);
    }
    
    
    
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	if(currentMoveNumber > (board.length * board.length)){
	    return true;
	}
	if(x < 0 || x >= board.length || y < 0 || y >= board.length){
	    return false;
	}
	if(board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if(solve(x - 2, y - 1,currentMoveNumber + 1) ||
	       solve(x - 2, y + 1,currentMoveNumber + 1) ||
	       solve(x + 2, y - 1,currentMoveNumber + 1) ||
	       solve(x + 2, y + 1,currentMoveNumber + 1) ||
	       solve(x - 1, y - 2,currentMoveNumber + 1) ||
	       solve(x - 1, y + 2,currentMoveNumber + 1) ||
	       solve(x + 1, y - 2,currentMoveNumber + 1) ||
	       solve(x + 1, y + 2,currentMoveNumber + 1)){
		return true;
	    }
	    board[x][y] = 0;
	    return false;
	}
	return false;
    } 
    public static void main(String[]args){
	KnightsTour Lance = new KnightsTour(8);
	if(Lance.solve()){
	    System.out.println(Lance);
	}else{
	    System.out.println("No Solution");
	}
    }
}
