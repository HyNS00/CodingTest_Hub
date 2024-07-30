class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya","ye","woo","ma"};
        int cnt = 0;
        // replace로 대체
        for(String babble : babbling){
            String tmp = babble;
            for(String word: words){
                tmp = tmp.replace(word," ");
            }
            if(tmp.trim().isEmpty()){
                cnt++;
            }
        }
        return cnt;
    }
}