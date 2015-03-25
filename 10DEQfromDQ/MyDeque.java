import java.util.*;
public class MyDeque<T>{
    
    T[] storage = new T[100];
    int head = 0;
    int tail = 1;
    
    public void addFirst(T value){
	if(head == tail && storage[head] != null){
	    resize();
	}
	storage[head] = value;
	head = (head - 1)%storage.length;
    }
    public void addLast(T value){
	if(head == tail && storage[head] != null){
	    resize();
	}
	storage[tail] = value;
	tail = (tail + 1)%storage.length;
    }
    public T removeFirst(){
	if(head == tail && storage[head] == null){
	    throw new NoSuchElementException();
	}
	T temp = storage[head];
	storage[head] = null;
	head = (head + 1)%storage.length;
	return temp;
    }
    public T removeLast(){
	if(head == tail && storage[head] == null){
	    throw new NoSuchElementException();
	}
	T temp = storage[tail];
	storage[tail] = null;
	head = (tail - 1)%storage.length;
	return temp;
    }
    public T getFirst(){
	if(storage[head] == null){
	    throw new NoSuchElementException();
	}
	return storage[head];
    }
    public T getLast(){
	if(storage[tail] == null){
	    throw new NoSuchElementException();
	}
	return storage[tail];
    }
    public void resize(){
	T[] temp = new T[storage.length * 2];
	System.arraycopy(storage,head,temp,0,storage.length - head);
	System.arraycopy(storage,0,temp,storage.length - head,tail);
	head = temp.length - 1;
	tail = storage.length;
    }
    public static void main(String[]args){
	MyDeque<Integer> g = new MyDeque<Integer>();
	g.addFirst(4);
	g.addLast(5);
	g.addFirst(1);
	g.addLast(2);
	System.out.println(g.getFirst());
	System.out.println(g.getLast());
	System.out.println(g.removeLast());
	System.out.println(g.removeFirst());

    }
}
