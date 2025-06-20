class Solution {
    public int solution(String s){
        int answer = s.length();
        for(int step = 1; step <= s.length() / 2; step++){
            StringBuilder sb = new StringBuilder();
            String curr = "";
            String prev = s.substring(0,step);
            int cnt = 1;
            for(int i = step; i < s.length(); i+=step){
                if(step + i <= s.length()){
                    curr = s.substring(i,i+step);
                }else {
                    curr = s.substring(i);
                }
                if(prev.equals(curr)){
                    cnt++;
                    continue;
                }else {
                    if(cnt > 1) {
                        sb.append(cnt).append(prev);
                        cnt = 1;
                    }else {
                        sb.append(prev);
                    }
                }
                prev = curr;
            }
            // 마지막 prev 처리
            if(cnt > 1){
                sb.append(cnt).append(prev);
            }else {
                sb.append(prev);
            }
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }
}