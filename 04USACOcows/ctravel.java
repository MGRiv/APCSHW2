import java.io.*;
import java.util.*;

public class ctravel{
    public static int x,y,m,c,d;
    static int[] positions;
    static String[][] field;

    public static void main(String[]args){
	try{
	    File file = new File(args[0]);
	    Scanner q = new Scanner(file);
	    
	    String[] inputs = q.nextLine().split(" ");
	    y = Integer.parseInt(inputs[0]);
	    x = Integer.parseInt(inputs[1]);
	    m = Integer.parseInt(inputs[2]);
	    field = new String[y][x];
	    String load = "";
	    for(int i = 0; i < y; i++){
		load = q.nextLine();
		for(int j = 0; j < x; j++){
		    field[i][j] = load.substring(j,j+1);
		}
	    }
	    positions = new int[4];
	    inputs = q.nextLine().split(" ");
	    for(int i = 0; i < 4; i++){
		positions[i] = Integer.parseInt(inputs[i]);
	    }
	}catch (FileNotFoundException exception){
	    System.out.println("File not found");
	}
	solve();
	System.out.println(c);
    }
    
    public static int solve(){
	c = 0;
	solve(positions[0] - 1,positions[1] - 1, 0);
	return c;
    }
    public static void solve(int px, int py, int steps){
	if(steps > m){
	    return;
	}
	if(px == positions[2] - 1 && py == positions[3] - 1){
	    c++;
	    return;
	}
	if(px < 0 || px >= x || py < 0 || py >= y){
	    return;
	}
	if(field[py][px].equals("*")){
	    return;
	}
	if(field[py][px].equals(".")){	    
	    solve(px + 1, py, steps + 1);
	    solve(px, py + 1, steps + 1);
	    solve(px - 1, py, steps + 1);
	    solve(px, py - 1, steps + 1);
	}
	return;
    }
}
