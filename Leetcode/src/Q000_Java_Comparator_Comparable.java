import java.util.*;


public class Q000_Java_Comparator_Comparable {
	public static void testFunc() {
		Integer[] array1 = {6,2,8,5,9};
		Integer[] array2 = {6,2,8,5,9};
		Integer[] array3 = {6,2,8,5,9};
		
		Arrays.sort(array1, new myComparator());
		Arrays.sort(array2, new Comparator<Integer>(){
			@Override
			public int compare(Integer int1, Integer int2) {
				return int1 - int2;
			}
		});
		
		Queue<Integer> queue1 = new PriorityQueue<Integer>(5, new myComparator());
		Queue<Integer> queue2 = new PriorityQueue<Integer>(5, new Comparator<Integer>(){
			@Override
			public int compare(Integer int1, Integer int2) {
				return int1 - int2;
			}
		});
				
		for (int num : array3) {
			queue1.offer(num);
			queue2.offer(num);
		}
				
		System.out.println("array1: ");
		print(array1);
		System.out.println("array2: ");
		print(array2);
		System.out.println("queue1: ");
		print(queue1);
		System.out.println("queue2: ");
		print(queue2);
		
		
		Person[] array5 = new Person[5];
		array5[0] = new Person(6);
		array5[1] = new Person(2);
		array5[2] = new Person(8);
		array5[3] = new Person(5);
		array5[4] = new Person(9);
		
		Arrays.sort(array5);
		System.out.println("Person array5: ");
		print(array5);
		
	}
	
	public static void print(Integer[] array) {
		for (int num : array) {
			System.out.print(num + ", ");
		}
		System.out.println();
	}
	
	public static void print(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + ", ");
		}
		System.out.println();
	}
	
	public static void print(Person[] array) {
		for (Person p : array) {
			System.out.print(p.age + ", ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		testFunc();
	}
}



class myComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer int1, Integer int2) {
		return int1 - int2;
	}
}

class Person implements Comparable {
	int age;
	
	public Person(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Person p = (Person) o;
		return this.age - p.age;
	}
}



