
import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // Write your logic here
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();


        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        result.addAll(map.values());

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = solution.groupAnagrams(strs);

        System.out.println(result);
        // Expected groups: [eat, tea, ate], [tan, nat], [bat]
    }
}
