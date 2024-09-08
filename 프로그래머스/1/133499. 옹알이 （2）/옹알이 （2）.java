class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya","ye","woo","ma"};
        int cnt = 0;
        for(String babble : babbling){
            String tmp = babble;
            boolean isValid = true;
            String last = "";
            while(!tmp.isEmpty()){
                boolean found = false;
                for(String word : words){
                    if(tmp.startsWith(word) && !last.equals(word)){
                        tmp = tmp.substring(word.length());
                        last = word;
                        found = true;
                    }
                }
                if(!found){
                    isValid = false;
                    break;
                }
            }
            if(isValid) cnt++;
        }
        return cnt;
    }
}