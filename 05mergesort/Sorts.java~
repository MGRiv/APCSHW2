import java.util.*;
public class Sorts{
    
    public static int[] merge(int[] a, int[] b){
	int[]ans = new int[a.length + b.length];
	int i = 0;
	int j = 0;
	while(i < a.length && j < b.length){
	    if(a[i] < b[j]){
		ans[i + j] = a[i];
		i++;
	    }else{
		ans[i + j] = b[j];
		j++;
	    }
	}
	if(i >= a.length){
	    for(int q = j; q < b.length; q++){
		ans[a.length + q] = b[q];
	    }
	}else{
	    for(int q = i; q < a.length; q++){
		ans[q + b.length] = a[q];
	    }
	}
	return ans;
    }

    public static int[] mergesorthelp(int[] q){
	if(q.length < 2){
	    return q;
	}
	int[] x = new int[q.length / 2];
	int[] y = new int[q.length - x.length];
	System.arraycopy(q,0,x,0,x.length);
	System.arraycopy(q,x.length,y,0,y.length);
	return merge(mergesorthelp(x),mergesorthelp(y));
    }

    public static void mergesort(int[]q){
	int[] p = mergesorthelp(q);
	for(int i = 0; i < q.length; i++){
	    q[i] = p[i];
	}
    }


    public static void main(String[]args){
	int[] q = new int[20];
	Random r = new Random();
	for (int n = 0; n < q.length; n++){
	    q[n] = r.nextInt(20);
	}
	System.out.println(Arrays.toString(q));
	mergesort(q);
	System.out.println(Arrays.toString(q));
    }
}
