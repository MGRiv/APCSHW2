import java.util.*;

public class Sorts{

    public static String name(){
	return "rivera.michael";
    }
    public static void heapsort(int[]q){
	int[] a = orderheap(q);
	//System.out.println(Arrays.toString(a));
	q = organize(a);
    }
    public static int[] orderheap(int[]q){
	int[] tem = q;
	int l = q.length;
	while(l > 1){
	    int which;
	    if(l % 2 == 0){
		which = l / 2;
	    }else{
		which = (l - 1) / 2;
	    }
	    if(tem[l - 1] > tem[which - 1]){
		int temp = tem[which - 1];
		tem[which - 1] = tem[l - 1];
		tem[l - 1] = temp;
	    }
	    l--;
	}
	return tem;
    }
    public static int[] organize(int[]q){
	int[] temp = q;
	int l = q.length;
	while(l > 1){
	    int h = temp[0];
	    temp[0] = temp[l - 1];
	    temp[l - 1] = h;
	    int c = 0;
	    while(c < (l - 1)){
		if((2 * (c + 1)) < l && ((2 * (c + 1)) + 1) < l){
		    if(temp[(2 * (c + 1)) - 1] > temp[(2 * (c + 1))]){
			int t = temp[c];
			temp[c] = temp[(2 * (c + 1)) - 1];
			temp[(2 * (c + 1)) - 1] = t;
			c = (2 * (c + 1)) - 1;
		    }else{
			int t = temp[c];
			temp[c] = temp[(2 * (c + 1))];
			temp[(2 * (c + 1))] = t;
			c = (2 * (c + 1));
		    }
		}else if((2 * (c + 1)) < l){
			int t = temp[c];
			temp[c] = temp[(2 * (c + 1)) - 1];
			temp[(2 * (c + 1)) - 1] = t;
			c = (2 * (c + 1)) - 1;
		}else if(((2 * (c + 1)) + 1) < l){
		    int t = temp[c];
		    temp[c] = temp[(2 * (c + 1))];
		    temp[(2 * (c + 1))] = t;
		    c = (2 * (c + 1));
		}else{
		    break;
		}
	    }
	    l--;
	    //System.out.println(Arrays.toString(temp));
	}
	return temp;
    }
    public static void main(String[]args){
	int[] a = {6,21,5,8,31,0,76,3,9,12};
	//System.out.println(Arrays.toString(a));
	heapsort(a);
	System.out.println(Arrays.toString(a));
    }
}
