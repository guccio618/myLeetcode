import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class P1_Kclose {
	public static Cpoint[] findKClose_Heap(Cpoint[] list, int k) {
		if (list == null || list.length == 0 || k <= 0 || k > list.length) {
			return new Cpoint[0];
		} 

		Cpoint[] res = new Cpoint[k];
		
		PriorityQueue<Cpoint> maxHeap = new PriorityQueue<>(k, new Comparator<Cpoint>() {
			@Override
			public int compare(Cpoint p1, Cpoint p2) {
				return -Double.compare(Math.sqrt(p1.x*p1.x + p1.y * p1.y), Math.sqrt(p2.x * p2.x + p2.y * p2.y));
			}
		});

		for (int i = 0; i < list.length; i++) {
			maxHeap.offer(list[i]);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		for (int i = res.length - 1; i >= 0 && !maxHeap.isEmpty(); i--) {
			res[i] = maxHeap.poll();
		}

		return res;
	}


	
	
	
	public static Cpoint[] findKClose_Sort(Cpoint[] list, int k) {
		if (list == null || list.length == 0 || k <= 0 || k > list.length) {
			return new Cpoint[0];
		} 
		
		Cpoint[] tempList = new Cpoint[list.length];
		
		for(int i = 0; i < list.length; i++) {
			tempList[i] = list[i];
		}
				
		Arrays.sort(tempList, new Comparator<Cpoint>() {
			@Override
			public int compare(Cpoint p1, Cpoint p2) {
				return Double.compare(p1.x * p1.x + p1.y * p1.y, p2.x * p2.x + p2.y * p2.y);
			}
		});
		
		Cpoint[] ans = new Cpoint[k];
		
		for(int i = 0; i < k; i++) {
			ans[i] = tempList[i];
		}
		
		return ans;
	}
	
	
	
	
	
	
	

	
	
	/*******************************************/
	public static void main(String[] args) {
		Cpoint[] list = new Cpoint[7];
		int k = 3;
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = new Cpoint(-i-1, i+1);
		}

		Cpoint[] array = findKClose_Heap(list, k);
		
		for(Cpoint p : array) {
			System.out.println(p.toString());
		}
		
		
		
//		Double a = (double) 3;
//		Double b = (double) 5;
//		System.out.println(Double.compare(a, b));
	}
}

class Cpoint {
	double x;
	double y;

	public Cpoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "X: " + x + ", Y: " + y;
	}
}
