
public class Lecture1_String_01_strStr {
	/********************************************************************************************************
	 * String
	 * 		(1). 两个指针跑，front and back;
	 * 		
	 ********************************************************************************************************/
	
	public int strStr(String source, String target) {
        if(source == null || target == null) {
            return -1;
        }
        if(source.length() < target.length()){
            return -1;
        }
        if(source.length() == 0 || target.length() == 0){
            return 0;
        }
        
        int sLen = source.length(), tLen = target.length();
        for(int i = 0; i < sLen - tLen + 1; ++i){   // 只要判断到这个位置：sLen - tLen + 1
            int j = 0;
            for( ; j < tLen; ++j){
                if(source.charAt(i+j) != target.charAt(j))
                    break;
            }
            if(j == tLen){
                return i;
            }
        }
        return -1;
    }
}
