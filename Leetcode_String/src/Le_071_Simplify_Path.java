import java.util.Stack;

/*******************************************
  (1). String.split & String.join    
              
/*******************************************/

//by jackie
public class Le_071_Simplify_Path {
	public String simplifyPath(String path) { 
		if(path.length() < 2) {
			return path;
		}
		
        Stack<String> stack = new Stack<String>();
		for (String s : path.split("/")) {
			if (s.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!s.equals(".") && !s.equals("..") && !s.equals("")) {
				stack.push(s);
			}
		}
		
		if(stack.isEmpty()) {
			return "/";
		}
		
        path = "";
		while(!stack.isEmpty()){
			path = '/' + stack.pop() + path;
		}
		return path;
	}
	
	public String simplifyPath_2(String path) { //by other using String.join
	    Stack<String> stack = new Stack<String>();
	    for (String s : path.split("/")) {
	        if (s.equals("..") && !stack.isEmpty())
	            stack.pop();
	        else if (!s.equals(".") && !s.equals("..") && !s.equals(""))
	            stack.push(s);
	    }
	    return "/" + String.join("/", stack);
	}

	public String simplifyPath_3(String path) {  //by other
		StringBuffer rst = new StringBuffer();
		int index = 0;
		String[] strings = path.split("/");
		for (String item : strings) {
			if (item.equals("..")) {
				if (index > 0)
					index--;
			} 
			else if ((item.equals(".")) || (item.equals(""))); //do nothing
			else {
				strings[index] = item;
				index++;
			}
		}
		int length = index;
		while (0 != index) {
			rst.append("/");
			rst.append(strings[length - index]);
			index--;
		}	
		return (rst.toString().equals("")) ? "/" : rst.toString();
	}
	
	public static void main(String[] args){
		Le_071_Simplify_Path s = new Le_071_Simplify_Path();
		String str = "/a/./b/../../c/";
		System.out.println(s.simplifyPath(str));
		System.out.println(s.simplifyPath_2(str));
	}
}
