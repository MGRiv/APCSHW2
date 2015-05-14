public class RunningMedian{

    private MyHeap min;
    private MyHeap max;
    private int last;

    public RunningMedian(){
	min = new MyHeap(true);
	max = new MyHeap(false);
	last = Integer.MIN_VALUE;
    }

    public void add(int value){
	if(value > last){
	    max.add(value);
	}else{
	    min.add(value);
	}
	if(min.getLength() - max.getLength() > 1){
	    max.add(min.remove());
	}else if(min.getLength() - max.getLength() > 1){
	    min.add(max.remove());
	}
    }

    public double getMedian(){
	if(min.getLength() == max.getLength()){
	    return (((double) min.peek()) + ((double) max.peek()) ) / 2.0;
	}else if(min.getLength() > max.getLength()){
	    return min.peek();
	}else{
	    return max.peek();
	}
    }
    
    public String toString(){
	System.out.println(min + "\n" + max);
    }
}