public class LNode{

    private int value;
    private LNode next;

    public int getNext(){
	return next.getValue();
    }
    public int getValue(){
	return value;
    }
    public void setNext(int n){
	next.setValue(n);
    }
    public void setValue(int n){
	value = n;
    }
    public String toString(){
	if(getValue() != null){
	    if(getNext() != null){
		return "" + getValue() + getNext().toString();
	    }else{
		return "" + getValue();
	    }
	}else{
	    return "";
	}
    }
    public int get(int index){
	if(index > 0){
	    return getNext().get(index - 1);
	}else{
	    return getValue();
	}
    }
    public void set(int index, int v){
	if(index > 0){
	    getNext().set(index - 1,v);
	}else{
	    setValue(v);
	}
    }
    public int remove(int index){
	if(index > 1){
	    next.remove(index - 1);
	}else{
	    setNext(next.getNext());
	}
    }
    public void add(int v){
	if(next != null){
	    getNext().add(v);
	}else{
	    LNode Q = new LNode();
	    setNext(Q);
	    Q.setValue(v);
	}
    }

}
