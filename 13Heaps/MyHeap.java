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
	int other = (int)(Math.log(Heapy[0] + 1) / Math.log(2)) + 1;
	String ret = "";
	int i = 1;
	double n = 1.0;
	for(int c = 1; c <= Heapy[0]; c++){
	    if((int)Math.pow(2.0,(double)other) % c == 0 || c == 1){
		for(int p = i;p < other;p++){
		    ret += "  ";
		}
		i++;
	    }
	    ret += Heapy[c] + " ";
	    if((int)Math.pow(2.0,(double)other) % (c + 1) == 0){
		ret +="\n";
	    }
	}
	return ret;
    }
    
    public int remove(){
	if(Heapy[0] != 0){
	    int ret = Heapy[1];
	    Heapy[1] = Heapy[Heapy[0]];
	    pushdown(1);
	    Heapy[0] = Heapy[0] - 1;
	    return ret;
	}else{
	    throw new NoSuchElementException();
	}
    }

    public void pushdown(int index){
	int k = index;
	if((2 * k) >= Heapy.length || (2 * k) + 1 >= Heapy.length){
	    return;
	}
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
	if(Heapy.length <= Heapy[0] + 1){
	    resize();
	}
	Heapy[Heapy[0] + 1] = q;
	Heapy[0] += 1;
	pushup(Heapy[0]);
    }

    public void pushup(int index){
	int k = index;
	if(k == 1){
	    return;
	}
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
		pushup(k);
	    }
	}else{
	    if(Heapy[k] > Heapy[index]){
		int temp = Heapy[index];
		Heapy[index] = Heapy[k];
		Heapy[k] = temp;
		pushup(k);
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

    public int getLength(){
	return Heapy[0];
    }

    public void resize(){
	//System.out.println(Heapy[0]);
	int[] temp  = new int[Heapy.length * 2];
	for(int v = 0; v < Heapy.length; v++){
	    temp[v] = Heapy[v];
	}
	Heapy = temp;
	//System.out.println(Heapy[0]);
    }

    public static void main(String args[]){
	MyHeap h = new MyHeap(true);
	h.add(4);
	//System.out.println(h.getsize());
	h.add(3);
	h.add(5);
	h.add(10);
	h.add(12);
	h.add(1);
	//System.out.println(Arrays.toString(h.getsize()));
	System.out.println(h);
	System.out.println(h.remove());
	System.out.println(h);
    }
}
