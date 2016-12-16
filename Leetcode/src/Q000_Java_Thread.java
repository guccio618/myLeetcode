
public class Q000_Java_Thread {	
	public static void main(String[] args){
		for(int i = 0; i < 10000; ++i){
			new Thread(new Runner(i, "Jack1")).start();	 // 调用方法		
		}
		
		for(int i = 0; i < 10000; ++i){
			new MyThread(i, "Jack2").start();	 // 调用方法		
		}
	}
}

/**************   Runner   **************/
// Runner存放线程运行的实际操作内容，线程执行start()之后，
// 调用的是Runner里的run()函数
class Runner implements Runnable{
	private int id;
	private String name;
	
	public Runner(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public void run(){
		System.out.print("[name = " + name + ", id = " + id + "], ");
		System.out.println("thread num is: " + Thread.activeCount());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


/*************** 直接定义thread ********************/
class MyThread extends Thread {
	private int id;
	private String name;
	
	public MyThread(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void run() {
		System.out.print("[name = " + name + ", id = " + id + "], ");
		System.out.println("thread num is: " + Thread.activeCount());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


