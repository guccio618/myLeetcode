
public class Q383_Ransom_Note {
	// by Jackie
	public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() == 0){
            return true;
        } else if(magazine == null || magazine.length() == 0){
            return false;
        } else if(ransomNote.length() > magazine.length()){
            return false;
        }
        
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        
        for(int c : ransomNote.toCharArray()){
            hash1[c]++;
        }
        
        for(int c : magazine.toCharArray()){
            hash2[c]++;
        }
        
        for(int i = 0; i < 256; i++){
            if(hash1[i] > hash2[i]){
                return false;
            }
        }
        
        return true;
    }
}
