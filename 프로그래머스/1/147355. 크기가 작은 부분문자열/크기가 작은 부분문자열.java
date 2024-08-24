class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        int n = p.length();
        long min = Long.parseLong(p);
        for(int i = 0; i < t.length() - n +1; i++){
            String tmp = t.substring(i, i+n);
            if(Long.parseLong(tmp) <= min){
                cnt++;
            }   
        }
        return cnt;
    }
}