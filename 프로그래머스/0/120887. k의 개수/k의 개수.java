import java.util.*;
class Solution {
    public int solution(int i, int j, int k) {
        List<String> list = new ArrayList<>();
        for(int num = i; num <= j; num++){
            String str = String.valueOf(num);
            list.add(str);
        }
        String tmp = String.join("",list);
        int n = tmp.length();
        int m = tmp.replace(String.valueOf(k),"").length();
        return n-m;
        
    }
}