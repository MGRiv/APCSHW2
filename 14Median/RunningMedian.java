import java.util.*;

public class RunningMedian{

    private MyHeap min;
    private MyHeap max;

    public RunningMedian(){
	min = new MyHeap(true);
	max = new MyHeap(false);
    }

    public void add(int val){
	if(min.getLength() == 0 && max.getLength() == 0){
	    min.add(val);
	}else if(val > getMedian()){
	    max.add(val);
	}else{
	    min.add(val);
	}
	if(Math.abs(min.getLength() - max.getLength()) > 1){
	    if(min.getLength() > max.getLength()){
		while(min.getLength() - max.getLength() > 1){
		    max.add(min.remove());
		}
	    }else{
		while(max.getLength() - min.getLength() > 1){
		    min.add(max.remove());
		}
	    }
	}
    }

    public void add(int[] v){
	for(int i = 0; 0 < v.length; i++){
	    add(v[i]);
	}
    }

    public String toString(){
	return "Smaller Numbers: \n" + min.toString() + "\n" + "Larger Numbers: \n" + max.toString();
    }
	
    public double getMedian(){
	if(min.getLength() == 0 && max.getLength() == 0){
	    throw new NoSuchElementException();
	}else if(max.getLength() > min.getLength()){
	    return (double)max.peek();
	}else if(min.getLength() > max.getLength()){
	    return (double)min.peek();
	}else{
	    return (max.peek() + min.peek()) / 2.0;
	}
    }

    public static void main(String[] args){
	RunningMedian q = new RunningMedian();
	q.add(2);
	q.add(5);
	q.add(3);
	q.add(12);
	q.add(6);
	q.add(4);
	q.add(1);
	q.add(9);
	System.out.println(q);
	System.out.println(q.getMedian());	
    }
}
