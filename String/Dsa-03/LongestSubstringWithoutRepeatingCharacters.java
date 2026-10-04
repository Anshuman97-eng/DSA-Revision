import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        // Write your solution here
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;

       for(int right=0 ; right<s.length() ; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen,right-left+1);
        }


        return maxLen;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println(result);
    }
}