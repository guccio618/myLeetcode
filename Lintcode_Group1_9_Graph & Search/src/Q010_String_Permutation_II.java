import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q010_String_Permutation_II {
	// by Jackie
	public List<String> stringPermutation2(String str) {
        List<String> res = new ArrayList<String>();
        if(str == null){
            return res;
        }
        if(str.length() == 0){
            res.add(str);
            return res;
        }
        StringBuffer sb = new StringBuffer();
        boolean[] visited = new boolean[str.length()];
        char[] array = str.toCharArray();
        Arrays.sort(array);                    // 需要排除重复的时候，必须要先sort

        helper(array, sb, res, 0, visited);
        return res;
    }
    
    public void helper(char[] array, StringBuffer sb, List<String> res, int pos, boolean[] visited){
        if(sb.length() == array.length){
            res.add(sb.toString());
            return;
        }
       
        for(int i = 0; i < array.length; ++i){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            sb.append(array[i]);
            helper(array, sb, res, i, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
            while(i + 1 < array.length && array[i + 1] == array[i]){
            	i++;
            }
        }  
    }
    
    
    public static void main(String[] args){
    	Q010_String_Permutation_II t = new Q010_String_Permutation_II();
    	List<String> res = t.stringPermutation2("132");
    	for(int i = 0; i < res.size(); ++i){
    		System.out.print(res.get(i) + ", ");
    	}
    }
}
