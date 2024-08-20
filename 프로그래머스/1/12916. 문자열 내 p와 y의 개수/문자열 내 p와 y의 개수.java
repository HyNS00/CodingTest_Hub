class Solution {
    boolean solution(String s) {
        String tmp = s.toUpperCase();
        int a = tmp.replace("P","").length();
        int b = tmp.replace("Y","").length();
        
        return a == b ? true : false;
    }
}