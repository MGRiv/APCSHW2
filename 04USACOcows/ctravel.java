import java.io.*;
import java.util.*;

public class ctravel{
    public static int x,y,m,c,d;
    static int[] positions;
    static char[][] field;

    public static void main(String[]args){
	try{
	    File file = new File(args[0]);
	    Scanner q = new Scanner(file);
	    
	    String[] inputs = q.nextLine().toUpperCase().split(" ");
	    y = Integer.parseInt(inputs[0]);
	    x = Integer.parseInt(inputs[1]);
	    m = Integer.parseInt(inputs[2]);
	    field = new char[y][x];
	    String load = "";
	    for(int i = 0; i < y; i++){
		load = q.nextLine().toUpperCase();
		for(int j = 0; j < x; j++){
		    field[i][j] = load.charAt(j);
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
	/*
	System.out.println(""+field[0][0] + field[0][1] + field[0][2] + field[0][3] + field[0][4]);
	System.out.println(""+field[1][0] + field[1][1] + field[1][2] + field[1][3] + field[1][4]);
	System.out.println(""+field[2][0] + field[2][1] + field[2][2] + field[2][3] + field[2][4]);
	System.out.println(""+field[3][0] + field[3][1] + field[3][2] + field[3][3] + field[3][4]);
	System.out.println(positions[0] + "," + positions[1]);
	System.out.println(positions[2] + "," + positions[3]);
	System.out.println(field[0][3]=='*');
	*/
	System.out.println(solve());
	
    }
    public static String name(){
	return "rivera.michael";
    }    
    public static int solve(){
	return solve(positions[0] - 1,positions[1] - 1, m);
    }
    public static int solve(int px, int py, int steps){
	if(steps == 0 && px == (positions[2] - 1) && py == (positions[3] - 1)){
	    return 1;
	}
	if(px < 0 || px >= x || py < 0 || py >= y || steps <= 0){
	    //System.out.println("wrong");
	    return 0;
	}
	if(field[py][px] == '*'){
	    //System.out.println("wrong");
	    return 0;
	}
	return solve(px + 1, py, steps - 1) +  solve(px, py + 1, steps - 1) + solve(px - 1, py, steps - 1) + solve(px, py - 1, steps - 1);
    }
}
