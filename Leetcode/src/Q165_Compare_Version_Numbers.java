
public class Q165_Compare_Version_Numbers {
	/******************************************************/
	// by Jackie
	public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            if(version1 == null && version2 == null){
                return 0;
            } else if(version1 == null && version2.length() > 0){
                return -1;
            } else if(version1.length() > 0 && version2 == null){
                return 1;
            }
        }
        
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int index1 = 0, len1 = array1.length;
        int index2 = 0, len2 = array2.length;
        
        while(index1 < len1 || index2 < len2){
            if(index1 < len1 && index2 < len2){
                int num1 = Integer.parseInt(array1[index1]);
                int num2 = Integer.parseInt(array2[index2]);
                
                if(num1 > num2){
                    return 1;
                } else if(num1 < num2){
                    return -1;
                } else ;
                
                index1++;
                index2++;
            } else if(index1 < len1 && index2 >= len2){
                int num = Integer.parseInt(array1[index1]);
                
                if(num > 0){
                    return 1;
                } else {
                    index1++;
                }
            } else {
                int num = Integer.parseInt(array2[index2]);
                
                if(num > 0){
                    return -1;
                } else {
                    index2++;
                }
            }
        }
        
        return 0;
    }
	
	
	
	/******************************************************/
	// by Jackie
	public int compareVersion2(String version1, String version2) {
        if(version1 == null || version1.length() == 0){
            if(version2 == null || version2.length() == 0){
                return 0;
            } else {
                return -1;
            }
        } else if(version2 == null || version2.length() == 0){
            return 1;
        }
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0, index2 = 0, n1 = v1.length, n2 = v2.length;
        
        while(index1 < n1 && index2 < n2){
            int num1 = Integer.parseInt(v1[index1++]);
            int num2 = Integer.parseInt(v2[index2++]);
            
            if(num1 > num2){
                return 1;
            } else if(num1 < num2){
                return -1;
            }
        }
        
        if(index1 < n1){
        	while(index1 < n1){
            	if(Integer.parseInt(v1[index1]) != 0){
            		return 1;
            	} else {
            		index1++;
            	}
            }
        	return 0;
        } else if(index2 < n2){
        	while(index2 < n2){
            	if(Integer.parseInt(v2[index2]) != 0){
            		return -1;
            	} else {
            		index2++;
            	}
            }
        	return 0;
        } else {
        	return 0;
        }
    }
	
	
	/******************************************************/
	// by other
	public int compareVersion3(String version1, String version2) {
        if(version1.length() == 0) return -1;
        if(version2.length() == 0) return 0;
        String str1 = "", str2 = "";
        int i = 0, j = 0, num1 = 0, num2 = 0;
        
        while(i < version1.length() || j < version2.length()){
        	str1 = "";
        	while(i < version1.length() && version1.charAt(i) != '.')
        		str1 += version1.charAt(i++);
        	if(i <= version1.length()) num1 = Integer.parseInt(str1);
        	else num1 = 0;
        	System.out.println("num1 = " + num1);
        	str2 = "";
        	while(j < version2.length() && version2.charAt(j) != '.')
        		str2 += version2.charAt(j++);
        	if(j <= version2.length()) num2 = Integer.parseInt(str2);
        	else num2 = 0;
        	System.out.println("num1 = " + num1 + ", num2 = " + num2);
        	if(num1 > num2) return 1;
        	if(num1 < num2) return -1;
        	else{i++; j++;}        	
        }
        System.out.println("i = " + i + ", j = " + j);
        num1 = (str1.equals("") == true) ? 0 : Integer.parseInt(str1);
        num2 = (str2.equals("") == true) ? 0 : Integer.parseInt(str2);
        if(num1 > num2) return 1;
        if(num1 < num2) return -1;
        else return 0;
    }
	
	public static void main(String[] args){
		Q165_Compare_Version_Numbers c = new Q165_Compare_Version_Numbers();
		System.out.println(c.compareVersion("012", "1.0.0"));
		System.out.println(c.compareVersion("1", "1.0.0"));
	}
}
