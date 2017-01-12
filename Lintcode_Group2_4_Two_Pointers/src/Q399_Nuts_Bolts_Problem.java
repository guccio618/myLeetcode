
public class Q399_Nuts_Bolts_Problem {
	/**************************
	 * Star
	 **************************/
	// by ninechapter
	
	public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
        	return;
        }
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private void qsort(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
        if (start >= end) return;
        int partition_index = partition(nuts, bolts[start], compare, start, end);  // find the partition index for nuts with bolts[l]      
        partition(bolts, nuts[partition_index], compare, start, end);              // partition bolts with nuts[part_inx]
        qsort(nuts, bolts, compare, start, partition_index - 1);                   // qsort recursively
        qsort(nuts, bolts, compare, partition_index + 1, end);
    }

    private int partition(String[] str, String pivot, NBComparator compare, int left, int right) {
        int m = left;
        for (int i = left + 1; i <= right; i++) {
            if (compare.cmp(str[i], pivot) == -1 || compare.cmp(pivot, str[i]) == 1) {
                m++;
                swap(str, i, m);
            } else if (compare.cmp(str[i], pivot) == 0 || compare.cmp(pivot, str[i]) == 0) {              
                swap(str, i, left);    // swap nuts[l]/bolts[l] with pivot
                i--;
            }
        }       
        swap(str, m, left);            // move pivot to proper index
        return m;
    }

    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
    
    
    
    /************************** class NBComparator definition ***************************/
    class NBComparator {
    	public int cmp(String a, String b){
    		return a.compareTo(b);
    	}
	}
}
