
public class Q13_multiThread {	
	public static void main(String[] args){
		myCurThread t1 = new myCurThread();
		Thread t2 = new Thread(new myRunnable());
		
		t1.start();
		t2.start();
	}
}

class myCurThread extends Thread{
	public void run(){
		System.out.println("running myThread");
	}
}

class myRunnable implements Runnable{
	public void run(){
		System.out.println("running myRunnable");
	}
}