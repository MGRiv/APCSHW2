import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    private int count;

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public int getCount(){
	return count;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setCount(int c){
	count = c;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }

    public int compareTo(T thing){
	if(thing == null){
	    throw new NullPointerException();
	}
	return this.getData().compareTo(thing.getData());
    }
}