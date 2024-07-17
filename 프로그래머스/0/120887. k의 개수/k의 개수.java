import java.util.*;
class Solution {
    public int solution(int i, int j, int k) {
        List<String> list = new ArrayList<>();
        for(int num = i; num <= j; num++){
            String str = String.valueOf(num);
            list.add(str);
        }
        String tmp = String.join("",list);
        String strK = String.valueOf(k);
        int n = tmp.length();
        int m = tmp.replace(strK,"").length();
        return n-m;
        
    }
}