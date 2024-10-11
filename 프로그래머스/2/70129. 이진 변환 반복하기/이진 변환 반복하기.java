class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int totalRemove = 0;
        while(s.length() != 1){
            int remove = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    remove++;
                }
            }
            totalRemove += remove;
            int n = s.length() - remove;
            s = Integer.toString(n,2);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = totalRemove;
        return answer;
    }
}