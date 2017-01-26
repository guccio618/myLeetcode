import org.omg.CORBA.BooleanSeqHelper;


public class Multi_Thread {
	
}

class myThread extends Thread{
	public void run(int count){
		System.out.println("count = " + count);
	}
}

class Locks {
	boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;
	
	public synchronized void lock() throws InterruptedException{
		Thread callingThread = Thread.currentThread();
		
		while(isLocked && lockedBy != callingThread){
			wait();
		}
		
		isLocked = true;
		lockedBy = callingThread;
		lockedCount++;
	} 
	
	public synchronized void unlock(){
		
	} 
}


