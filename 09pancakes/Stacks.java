import java.util.*;
public class Stacks<T>{
    public LNode<T> top;
    public LNode<T> below;

    public boolean empty(){
	if(top == null){
	    return true;
	}
	return false;
    }
    public T peek(){
	if(empty()){
	    throw new EmptyStackException();
	}
	return top.getValue();
    }
    public T pop(){
	if(empty()){
	    throw new EmptyStackException();
	}
	T temp = top.getValue();
	top = below;
	below = below.getNext();
	return temp;
    }
    public T push(T val){
	LNode<T> n = new LNode<T>(val);
	n.setNext(top);
	below = top;
	top = n;
	return val;
    }
    /*
    public int search(Object o){
	//to be implemented later
    }
    */


}
