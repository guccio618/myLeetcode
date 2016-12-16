
public class Q157_Read_N_Characters_Given_Read4 {
	public int read(char[] buf, int n) {
        char[] readBuf = new char[4];
        int alreadyReadNum = 0;
        int currentReadNum = 0;
        
        while(alreadyReadNum < n){
            currentReadNum = read4(readBuf);
            
            if(currentReadNum == 0){
                break;
            }
            
            int len = Math.min(currentReadNum, n - alreadyReadNum);
            
            for(int i = 0; i < len; i++){
                buf[alreadyReadNum + i] = readBuf[i];
            }
            
            alreadyReadNum += len;
        }
        
        return alreadyReadNum;
    } 
	
	public int read4(char[] tempBuf){
		return 1;
	}
}
