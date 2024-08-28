class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            String tmp = String.format("%16s",Integer.toString((arr1[i]|arr2[i]),2));
            tmp = tmp.substring(tmp.length() - n);
            tmp = tmp.replace('0',' ').replace('1','#');
            answer[i] =tmp;
        }
        return answer;
    }
}