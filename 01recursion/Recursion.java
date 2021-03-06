public class Recursion implements hw1{
    public String name(){
	return "Rivera,Michael";
    }
    public int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return facth(n,1);
    }
    public int facth(int n, int q){
	if(n < 1){
	    return q;
	}
	return facth(n-1,q*n);
    }
    public int fib(int n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0 || n==1){
	    return n;
	}
	return fib(n-1) + fib(n-2);
    }
    /*
    public in fibh(int n, int a, int b){
	
    }
    */
    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrth(n,1);
    }
    public double sqrth(double n, double q){
	if(Math.abs((((n / q)+ q)/ 2) - q) < 0.0000001){
	    return q;
	}
	return sqrth(n,(((n / q)+ q)/ 2));
    }
    public static void main(String[]args){
	Recursion q = new Recursion();
	/*
	System.out.println(q.name());
	System.out.println(q.fib(0));
	System.out.println(q.fib(2));
	System.out.println(q.fib(5));
	
	System.out.println(q.fib(10));
	System.out.println(q.fib(-1));
	System.out.println(q.fact(0));
	System.out.println(q.fact(1));
	System.out.println(q.fact(5));
	System.out.println(q.fact(-1));
	*/
	System.out.println(q.sqrt(169.0));
	System.out.println(q.sqrt(1.0));
	System.out.println(q.sqrt(1.0E-8));
	System.out.println(q.sqrt(0.0));
	System.out.println(q.sqrt(-100.0));
	
    }
}
