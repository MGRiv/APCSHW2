import java.util.*;
public class Sorts{
    
    public static int[] partition(int[] ary, int si, int ei){
	int[] copy = new int[ary.length];
	System.arraycopy(ary,0,copy,0,ary.length);
	Random rand = new Random();
	int i = rand.nextInt(ei - si) + si;
	System.out.println("(" + si + "," + ei +")");
	System.out.println(i);
	System.out.println(copy[i]);
	System.out.println(Arrays.toString(copy));
	int pivot = copy[i];
	int s = si;
	int e = ei;
	for(int q = s; q <= e; q++){
	    if(copy[q] != pivot){
		if(copy[q] > pivot){
		    ary[ei] = copy[q];
		    ei--;
		}else if(copy[q] < pivot){
		    ary[si] = copy[q];
		    si++;
		}
	    }
	}
	for(int q = si; q <= ei; q++){
	    ary[q] = pivot;
	}
	System.out.println(Arrays.toString(ary));
	int[] r = new int[2];
	r[0] = si;
	r[1] = ei;
	return r;
    }
    public static int quickselect(int[] ary, int pos){
	int[] q = partition(ary,0,ary.length - 1);
	return qsh(ary,0,ary.length - 1,q[0],pos);
    }
    public static int qsh(int[] ary, int si, int ei, int cpos, int pos){
	if(cpos == pos){
	    return ary[cpos];
	}else if(cpos > pos){
	    int[] q = partition(ary,si,cpos);
	    return qsh(ary,si,cpos,q[0],pos);
	}else{
	    int[] q = partition(ary,cpos,ei);
	    return qsh(ary,cpos,ei,q[0],pos);
	}
    }
    public static void Quicksort(int[]ary){
	Quicksorth(ary,0,ary.length - 1);
    }
    public static void Quicksorth(int[]ary,int si,int ei){
	if(si >= ei){
	    return;
	}
	int[] q = partition(ary,si,ei);
	Quicksorth(ary,si,q[0] - 1);
	Quicksorth(ary,q[1] + 1,ei);
    }
    public static void main(String[]args){
	Sorts q = new Sorts();
	int[] a = {4,8,9,3,2,1,5,6,0,7,7,7,7};
	q.Quicksort(a);
	System.out.println(Arrays.toString(a));
    }

}