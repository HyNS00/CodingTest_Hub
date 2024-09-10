class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;
        char first = s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(first == c){
                same++;
            }else{
                diff++;
            }
            if(same == diff && i+1 < s.length()){
                answer++;
                same = 0;
                diff = 0;
                first = s.charAt(i+1);
            }else if(i == s.length()-1){
                answer++;
            }
        }
        return answer;
    }
}