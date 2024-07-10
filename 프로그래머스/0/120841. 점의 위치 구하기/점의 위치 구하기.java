class Solution {
    public int solution(int[] dot) {
        // 사분면
        // dot의 길이는 2
        // dot[0] =x, dot[1]= y
        int result = 0;
        if(dot[0] > 0){
            if(dot[1] < 0){
                return result = 4;
            }
             return result = 1;
        }else  {
            if(dot[1] < 0){
                return result = 3;
            }
            return result = 2;
        }
    }
   
}