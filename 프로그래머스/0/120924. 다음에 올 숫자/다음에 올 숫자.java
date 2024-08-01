class Solution {
    public int solution(int[] common) {
        int n = common.length;
        int diff = common[1] - common[0];
        if(common[2] - common[1] == diff){
            return common[n-1] + diff;
        }else{
            if(common[0] == 0){
                int ratio = common[2]/common[1];
                return common[n-1] * ratio;
            }else{
                int ratio = common[1] /common[0];
                return common[n-1] * ratio;
            }
        }
    }
}