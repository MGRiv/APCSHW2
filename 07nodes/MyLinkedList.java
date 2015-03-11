public class MyLinkedList{

    private LNode current;
    private LNode head;

    public String toString(){
	current = head;
	String r = "[";
	r += head;
	while(current.getNext() != null){
	    r += "," + current.getNext();
	    current = current.getNext();
	}
	r +="]";
	return r;
    }
    public int get(int index){
	current = head;
	while(index > 0){
	    index--;
	    current = current.getNext();
	}
	return current.getValue();
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
    public void add(int index, int v){
	if(index > 0){
	    
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