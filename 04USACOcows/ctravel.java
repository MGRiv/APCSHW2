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
	    for(int i = 0; i < y; i++){
		inputs = q.nextLine().split("");
		for(int j = 0; j < x; j++){
		    field[i][j] = inputs[j];
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
	System.out.println(solve());
    }

    public static int solve(){
	c = 0;
	return solve(positions[0] - 1,positions[1] - 1, 0);
    }
    public static int solve(int px, int py, int steps){
	if(steps > m){
	    //System.out.println("b");
	    return 0;
	}
	if(px == positions[2] - 1 && py == positions[3] - 1){
	    return 1;
	}
	if(px < 0 || px >= x || py < 0 || py >= y){
	    //System.out.println("a");
	    return 0;
	}
	if(field[py][px].equals("*")){
	    //System.out.println(Integer.toString(px) + "," +Integer.toString(py));
	    return 0;
	}

	c += solve(px + 1, py, steps + 1)
	    + solve(px, py + 1, steps + 1)
	    + solve(px - 1, py, steps + 1)
	    + solve(px, py - 1, steps + 1);
	return c;
    }
}
