class Solution {
    public int solution(int order) {
        int cnt = 0;
        char[] tmp = String.valueOf(order).toCharArray();
        for(char c : tmp){
            if(c == '3' || c == '6' || c == '9'){
                cnt++;
            }
        }
        return cnt;
    }
}