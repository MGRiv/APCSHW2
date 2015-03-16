public class MyLinkedList<T>{

    public LNode<T> current;
    public LNode<T> head;
    public LNode<T> tail;
    public int len = 0;

    public static String name(){
	return "rivera.michael";
    }

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
    public T get(int index){
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
    public T set(int index, T v){
	current = head;
	if(index > -1 && index < size()){
	    while(index > 0){
		index--;
		current = current.getNext();
	    }
	    T r = current.getValue();
	    current.setValue(v);
	    return r;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public T remove(int index){
	current = head;
	if(index > -1 && index < size()){
	    if(index == 0){
		T t = head.getValue();
		head = head.getNext();
		return t;
	    }
	    while(index > 1){
		index--;
		current = current.getNext();
	    }
	    T t = current.getNext().getValue();
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

    public void add(int index, T v){
	current = head;
	if(index > -1 && index <= size()){
	    if(index == size() - 1){
		LNode<T> Q = new LNode<T>(v);
		tail.setNext(Q);
		tail = Q;
		len++;
	    }else{
		while(index > 0){
		    index--;
		    current = current.getNext();
		}
		LNode<T> Q = new LNode<T>(v);
		Q.setNext(current.getNext());
		current.setNext(Q);
		len++;
	    }	    
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public boolean add(T v){
	if(head == null){
	    head.setValue(v);
	    tail = head;
	    len++;
	}else{
	    LNode<T> o = new LNode<T>(v);
	    tail.setNext(o);
	    tail = o;
	    len++;
	}
	return true;
    }
    public int indexOf(T v){
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
    public void main(String[]args){
	MyLinkedList<T> Y = new MyLinkedList<T>();
	System.out.println(Y.size());
	System.out.println(Y.indexOf(3));
	Y.add(0);
	Y.add(0,(int)4);
	Y.add(9,(int)7);
    }
}
