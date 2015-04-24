import java.util.*;
import java.io.*;
public class TreeNode<E>{
    public E value;
    public TreeNode<E> child1,child2;
    
    public TreeNode(){
	value = null;
    }
    public TreeNode(E t){
	value = t;
    }
    
    public void setValue(E v){
	value = v;
    }
    public E getValue(){
	return value;
    }
    public boolean setChild(TreeNode<E> v){
	if(child1.getValue() != null && child2.getValue() != null){
	    if(Math.random() > 0.5){
		return child1.setChild(v) || child2.setChild(v);
	    }else{
		return child2.setChild(v) || child1.setChild(v);
	    }
	}else if(child1.getValue() == null){
	    child1 = v;
	    return true;
	}else{
	    child2 = v;
	    return true;
	}
	return false;	
    }
    public TreeNode<E>[] getChildren(){
	TreeNode<E>[] q = new TreeNode<E>[2];
	q[1] = child1;
	q[2] = child2;
	return q;
    }
}