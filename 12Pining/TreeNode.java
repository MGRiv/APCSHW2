import java.util.*;
import java.io.*;
public class TreeNode<E>{
    public E value;
    public TreeNode<E> left;
    public TreeNode<E> right;
    
    public TreeNode(){
	value = null;
    }
    public TreeNode(E t){
	value = t;
    }
    public TreeNode(E t, TreeNode<E> l,TreeNode<E> r){
	this(t);
	left = l;
	right = r;
    }

    public void setLeft(TreeNode<E> leaf){
	left = leaf;
    }
    public TreeNode<E> getLeft(){
	return left;
    }
    public void setRight(TreeNode<E> leaf){
	right = leaf;
    }
    public TreeNode<E> getRight(){
	return right;
    }
    public void setValue(E v){
	value = v;
    }
    public E getValue(){
	return value;
    }
    public boolean hasLeft(){
	return left != null;
    }
    public boolean hasRight(){
	return right != null;
    }
    public String toString(){
	return value.toString();
    }
    public String name(){
	return "rivera.michael";
    }
}
