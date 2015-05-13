import java.util.*;

public class MyHeap{

    private int[] Heapy;
    private boolean type;
    
    public MyHeap(){
	Heapy = new int[2];
	Heapy[0] = 0;
	type = true;
    }
    public MyHeap(boolean kind){
	this();
	type = kind;
    }

    public String toString(){
	String ret = "";
	int i = 1;
	double n = 1.0;
	for(int c = 1; c < Heapy[0]; c++){
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
	if(Heapy[0] == 0){
	    int ret = Heapy[1];
	    Heapy[1] = Heapy[Heapy[0]];
	    Heapy[Heapy[0]] = null;
	    pushdown(1);
	    Heapy[0] = Heapy[0] - 1;
	    return ret;
	}else{
	    throw new NoSuchElementException();
	}
    }

    public void pushdown(int index){
	int k = index;
	if(type){
	    if(Heapy[k] < Heapy[(2 * k) + 1] && Heapy[(2 * k) + 1] > Heapy[2 * k]){
		int temp = Heapy[k];
		Heapy[k] = Heapy[(2 * k) + 1];
		Heapy[(2 * k) + 1] = temp;
		pushdown((2 * k) + 1);
	    }else if(Heapy[k] < Heapy[2 * k] && Heapy[(2 * k) + 1] <= Heapy[2 * k]){
		int temp = Heapy[k];
		Heapy[k] = Heapy[2 * k];
		Heapy[2 * k] = temp;
		pushdown(2 * k);
	    }
	}else{
	    if(Heapy[k] > Heapy[(2 * k) + 1] && Heapy[(2 * k) + 1] < Heapy[2 * k]){
		int temp = Heapy[k];
		Heapy[k] = Heapy[(2 * k) + 1];
		Heapy[(2 * k) + 1] = temp;
		pushdown((2 * k) + 1);
	    }else if(Heapy[k] > Heapy[2 * k] && Heapy[(2 * k) + 1] >= Heapy[2 * k]){
		int temp = Heapy[k];
		Heapy[k] = Heapy[2 * k];
		Heapy[2 * k] = temp;
		pushdown(2 * k);
	    }
	}
    }

    public void add(int q){
	int index;
	if(Heapy.length == Heapy[0] + 1){
	    resize();
	    Heapy[Heapy[0] + 1] = q;
	    index = Heapy[0] + 1;
	    Heapy[0] = Heapy[0] + 1;
	}else{
	    int r = Heapy.length - 1;
	    while(Heapy[r - 1] == null && r != (Heapy.length / 2)){
		r--;
	    }
	    Heapy[r] = q;
	    index = r;
	    Heapy[0] = Heapy[0] + 1;
	}
	pushup(index);
    }

    public void pushup(int index){
	int k = index;
	if(k % 2 == 0){
	    k = index / 2;
	}else{
	    k = (index - 1) / 2;
	}
	if(type){
	    if(Heapy[k] < Heapy[index]){
		int temp = Heapy[index];
		Heapy[index] = Heapy[k];
		Heapy[k] = temp;
		push(k);
	    }
	}else{
	    if(Heapy[k] > Heapy[index]){
		int temp = Heapy[index];
		Heapy[index] = Heapy[k];
		Heapy[k] = temp;
		push(k);
	    }
	}
    }
    
    public int peek(){
	if(Heapy[0] > 0){
	    return Heapy[1];
	}else{
	    throw new NoSuchElementException();
	}
    }

    public void resize(){
	int[] temp  = int[(Heapy.length - 1) * 2 + 1];
	for(int v = 0; v < Heapy.length; v++){
	    temp[v] = Heapy[v];
	}
	Heapy = temp;
    }
}
