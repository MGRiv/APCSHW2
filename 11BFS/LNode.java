public class LNode<T>{

    private T value;
    private int x,y;
    private LNode<T> next;

    public String name(){
	return "rivera.michael";
    }
    public void setxy(int a,int b){
	x = a;
	y = b;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public LNode<T> getNext(){
	return next;
    }
    public T getValue(){
	return value;
    }
    public void setNext(LNode<T> n){
	next = n;
    }
    public void setValue(T n){
	value = n;
    }
    public String toString(){
	return "" + getValue();
    }
    public LNode(T v){
	setValue(v);
    }
}
