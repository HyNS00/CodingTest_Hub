class Solution {
    public int solution(int num, int k) {
        String[] numStr = String.valueOf(num).split("");
        String kStr = String.valueOf(k);
        int answer = -1;
        for(int i = 0; i < numStr.length; i++){
            if(numStr[i].equals(kStr)){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}