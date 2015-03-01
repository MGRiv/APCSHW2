import java.io.*;
import java.util.*;

public class makeLake{
    static int x,y,e,n;
    static int[][] field, steps;

    public static void main(String[]agrs){
	try{
	    File file = new File(agrs[0]);
	    Scanner q = new Scanner(file); 

	    String[] inputs = q.nextLine().split(" ");
	    y = Integer.parseInt(inputs[0]);
	    x = Integer.parseInt(inputs[1]);
	    e = Integer.parseInt(inputs[2]);
	    n = Integer.parseInt(inputs[3]);
	    field = new int[y][x];
	    for(int i = 0; i < y; i++){
		inputs = q.nextLine().split(" ");
		for(int j = 0; j < x; j++){
		    field[i][j] = Integer.parseInt(inputs[j]);
		}
	    }
	    steps = new int[n][3];
	    for(int i = 0; i < n; i++){
		inputs = q.nextLine().split(" ");
		for(int j = 0; j < 3; j++){
		    steps[i][j] = Integer.parseInt(inputs[j]);
		}
	    }
      	}catch (FileNotFoundException exception){
	    System.out.println("File not found");
	}
	System.out.println(solve());

    }

    public static int solve(){
	for(int i = 0; i < steps.length; i++){
	    int r = steps[i][0] - 1;
	    int c = steps[i][1] - 1;
	    int top = 0;
	    for(int t = 0; t < 3; t++){
		for(int q = 0; q < 3; q++){
		    if(field[r + t][q + c] > top){
			top = field[r+t][q+c];
		    }
		}
	    }
	    top -= steps[i][2];
	    for(int t = 0; t < 3; t++){
		for(int q = 0; q < 3; q++){
		    if(field[r + t][q + c] > top){
			field[r+t][q+c] = top;
		    }
		}
	    }
	}
	return getVolume();
    }
    
    public static int getVolume(){
	int vol = 0;
	for(int i = 0; i < y; i++){
	    for(int j = 0; j < x; j++){
		if(field[i][j] < e){
		    vol += e - field[i][j];
		}
	    }
	}
	return 5184 * vol;
    }

}
