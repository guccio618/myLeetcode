
public class Q393_UTF8_Validation {
	private int start = 0;
	
	public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0){
        	return true;
        }
        
        int len = data.length;
        int[] validData = new int[len];
        
        for(int i = 0; i < len; i++){
        	for(int j = 0; j < 8; j++){
        		validData[i] |= ( (1 << j) & data[i] );
        	}
        }
        
        while(start < len){       	
        	if(isValid(validData) == false){
        		return false;
        	} 
        }
        
        return true;
    }
	
	public boolean isValid(int[] validData){
		int count = 0;
		int len = validData.length;
		
		for(int i = 7; i >= 0; i--){
        	if( (validData[start] >> i & 1) == 1 ){
        		count++;
        	} else {
        		break;
        	}
        }
        
        if(count == 0){
        	return (validData[start++] >> 7 & 1) == 0;
        } else if(count == 1){
        	return false;
        } else if(start + count > len){
        	return false;
        } 
   
        for(int i = start + 1; i <= start + count - 1; i++){
        	if( (validData[i] >> 7 & 1) != 1 || (validData[i] >> 6 & 1) == 1 ){
        		return false;
        	}
        }
        
        start = start + count;
        return true;
	}
	
	
	
	public static void main(String[] args){
		Q393_UTF8_Validation t = new Q393_UTF8_Validation();
		int[] data1 = {197, 130, 1};
		int[] data2 = {235, 140, 4};
		int[] data3 = {230,136,145};
		int[] data4 = {240,130,138,147,145};
		System.out.println(t.validUtf8(data3));
	}
}
