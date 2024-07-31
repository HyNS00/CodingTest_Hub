class Solution {
    public int solution(String A, String B) {
        String stand = A;
        int cnt = 0;
        if(stand.equals(B)){
            return 0;
        }
        for(int i = 0; i < stand.length(); i++){
            String first = stand.substring(stand.length()-1); // 마지막
            String left = stand.substring(0, stand.length()-1); // 처음부터 ~마지막전
            stand = first + left;
            cnt++;
            if(stand.equals(B)){
                return cnt;
            }
        }
        return -1;
    }
}