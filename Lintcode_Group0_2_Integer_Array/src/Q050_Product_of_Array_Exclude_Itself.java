import java.util.ArrayList;

public class Q050_Product_of_Array_Exclude_Itself {
	// by Jackie
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> list) {
        ArrayList<Long> res = new ArrayList<Long>();
        if(list == null || list.size() == 0){
            return res;
        }
        if(list.size() == 1){
            long n = 1;
            res.add(n);
            return res;
        }
        
        int len = list.size();
        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        dp1[0] = list.get(0);
        dp2[len - 1] = list.get(len - 1);
        
        for(int i = 1; i < len; ++i){
            dp1[i] = dp1[i - 1] * list.get(i);
        }
        
        for(int i = len - 2; i >= 0; --i){
            dp2[i] = dp2[i + 1] * list.get(i);
        }
        
        res.add(dp2[1]);
        for(int i = 1; i < len - 1; ++i){
            res.add(dp1[i - 1] * dp2[i + 1]);
        }
        res.add(dp1[len - 2]);
        return res;
    }
}
