public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

        // Write your solution here

        int left = 0;
        int right = 0;

        while(left < s.length() && right < t.length()){
            if(s.charAt(left) == t.charAt(right)){
                left++;
            }
            right++;
        }


        return left == s.length();
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        boolean result = isSubsequence(s, t);

        System.out.println(result);
    }
}