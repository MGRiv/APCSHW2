import java.util.*;

public class Sorts{

    public static String name(){
	return "rivera.michael";
    }
    public static void heapsort(int[]q){
	int[] a = orderheap(q);
	q = organize(a);
    }
    public static int[] orderheap(int[]q){
	int[] tem = q;
	int l = q.length;
	while(l > 0){
	    int which;
	    if(l % 2 == 0){
		which = l / 2;
	    }else{
		which = (l - 1) / 2;
	    }
	    if(tem[l] > tem[which]){
		int temp = tem[which];
		tem[which] = tem[l];
		tem[l] = temp;
	    }
	    l--;
	}
	return tem;
    }
    public static int[] orderheap(int[]q){
	int[] temp = q;
	int l = q.length - 1;
	while(l >= 0){
	    int h = temp[0];
	    temp[0] = temp[l];
	    temp[l] = h;
	    l--;
	    int b;
	    if(l % 2 == 0){
		b = l / 2;
	    }else{
		b = (l / 2) + 1;
	    }
	    int p = 0;
	    while(p < b){
		if(temp[p] < temp[(2 * p) + 1] || temp[p] < temp[2 * p]){
		    if(temp[(2 * p) + 1] < temp[2 * p]){
			int h = temp[2 * p];
			temp[2 * p] = temp[p];
			temp[p] = h;
			p = 2 * p;
		    }else{
			int h = temp[(2 * p) + 1];
			temp[(2 * p) + 1] = temp[p];
			temp[p] = h;
			p = (2 * p) + 1;
		    }
		}
	    }
	}
	return temp;
    }
}
