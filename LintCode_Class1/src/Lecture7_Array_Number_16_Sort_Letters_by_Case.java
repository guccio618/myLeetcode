
public class Lecture7_Array_Number_16_Sort_Letters_by_Case {
	/************************************************************************
	 * 
	 * 
	 ************************************************************************/
	
	public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
		char tmp ;
		while ( i <= j) {
			while (i <= j && Character.isLowerCase(chars[i]) ) i++;
			while (i <= j && Character.isUpperCase(chars[j]) ) j--;
			if (i <= j) {
				tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
				i++; j--;
			}
		}
		return ;
    }
	
	
	
	/************************************************************************
	 * change the char[] and then using quickSort
	 * 
	 ************************************************************************/
	
	public void sortLetters2(char[] chars) {
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] >'Z'){
                chars[i] -= 97;
            }
        }
        
        quickSort(chars, 0, chars.length - 1);
        
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] < 'A'){
                chars[i] += 97;
            }
        }
    }
    
    public void quickSort(char[] chars, int left, int right){
        if(left < right){
            int m = partition(chars, left, right);
            quickSort(chars, left, m - 1);
            quickSort(chars, m + 1, right);
        }
    }
    
    public int partition(char[] chars, int left, int right){
        int i = left - 1;
        char temp = ' ';
        char pivot = chars[right];
        
        for(int j = left; j < right; ++j){
            if(chars[j] <= pivot){
                i++;
                if(i != j){
                    temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
            }
        }
        temp = chars[i + 1];
        chars[i + 1] = chars[right];
        chars[right] = temp;
        return i + 1;
    }

}
