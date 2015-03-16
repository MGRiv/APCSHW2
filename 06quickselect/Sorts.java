import java.util.*;
public class Sorts{

    public static String name(){
	return "rivera.michael";
    }
    

    public static int partition(int[] ary, int si, int ei){
	Random rand = new Random();
	int i = rand.nextInt(ei - si) + si;
	//System.out.println("(" + si + "," + ei +")");
	//System.out.println(i);
	//System.out.println(ary[i]);
	//System.out.println(Arrays.toString(ary));
	int t = ary[ei];
	ary[ei] = ary[i];
	ary[i] = t;	
	for(int q = si; q <= ei; q++){
	    if(ary[q] < ary[ei]){
		t = ary[si];
		ary[si] = ary[q];
		ary[q] = t;
		si++;
	    }
	}
	t = ary[ei];
	ary[ei] = ary[si];
	ary[si] = t;

	//System.out.println(Arrays.toString(ary));

	return si;
    }
    public static int quickselect(int[] ary, int pos){
	int q = partition(ary,0,ary.length - 1);
	return qsh(ary,0,ary.length - 1,q,pos);
    }
    public static int qsh(int[] ary, int si, int ei, int cpos, int pos){
	if(cpos == pos){
	    return ary[cpos];
	}else if(cpos > pos){
	    int q = partition(ary,si,cpos);
	    return qsh(ary,si,cpos,q,pos);
	}else{
	    int q = partition(ary,cpos,ei);
	    return qsh(ary,cpos,ei,q,pos);
	}
    }
    public static void Quicksort(int[]ary){
	Quicksorth(ary,0,ary.length - 1);
    }
    public static void Quicksorth(int[]ary,int si,int ei){
	if(si >= ei){
	    return;
	}
	int q = partition(ary,si,ei);
	Quicksorth(ary,si,q - 1);
	Quicksorth(ary,q + 1,ei);
    }
    public static void main(String[]args){
	Sorts q = new Sorts();
	int[] a = {4,8,9,3,2,1,5,6,0,7,7,7,7};
	q.Quicksort(a);
	System.out.println(Arrays.toString(a));
    }

}
