import java.util.*;

public class MyHeap{

    private int[] Heapy;
    
    public MyHeap(){
	Heapy = new int[2];
	Heapy[0] = 0;
    }

    public String toString(){
	String ret = "";
	int i = 1;
	double n = 1.0;
	for(int c = 1; c < s; c++){
	    ret += Heapy[c] + " ";
	    if(i == c){
		i += (int)Math.pow(2.0,n);
		n += 1.0;
		ret += "\n";
	    }
	}
	return ret;
    }
    
    public int remove(){
	
    }

    public void add(int q){
	if(Heapy.length == Heapy[0] + 1){
	    resize();
	    Heapy[Heapy[0] + 1] = q;
	    Heapy[0] = Heapy[0] + 1;
	}else{
	    int r = Heapy.length - 1;
	    while(Heapy[r - 1] == null && r != (Heapy.length / 2)){
		r--;
	    }
	    Heapy[r] = q;
	    Heapy[0] = Heapy[0] + 1;
	}

	/*
	  NEED TO DO PUSH UP FUNCTION FOR ADD METHOD
	  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	 */
	
    }
    
    public void resize(){
	int[] temp  = int[(Heapy.length - 1) * 2 + 1];
	for(int v = 0; v < Heapy.length; v++){
	    temp[v] = Heapy[v];
	}
	Heapy = temp;
    }
}