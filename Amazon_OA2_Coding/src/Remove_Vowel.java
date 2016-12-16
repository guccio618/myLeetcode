
public class Remove_Vowel {
	public String removeVowel(String str){
		if(str == null || str.length() == 0){
			return "";
		}
		
		String vowels = "aeiouAEIOU";
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			
			if(vowels.indexOf(c) > -1){
				continue;
			} else {
				builder.append(c);
			}
		}
		
		return builder.toString();
	}
	
	
	
	
	
	public String removeVowel2(String str){
		if(str == null || str.length() == 0){
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		String v = "aeiouAEIOU";
		
		for(int i = 0; i < str.length(); i++){
			if(v.indexOf(str.charAt(i)) > -1) {
				continue;
			}
			
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args){
		Remove_Vowel t = new Remove_Vowel();
		String str = "sfefsadfsdfesegase";
		System.out.println(t.removeVowel(str));
		System.out.println(t.removeVowel2(str));
	}
}
