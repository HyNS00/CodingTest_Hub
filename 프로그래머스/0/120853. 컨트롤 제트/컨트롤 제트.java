class Solution {
    public int solution(String s) {
        String[] tmp = s.split(" ");
        int sum = 0;
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i].equals("Z")){
                sum -= Integer.parseInt(tmp[i-1]);
                continue; // z가 되었을 경우 다음으로 넘어가는 걸 꼭 생각하자.
            }
            sum += Integer.parseInt(tmp[i]);
            // else로 했었어도 나쁘지 않았을 것 같다.
        }
        return sum;
    }
}