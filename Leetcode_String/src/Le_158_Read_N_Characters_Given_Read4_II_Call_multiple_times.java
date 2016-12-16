/***************************************************************************
 * 此题是157的follow up, 需要将currentReadByte，currentHaveRead， tempBuf全局化
 * 
 ***************************************************************************/



public class Le_158_Read_N_Characters_Given_Read4_II_Call_multiple_times {
	private int currentReadByte = 0;     // 设置成全局变量，防止上一次读取read4，没有全部用掉
    private int currentHaveRead = 0;
    private char[] tempBuf = new char[4];  
    
    public int read(char[] buf, int n) {
        int readByte = 0;
        
        while(readByte < n){
            if(currentHaveRead == 0){
                currentReadByte = read4(tempBuf);
            }
            
            if(currentReadByte == 0){
                break;
            }
            
            while(readByte < n && currentHaveRead < currentReadByte){
                buf[readByte++] = tempBuf[currentHaveRead++];
            }
            
            if(currentHaveRead >= currentReadByte){
                currentHaveRead = 0;
            }
        }
        
        return readByte;
    }
    
    public int read4(char[] tempBuf){
    	return 1;
    }
}
