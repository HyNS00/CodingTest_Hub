class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i = 0; i< targets.length; i++){
            String target = targets[i];
            for(char c : target.toCharArray()){
                int minidx = Integer.MAX_VALUE;
                for(String key : keymap){
                    int idx = key.indexOf(c);
                    if(idx > -1 && minidx > idx){
                        minidx = idx;
                    }
                }
                if(answer[i] != -1 && minidx < Integer.MAX_VALUE){
                    answer[i] += minidx+1;
                }else{
                    answer[i] = -1;
                }
            }
        }
        return answer;
    }
}