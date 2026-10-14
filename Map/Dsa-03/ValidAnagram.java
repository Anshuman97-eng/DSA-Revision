import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // Write your logic here
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }

            map.put(ch, map.get(ch) - 1);
        }


        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        boolean result = solution.isAnagram(s, t);

        System.out.println(result);
        // Expected output: true
    }
}
