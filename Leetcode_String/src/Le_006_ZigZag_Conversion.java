
public class Le_006_ZigZag_Conversion {
	public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 0){
            return new String();
        } else if(numRows == 1){
            return s;
        }
        
        int n = s.length();
        StringBuffer[] builders = new StringBuffer[numRows];
        int pos = 0;
        
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuffer();
        }
        
        while(pos < n){
            for(int i = 0; i < numRows && pos < n; i++){
                builders[i].append(s.charAt(pos));
                pos++;
            }
            
            for(int i = numRows - 2; i > 0 && pos < n; i--){
                builders[i].append(s.charAt(pos));
                pos++;
            }
        }
        
        
        for(int i = 1; i < numRows; i++){
            builders[0].append(builders[i]);
        }
        
        return builders[0].toString();
    }
}
