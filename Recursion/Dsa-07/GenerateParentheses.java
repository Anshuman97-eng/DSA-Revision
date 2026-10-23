
import java.util.*;

public class GenerateParentheses {
    public static void solve(StringBuilder s,List<String> result,int n,int open,int close){
        if(s.length() == n*2){
            result.add(s.toString());
            return ;
        }

        if(open < n){
            s.append("(");
            solve(s, result, n, open+1, close);
            s.deleteCharAt(s.length() - 1);
        }

        if(close < open){
            s.append(")");
            solve(s, result, n, open, close+1);
            s.deleteCharAt(s.length() - 1);
        }


    }

    public List<String> generateParenthesis(int n) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        solve(s,result,n,0,0);

        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();

        int n = 3;

        List<String> result = solution.generateParenthesis(n);

        System.out.println(result);
        // Expected: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}
