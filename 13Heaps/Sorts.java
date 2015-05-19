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
	int l = q.length - 1;
	while(l > 0){
	    int which;
	    if((l + 1) % 2 == 0){
		which = (l + 1) / 2;
	    }else{
		which = (l) / 2;
	    }
	    if(tem[l] > tem[which - 1]){
		int temp = tem[which - 1];
		tem[which - 1] = tem[l];
		tem[l] = temp;
	    }
	    l--;
	}
	return tem;
    }
    public static int[] organize(int[]q){
	int[] temp = q;
	int l = q.length - 1;
	while(l >= 0){
	    int h = temp[0];
	    temp[0] = temp[l];
	    temp[l] = h;
	    l--;
	    int b;
	    if((l + 1) % 2 == 0){
		b = (l / 2) + 1;
	    }else{
		b = (l / 2);
	    }
	    int p = 0;
	    while(p < b){
		if(temp[p] < temp[(2 * (p + 1))] || temp[p] < temp[(2 * (p + 1)) - 1]){
		    if(temp[(2 * (p + 1))] > temp[(2 * (p + 1)) - 1]){
			h = temp[(2 * (p + 1))];
			temp[(2 * (p + 1))] = temp[p];
			temp[p] = h;
			p = 2 * (p+1);
		    }else{
			h = temp[(2 * (p + 1)) - 1];
			temp[(2 * (p + 1)) - 1] = temp[p];
			temp[p] = h;
			p = (2 * (p + 1)) - 1;
		    }
		}
	    }
	}
	return temp;
    }
    public static void main(String[]args){
	int[] a = {6,21,5,8,31,0,76,2,9,12};
	System.out.println(Arrays.toString(a));
	heapsort(a);
	System.out.println(Arrays.toString(a));
    }
}
