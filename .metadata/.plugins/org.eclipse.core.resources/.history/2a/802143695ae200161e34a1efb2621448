/********
 * 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * 
 * */

public class Q038_Count_and_Say {
	public String countAndSay(int n) {
		if (n <= 0) {
			return new String();
		}

		String ans = Integer.toString(1);

		for (int i = 1; i < n; i++) {
			ans = getStr(ans);
		}

		return ans;
	}

	public String getStr(String num) {
		char[] array = num.toCharArray();
		StringBuilder builder = new StringBuilder();
		int len = array.length;
		int front = 0, back = 0, count = 0;

		while (front < len) {
			if (array[front] == array[back]) {
				front++;
				count++;
			} else {
				builder.append(count).append(array[back]);
				back = front;
				count = 0;
			}
		}
		
		builder.append(count).append(array[back]);
		return builder.toString();
	}

	
	
	
	
	
	
	
	
	
	
	/******************* main function *******************/
	public String countAndSay2(int n) {
		if (n <= 0) {
			return "-1";
		}

		String result = "1";

		for (int i = 1; i < n; i++) {
			result = build2(result);
		}
		return result;
	}

	private String build2(String result) {
		StringBuilder builder = new StringBuilder();
		int index = 0;
		while (index < result.length()) {
			char val = result.charAt(index);
			int count = 0;

			while (index < result.length() && result.charAt(index) == val) {
				index++;
				count++;
			}

			builder.append(String.valueOf(count));
			builder.append(val);
		}

		return builder.toString();
	}


	public String countAndSay3(int n) {
		if (n == 1) {
			return "1";
		}

		String prevStr = countAndSay2(n - 1);
		StringBuffer sb = new StringBuffer();
		int count = 0;
		int ptr = 0;

		while (ptr < prevStr.length()) {
			count++;
			char curChar = prevStr.charAt(ptr);
			if (ptr + 1 >= prevStr.length()
					|| curChar != prevStr.charAt(ptr + 1)) {
				sb.append(count).append(curChar);
				count = 0;
			}
			ptr++;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Q038_Count_and_Say t = new Q038_Count_and_Say();
		System.out.println(t.countAndSay(5));
	}
}
