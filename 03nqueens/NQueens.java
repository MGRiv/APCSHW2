import java.util.*;
import java.io.*;


public class NQueens{
    final static String clear = "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private char[][]board;
    
    
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
		ans+= "\n";
	    }
	    char c = board[i / board.length][i % board.length];
	    ans += " " + c;
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	if(size > 0 && size != 2 && size != 3){
	    board = new char[size][size];
	    for(int j = 0; j < board.length;j++){
		for(int i = 0; i < board[0].length;i++){
		    board[j][i]= '-';
		}
	    }
	}
    }
    public boolean solve(){
	return solve(0,0);
    }
    public boolean solve(int sy){
	return solve(0,sy);
    }
    public boolean solve(int sx, int sy){
	boolean attacked = false;
	boolean spaces = false;
	if(sx >= board.length){
	    return true;
	}
	if(board[sy][sx] == '-'){
	    int dif = 1;
	    for(int i = sx; i > 0; i--){
		if(sy + dif < board.length){
		    if(board[sy + dif][i - 1] == 'Q'){
			attacked = true;
		    }
		}
		//if(sy== 0 && sx == 2){
		//    System.out.println(attacked);
		//}
		if(sy - dif >= 0){
		    if(board[sy - dif][i - 1] == 'Q'){
			attacked = true;
		    }
		}
		//if(sy== 0 && sx == 2){
		//    System.out.println(attacked);
		//}
		if(board[sy][i - 1] == 'Q'){
		    attacked = true;
		}
		//if(sy== 0 && sx == 2){
		//    System.out.println(attacked);
		//}
		dif++;
	    }
	    
	    //System.out.println(attacked);
	    if(attacked){
		return false;
	    }
	    board[sy][sx] = 'Q';
	    for(int c = 0; c < board.length; c++){
		spaces = spaces || solve(sx + 1,c);
	    }
	    /*
	    System.out.println(spaces);
	    System.out.println(sx);
	    System.out.println(sy);
	    */
	    if(spaces){
		return true;
	    }else{
		board[sy][sx] = '-';
		return false;
	    }
	}
	return false;
    }
    /*
    public static void main(String[]args){
	NQueens Saherazad =  new NQueens(6);
	if(Saherazad.solve()){
	    System.out.println(Saherazad);
	}else{
	    System.out.println("No Solution");
	}
    }
    */
}
