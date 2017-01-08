import java.util.*;
/********
 * 
Write a function to generate the generalized abbreviations of a word.

Example:
	Given word = "word", return the following list (order does not matter):
	["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 * 
 * 
 * */

public class Q320_Generalized_Abbreviation {
	// using backtrack
	public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, word, 0, "", 0);
        return ans;
    }
    
    public void backtrack(List<String> ans, String word, int pos, String solution, int count) {
        if(pos == word.length()) {
            solution += (count > 0) ? count : "";
            ans.add(solution);
            return;
        }
        
        backtrack(ans, word, pos + 1, solution, count + 1);
        backtrack(ans, word, pos + 1, solution + (count > 0 ? count : "") + word.charAt(pos), 0);
    }
}
