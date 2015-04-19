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
    
    public String debug(){
	return Arrays.toString(storage) + "\n" + Arrays.toString(priority);
    }

    public String toString(boolean pike){
	if(pike){
	    String r = "[ ";
	    for(int i = 0; i < size; i++){
		r += storage[(storage.length + head + i) % storage.length] + " ";
	    }
	    r += "]" + "\n" + "[ ";
	    for(int i = 0; i < psize; i++){
		r += priority[(priority.length + head + i) % priority.length] + " ";
	    }
	    return r + "]";
	}else{
	    return toString();
	}
    }
    public void order(Object g, int h){
	int temp = 0;
	for(int i = 0; i < priority.length;i++){
	    if(h > priority[i + priority.length % priority.length]){
		temp = i % priority.length;
		break;
	    }
	}
	
	//System.out.println(tail);
	int j = tail;
	//System.out.println(j);
	while(j + priority.length % priority.length > temp){
	    priority[(j + priority.length) % priority.length] = priority[(j - 1 + priority.length) % priority.length];
	    storage[(j + priority.length) % priority.length] = storage[(j - 1 + priority.length) % priority.length];
	    j--;
	}
	tail = (storage.length + (tail + 1))%storage.length;
	priority[temp] = h;
	storage[temp] = g;
    }
    public void add(Object g, int h){
	if(size == storage.length && psize == priority.length){
	    resize(true);
	}
	order(g,h);
	psize++;
	size++;
    }
    public void addFirst(T value){
	if(size == storage.length){
	    resize(false);
	}
	//System.out.println(" " +(storage.length + head - 1)%storage.length);
	storage[(storage.length + head) % storage.length] = value;
	head = (storage.length + (head - 1))%storage.length;
	//System.out.println("  " + head);
	size++;
	
    }
    public void addLast(T value){
	if(size == storage.length){
	    resize(false);
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
	    shrink(false);
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
	    shrink(false);
	}
	return temp;
    }
    public T removeSmallest(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	priority[(priority.length + tail - 1)%priority.length] = 0;
	psize--;
	T temp = (T)storage[(storage.length + tail - 1)%storage.length];
	storage[(storage.length + tail - 1)%storage.length] = null;
	tail = (storage.length + (tail - 1))%storage.length;
	size--;
	if(size <= storage.length / 4 && shrin){
	    shrink(true);
	}
	return temp;
    }
    public T removeLargest(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	priority[(priority.length + head)%priority.length] = 0;
	psize--;
	T temp = (T)storage[(storage.length + head )%storage.length];
	storage[(storage.length + head)%storage.length] = null;
	head = (storage.length + head + 1)%storage.length;
	size--;
	if(size <= storage.length / 4 && shrin){
	    shrink(true);
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
    public void resize(boolean a){
	if(a){
	    Object[] temp = new Object[storage.length * 2];
	    int[]tuna = new int[priority.length * 2];
	    for(int i = 0; i < size; i++){
		temp[i] = storage[(storage.length + head + i) % storage.length];
	    }
	    for(int i = 0; i < psize; i++){
		tuna[i] = priority[(priority.length + head + i) % priority.length];
	    }
	    head = 0;
	    tail = size;
	    storage = temp;
	    priority = tuna;
	}else{
	    Object[] temp = new Object[storage.length * 2];
	    for(int i = 0; i < size; i++){
		temp[i] = storage[(storage.length + head + 1 + i) % storage.length];
	    }
	    head = temp.length - 1;
	    tail = storage.length;
	    storage = temp;
	}
    }
    public void shrink(boolean a){
	if(a){
	    Object[] temp = new Object[storage.length / 2];   
	    int[]tuna = new int[priority.length / 2];
	    for(int i = 0; i < size; i++){
		temp[i] = storage[(storage.length + head + i) % storage.length];
	    }
	    for(int i = 0; i < psize; i++){
		tuna[i] = priority[(priority.length + head + i) % priority.length];
	    }
	    head = 0;
	    tail = size;
	    priority = tuna;
	    storage = temp;
	}else{
	    Object[] temp = new Object[storage.length / 2];
	    for(int i = 0; i < size; i++){
		temp[i] = storage[(storage.length + head + 1 + i) % storage.length];
	    }
	    head = temp.length - 1;
	    tail = size;
	    storage = temp;
	}
    }
    public static void main(String[]args){
	MyDeque<Integer> g = new MyDeque<Integer>(1, true);
	/*
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	g.add(6,9);
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	g.add(3,2);
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	g.add(7,4);
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	g.add(0,5);
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	g.add(1,8);
	System.out.println(g.toString(true));
	System.out.println(g.removeLargest());
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	System.out.println(g.removeSmallest());
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	System.out.println(g.removeSmallest());
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	System.out.println(g.removeLargest());
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	System.out.println(g.removeLargest());
	System.out.println(g.toString(true));
	System.out.println(g.debug() + "\n");
	*/
	g.addLast(4);
	g.addFirst(5);
	g.addFirst(3);
	g.addLast(2);
	g.addFirst(1);
	System.out.println(g.toString(false));
	System.out.println(g.removeLast());
	System.out.println(g.toString(false));
	System.out.println(g.removeFirst());
	System.out.println(g.toString(false));
	System.out.println(g.removeFirst());
	System.out.println(g.toString(false));
	System.out.println(g.removeLast());
	System.out.println(g.toString(false));
	System.out.println(g.removeFirst());
	System.out.println(g.toString(false));
	//*/
    }
}
