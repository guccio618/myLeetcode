
public class Li_3_3_Singleton {
	// private的构造函数
	private static Li_3_3_Singleton instance = null;
	private Li_3_3_Singleton(){};
	
	// 普通模式
	public static Li_3_3_Singleton getInstance() {
		if (instance == null) {
			instance = new Li_3_3_Singleton();
		}
		return instance;
	}
	
	// 适用于多线程模式，高效
	public static Li_3_3_Singleton getInstance2() {
		if (instance == null) {
			lock();
			if (instance == null) {
				instance = new Li_3_3_Singleton();
			}
			unlock();
		}
		return instance;
	}
	
	
	
	public static void lock(){
		
	}
	
	public static void unlock(){
		
	}
}
