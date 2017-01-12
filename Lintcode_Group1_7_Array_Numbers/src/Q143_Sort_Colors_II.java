
public class Q143_Sort_Colors_II {
	// by Jackie
	public void sortColors2(int[] colors, int k) {
        if(colors == null || colors.length == 0 || k <= 0){
            return;
        }
        quickSort(colors, 0, colors.length - 1);
    }
    
    public void quickSort(int[] colors, int left, int right){
        if(left < right){
            double pivot = (colors[left] + colors[right]) / 2.0;
            int i = left, j = right;
            while(i < j){
                while(i < right && colors[i] < pivot){
                    i++;
                }
                while(j > left && colors[j] >= pivot){
                    j--;
                }
                if(i < j){
                    int temp = colors[i];
                    colors[i] = colors[j];
                    colors[j] = temp;
                }
            }
            
            if(j > left){
                quickSort(colors, left, j);
            }
            if(j + 1 < right){
                quickSort(colors, j + 1, right);
            }
        }
    }
}
