import java.util.*;
public class MyDeque<T>{
    
    public Object[] storage;
    public int[] priority;
    public int head,size,psize = 0;
    public int tail = 1;
    public boolean shrin = false;
    
    public MyDeque(int s){
	storage = new Object[s];
	priority = new int[s];
    }

    public String name(){
	return "rivera.michael";
    }
    public int getSize(){
	return size;
    }

    public MyDeque(int s,boolean yes){
	storage = new Object[s];
	priority = new int[s];
	shrin = yes;
    }
    
    public String toString(){
	String r = "[ ";
	for(int i = 0; i < size; i++){
	    r += storage[(storage.length + head + 1 + i) % storage.length] + " ";
	}
	return r + "]";
    }
    public void add(Object g, int h){
	if(size == storage.length){
	    resize();
	}
	priority[(priority.length + tail) % priority.length] = h;
	storage[(storage.length + tail)%storage.length] = g;
	tail = (storage.length + (tail + 1))%storage.length;
	psize++;
	size++;
    }
    public void addFirst(T value){
	if(size == storage.length){
	    resize();
	}
	//System.out.println(" " +(storage.length + head - 1)%storage.length);
	storage[(storage.length + head) % storage.length] = value;
	head = (storage.length + (head - 1))%storage.length;
	//System.out.println("  " + head);
	size++;
	
    }
    public void addLast(T value){
	if(size == storage.length){
	    resize();
	}
	storage[(storage.length + tail)%storage.length] = value;
	tail = (storage.length + (tail + 1))%storage.length;
	size++;
    }
    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	//System.out.println(" " +(storage.length + head + 1)%storage.length);
	//System.out.println("  " + head);
	T temp = (T)storage[(storage.length + head + 1)%storage.length];
	storage[(storage.length + head + 1)%storage.length] = null;
	head = (storage.length + head + 1)%storage.length;
	size--;
	if(size <= storage.length / 4 && shrin){
	    shrink();
	}
	return temp;
    }
    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T temp = (T)storage[(storage.length + tail - 1)%storage.length];
	storage[(storage.length + tail - 1)%storage.length] = null;
	tail = (storage.length + (tail - 1))%storage.length;
	size--;
	if(size <= storage.length / 4 && shrin){
	    shrink();
	}
	return temp;
    }
    public T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)storage[(storage.length + head + 1)%storage.length];
    }
    public T getLast(){
	if(size ==0){
	    throw new NoSuchElementException();
	}
	return (T)storage[(storage.length + tail - 1)%storage.length];
    }
    public void resize(){
	Object[] temp = new Object[storage.length * 2];
	int[]tuna = new int[priority.length * 2];
	for(int i = 0; i < size; i++){
	    temp[i] = storage[(storage.length + head + 1 + i) % storage.length];
	}
	for(int i = 0; i < psize; i++){
	    tuna[i] = priority[(priority.length + head + 1 + i) % priority.length];
	}
	head = temp.length - 1;
	tail = storage.length;
	storage = temp;
	priority = tuna;
    }
    public void shrink(){
	Object[] temp = new Object[storage.length / 2];
	int[]tuna = new int[priority.length / 2];
	for(int i = 0; i < size; i++){
	    temp[i] = storage[(storage.length + head + 1 + i) % storage.length];
	}
	for(int i = 0; i < psize; i++){
	    tuna[i] = priority[(priority.length + head + 1 + i) % priority.length];
	}
	head = temp.length - 1;
	tail = size;
	priority = tuna;
	storage = temp;
    }
    public static void main(String[]args){
	MyDeque<Integer> g = new MyDeque<Integer>(2, true);
	g.addFirst(4);
	g.addLast(5);
	g.addFirst(1);
	g.addLast(2);
	System.out.println(g);
	System.out.println(g.getFirst());
	System.out.println(g.getLast());
	System.out.println(g.removeLast());
	System.out.println(g);
	System.out.println(g.removeFirst());
	System.out.println(g);
	System.out.println(g.removeFirst());
	System.out.println(g);
	System.out.println(g.removeLast());
	System.out.println(g);
	//System.out.println(g.removeLast());
	System.out.println(g.getFirst());
    }
}
