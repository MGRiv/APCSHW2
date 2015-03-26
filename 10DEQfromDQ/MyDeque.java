import java.util.*;
public class MyDeque<T>{
    
    public Object[] storage;
    public int head,size = 0;
    public int tail = 1;
    
    public MyDeque(int s){
	storage = new Object[s];
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
	System.arraycopy(storage,head,temp,0,storage.length - head);
	System.arraycopy(storage,0,temp,storage.length - head,tail);
	head = temp.length - 1;
	tail = storage.length;
    }
    public static void main(String[]args){
	MyDeque<Integer> g = new MyDeque<Integer>(100);
	g.addFirst(4);
	g.addLast(5);
	g.addFirst(1);
	g.addLast(2);
	System.out.println(g.getFirst());
	System.out.println(g.getLast());
	System.out.println(g.removeLast());
	System.out.println(g.removeFirst());
	System.out.println(g.removeFirst());
	System.out.println(g.removeLast());
	//System.out.println(g.removeLast());
	System.out.println(g.getFirst());
    }
}
