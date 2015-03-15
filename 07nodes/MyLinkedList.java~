public class MyLinkedList{

    public LNode current;
    public LNode head;
    public LNode tail;
    public int len = 0;

    public String toString(){
	current = head;
	String r = "[";
	if(head != null){
	    r += head;
	    while(current.getNext() != null){
		r += "," + current.getNext();
		current = current.getNext();
	    }
	}
	r +="]";
	return r;
    }
    public int get(int index){
	current = head;
	if(index > -1 && index < size()){
	    while(index > 0){
		index--;
		current = current.getNext();
	    }
	    return current.getValue();
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int set(int index, int v){
	current = head;
	if(index > -1 && index < size()){
	    while(index > 0){
		index--;
		current = current.getNext();
	    }
	    int r = current.getValue();
	    current.setValue(v);
	    return r;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int remove(int index){
	current = head;
	if(index > -1 && index < size()){
	    if(index == 0){
		int t = head.getValue();
		head = head.getNext();
		return t;
	    }
	    while(index > 1){
		index--;
		current = current.getNext();
	    }
	    int t = current.getValue();
	    current.setNext(current.getNext().getNext());
	    len--;
	    if(len > 0){
		int i = len - 1;
		current = head;
		while(i > 0){
		    i--;
		    current = current.getNext();
		}
		tail = current;
	    }else{
		tail = head;
	    }
	    return t;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public void add(int index, int v){
	current = head;
	if(index > -1 && index < size()){
	    while(index > 0){
		index--;
		current = current.getNext();
	    }
	    LNode Q = new LNode();
	    Q.setValue(v);
	    Q.setNext(current.getNext());
	    current.setNext(Q);
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public boolean add(int v){
	if(head == null){
	    head.setValue(v);
	    tail = head;
	    len++;
	}else{
	    LNode o = new LNode();
	    o.setValue(v);
	    tail.setNext(o);
	    tail = o;
	    len++;
	}
	return true;
    }
    public int indexOf(int v){
	int c = 0;
	boolean found = false;
	current = head;
	while(current.getNext() != null){
	    if(current.getValue() == v){
		found = true;
		break;
	    }else{
		c++;
	    }
	}
	if(found){
	    return c;
	}else{
	    return -1;
	}
    }
    public int size(){
	return len;
    }
}
