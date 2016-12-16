
public class Le_157_Read_N_Characters_Given_Read4 {
	public int read(char[] buf, int n) {
        int readByte = 0;
        char[] tempBuf = new char[4];
        int currentReadByte = 0;
        
        while(readByte < n){
            currentReadByte = read4(tempBuf);
            if(currentReadByte == 0){
                break;
            }
            int len = Math.min(currentReadByte, n - readByte);
            
            for(int i = 0; i < len; i++){
                buf[readByte + i] = tempBuf[i];
            }
            readByte += len;
        }
        
        return readByte;
    }
	
	public int read4(char[] tempBuf){
		return 1;
	}
}
