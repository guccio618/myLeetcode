import java.util.ArrayList;
import java.util.List;
/********
 * 
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]

If there is no valid move, return an empty list [].

 * 
 * */

public class Le_293_Flip_Game {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        char[] letters = s.toCharArray();
        
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == '+' && letters[i + 1] == '+') {
                letters[i] = letters[i + 1] = '-';
                ans.add(new String(letters));
                letters[i] = letters[i + 1] = '+';
            }
        }
        
        return ans;
    }
}
