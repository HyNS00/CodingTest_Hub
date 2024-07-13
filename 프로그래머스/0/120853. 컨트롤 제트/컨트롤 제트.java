class Solution {
    public int solution(String s) {
        String[] tmp = s.split(" ");
        int sum = 0;
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i].equals("Z")){
                sum -= Integer.parseInt(tmp[i-1]);
                continue;
            }
            sum += Integer.parseInt(tmp[i]);
        }
        return sum;
    }
}