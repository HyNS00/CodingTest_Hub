import java.util.*;
import java.util.stream.*;
class Solution {
    private static String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<String> dict = new ArrayList<>(Arrays.asList(words.split("")));
    private List<Integer> list = new ArrayList<>();
    public int[] solution(String msg) {
        int i = 0;
        while(i < msg.length()){
            String curr = String.valueOf(msg.charAt(i));
            int j = i + 1;
            while(j < msg.length() && dict.contains(curr + msg.charAt(j))){
                curr += msg.charAt(j);
                j++;
            }
            list.add(dict.indexOf(curr)+1);
            if(j < msg.length()){
               dict.add(curr+msg.charAt(j));            
            }
            i = j;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}