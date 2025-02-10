class Solution {
    private StringBuilder total = new StringBuilder();
    private StringBuilder result = new StringBuilder();
    int num = 0;
    public String solution(int n, int t, int m, int p) {
        // 게임에서 총 말해야하는 전체 숫자 -> m * t
        // 튜브가 말해야하는 숫자 t에 인원 수 생각
        
        while(num < m * t){
            total.append(Integer.toString(num,n).toUpperCase());
            num++;
        }
        
        for(int idx = p-1; idx < total.length() && result.length() < t; idx += m){
            result.append(String.valueOf(total.charAt(idx)));
        }
        return result.toString();
    }
}