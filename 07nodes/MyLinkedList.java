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
		try{
		    current = current.getNext();
		}catch (NullPointerException e){
		    System.out.println("Element does not exist");
		}
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
