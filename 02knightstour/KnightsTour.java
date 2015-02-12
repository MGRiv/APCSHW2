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
	//build your knights tour here...
	return hide + clear + go(0,0) + ans + "\n" + show;
    }
    
    public KnightsTour(int size){
	if(size > 0){
	    board = new int[size][size];
	    for(int j = 0; j < board.length;j++){
		for(int i = 0; i < board[0].size;i++){
		    board[j][i]=0;
		}
	    }
	    solve(0,0,1);
	}
    }
    
    public void solve(){
	solve(0,0,1);
    }
    
    public void solve(int startx, int starty){
	solve(starx,starty,1);
    }
    
    
    
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	if(x <= 0 || x >= size || y <= 0 || y >= size){
	    return false;
	}
	if(currentMoveNumber > (board.length * board.length)){
	    return true;
	}
	if(board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if(solve(x + 2, y + 1,currentMoveNumber + 1) ||
	       solve(x + 2, y - 1,currentMoveNumber + 1) ||
	}
	return false;
    }
    
    
}
