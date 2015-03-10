import java.util.*;
public class QuickSelect{

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
    public static void main(String[]args){
	QuickSelect q = new QuickSelect();
	int[] a = {4,8,9,3,2,1,5,6,0,7};
	System.out.println(q.quickselect(a,7));
    }

}
