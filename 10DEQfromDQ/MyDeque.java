import java.util.*;
public class MyDeque<T>{
    
    T[] storage = new T[100];
    int head = 0;
    int tail = 0;
    
    public void addFirst(T value){
	if(head == tail && storage[head] != null){
	    resize();
	}
	storage[head] = value;
	head = (head - 1)%storage.length();
    }
    public void addLast(T value){
	if(head == tail && storage[head] != null){
	    resize();
	}
	storage[tail] = value;
	tail = (tail + 1)%storage.length();
    }
    public T removeFirst(){

    }
    public T removeLast(){

    }
    public T getFirst(){

    }
    public T getLast(){

    }
    public void resize(){
	T[] temp = new T[storage.length() * 2];
	System.arraycopy(storage,head,temp,0,storage.length() - head);
	System.arraycopy(storage,0,temp,storage.length() - head,tail);
	head = temp.length() - 1;
	tail = storage.length();
    }
}