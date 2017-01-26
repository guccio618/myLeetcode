import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class Other_Document_Dependency {
	public List<String> findDependency(Map<String, List<String>> map, String file) {
		List<String> ans = new ArrayList<String>();
		
		if(map.isEmpty() || file == null || file.length() == 0) {
			return ans;
		}
		
		Stack<String> stack = new Stack<String>();
		Set<String> visited = new HashSet<String>();
		stack.push(file);
		visited.add(file);
		
		while(!stack.isEmpty()) {
			String curFile = stack.pop();
			ans.add(curFile);
	
			if(!map.containsKey(curFile)) {
				continue;
			}
			
			for(String nextFile : map.get(curFile)) {			
				if(visited.contains(nextFile)) {
					continue;
				}
				
				visited.add(nextFile);
				stack.push(nextFile);
			}
		}
		
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap();
		
		List<String> list1 = new ArrayList<String>();
		list1.add("file2");
		list1.add("file3");
		list1.add("file5");
		map.put("file1", list1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("file9");
		list2.add("file10");
		list2.add("file12");
		map.put("file2", list2);
		
		List<String> list5 = new ArrayList<String>();
		list5.add("file6");
		list5.add("file7");
		map.put("file5", list5);
		
		List<String> list7 = new ArrayList<String>();
		list7.add("file8");
		map.put("file7", list7);
		
		List<String> list9 = new ArrayList<String>();
		list9.add("file11");
		list9.add("file12");
		map.put("file9", list9);
		
		
		Other_Document_Dependency t = new Other_Document_Dependency();
		String file = "file1";
		List<String> ans = t.findDependency(map, file);
		
		for(String f : ans) {
			System.out.print(f + ", ");
		}
		
	}
	
}

class Document {
	String name;
	List<Document> dependency;
	
	public Document(String name) {
		this.name = name;
		dependency = new ArrayList<Document>();
	}
}
