import java.util.*;
/*********
 * 
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, 
it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,
	Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
	Return: ["AAAAACCCCC", "CCCCCAAAAA"].
		
 * 
 * */


public class Le_187_Repeated_DNA_Sequences {
	// test case:
    // s is empty or s.length is smaller than 10
	
	// solution 1: using hashset and bit manipulation， time is O(n), space is O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        
        int[] hash = new int[26];
        hash['C' - 'A'] = 1;
        hash['G' - 'A'] = 2;
        hash['T' - 'A'] = 3;
        int sequenceCode = 0;
        int mask = 0xfffff;       // 10 characters which will take 20 bits and 2 bit for each
        Set<Integer> visited = new HashSet<>();
        Set<String> duplicated = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            sequenceCode <<= 2;   // plus 4, because the base is 4
            sequenceCode |= hash[s.charAt(i) - 'A'];
            
            if(i < 9){
                continue;
            }
            
            sequenceCode &= mask;
            
            if(!visited.add(sequenceCode)) {
                duplicated.add(s.substring(i - 9, i + 1));
            }
        }
        
        return new ArrayList<String>(duplicated);
    }
	
	
    
	// solution 2: using two hashset
	public List<String> findRepeatedDnaSequences2(String s) {
        if(s == null || s.length() <= 10){
            return new ArrayList<String>();
        }
        
        int n = s.length();
        Set<String> visited = new HashSet<String>();
        Set<String> duplicated = new HashSet<String>();
        
        for(int i = 0; i <= n - 10; ++i){
            String subStr = s.substring(i, i + 10);
            
            if(!visited.add(subStr)) {
            	duplicated.add(subStr);
            }
        }
        
        return new ArrayList<String>(duplicated);
    }

	
	
	
	
	
	
	
	
	
	
	/********************************* main function *******************************/
	public static void main(String[] args){
		Le_187_Repeated_DNA_Sequences t = new Le_187_Repeated_DNA_Sequences();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s2 = "AAAAAAAAAAAA";
		List<String> res = t.findRepeatedDnaSequences2(s);
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
	}
}
