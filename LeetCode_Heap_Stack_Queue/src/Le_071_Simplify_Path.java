import java.util.Stack;


public class Le_071_Simplify_Path {
	public String simplifyPath(String path) {
        if(path.length() < 2){   // test case: [/], [/..], [///]
            return path;
        }
        
        String[] pathArray = path.split("/");
        Stack<String> s = new Stack<String>();
        int n = pathArray.length;
        
        for(int i = 0; i < n; i++){
            if(pathArray[i].equals("..") && !s.isEmpty()){
                s.pop();      // 注意"."表示当前路径，因此简化过程中可以忽略
            } else if(!pathArray[i].equals("..") && !pathArray[i].equals(".") && !pathArray[i].equals("")){
                s.push(pathArray[i]);
            }
        }
        
        if(s.isEmpty()){     // 防止 test case: [///]
            return "/";
        }
        
        path = "";
        while(!s.isEmpty()){
            path = "/" + s.pop() + path;
        }
        
        return path;
    }
}
