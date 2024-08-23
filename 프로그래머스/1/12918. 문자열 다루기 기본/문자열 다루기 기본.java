class Solution {
    public boolean solution(String s) {
        // 길이가 4혹은 6
        String tmp = s.replaceAll("[^0-9]",""); // 알파벳제외
        boolean a =tmp.length() == s.length() && (tmp.length() == 4 || tmp.length() == 6);
        return a;
    }
}