public class MyLinkedList{

    public LNode current;
    public LNode head;

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
	    while(index > 1){
		index--;
		current = current.getNext();
	    }
	    int t = current.getValue();
	    current.setNext(current.getNext().getNext());
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
	current = head;
	if(head != null){
	    while(current.getNext() != null){
		current = current.getNext();
	    }
	    LNode Q = new LNode();
	    current.setNext(Q);
	    Q.setValue(v);
	}else{
	    head.setValue(v);
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
	current = head;
	if(head == null){
	    return 0;
	}
	int c = 1;
	while(current.getNext() != null){
	    c++;
	    current = current.getNext();
	}
	return c;
    }
}
