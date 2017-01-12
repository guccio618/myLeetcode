
public class Q049_Sort_Letters_by_Case {
	// by Jackie
	public void sortLetters(char[] chars) {
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
	
	
    
    
    
	public static void print(char[] chars){
		for(int i = 0; i < chars.length; ++i){
			System.out.print(chars[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		char[] chars = {'a','b','A','c','D'};
		Q049_Sort_Letters_by_Case t = new Q049_Sort_Letters_by_Case();
		t.sortLetters(chars);
		t.print(chars);
	}
}
