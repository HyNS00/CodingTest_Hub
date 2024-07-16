class Solution {
    public int solution(int[] array) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int num : array){
            sb.append(String.valueOf(num));
        }
        String[] tmp = sb.toString().split("");
        for(String str : tmp){
            if(str.equals("7")){
                cnt++;
            }
        }
        return cnt;
    }
}