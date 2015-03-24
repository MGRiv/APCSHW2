import java.util.*;
public class MyQueue<T> extends MyLinkedList<T>{

    public boolean enqueue(T val){
	add(val);
	return true;
    }
    public T dequeue(){
	return remove(0);
    }

}
