public class MyLinkedList{

    public LNode current;
    public LNode head;

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
	current = head;
	while(index > 0){
	    index--;
	    current = current.getNext();
	}
	current.setValue(v);
    }
    public int remove(int index){
	current = head;
	while(index > 1){
	    index--;
	    current = current.getNext();
	}
	int t = current.getValue();
	current.setNext(current.getNext().getNext());
	return t;
    }

    public void add(int index, int v){
	current = head;
	while(index > 0){
	    index--;
	    current = current.getNext();
	}
	LNode Q = new LNode();
	Q.setValue(v);
	Q.setNext(current.getNext());
	current.setNext(Q);
    }
    public void add(int v){
	current = head;
	while(current.getNext() != null){
	    current = current.getNext();
	}
	LNode Q = new LNode();
	current.setNext(Q);
	Q.setValue(v);	
    }
    public int indexOf(int v){
	int c = 0;
	current = head;
	while(current.getNext() != null){
	    if(current.getValue() == v){
		break;
	    }else{
		c++;
	    }
	}
	return c;
    }
    public int size(){
	current = head;
	int c = 1;
	while(current.getNext() != null){
	    c++;
	    current = current.getNext();
	}
	return c;
    }
}
