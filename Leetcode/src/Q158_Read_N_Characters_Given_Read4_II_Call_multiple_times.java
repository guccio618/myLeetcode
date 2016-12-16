/***************************************************************************
 * 此题是157的follow up, 需要将currentReadByte，currentHaveRead， tempBuf全局化
 * 
 ***************************************************************************/



public class Q158_Read_N_Characters_Given_Read4_II_Call_multiple_times {
	private int currentTotalRead = 0;     // 设置成全局变量，防止上一次读取read4，没有全部用掉
    private int currentHaveRead = 0;      // 偏移位，用于记录已经读取到了哪一位置，用于和currentTotalRead进行比较 
    private char[] tempBuf = new char[4];  
    
    public int read(char[] buf, int n) {
        int alreadyRead = 0;
        
        while(alreadyRead < n){
            if(currentHaveRead == currentTotalRead){
                currentHaveRead = 0;
                currentTotalRead = read4(tempBuf);
            }
        
            if(currentTotalRead == 0){
                break;
            }
            
            while(alreadyRead < n && currentHaveRead < currentTotalRead){
                buf[alreadyRead++] = tempBuf[currentHaveRead++];
            }
        }
        
        return alreadyRead;
    }
    
    public int read4(char[] tempBuf){
    	return 1;
    }
}
