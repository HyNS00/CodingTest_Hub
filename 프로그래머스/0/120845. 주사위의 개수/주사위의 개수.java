class Solution {
    public int solution(int[] box, int n) {
        int[] tmp = new int[3];
        for(int i = 0; i < 3; i++){
            tmp[i] = (int) (box[i] / n);
        }
        int result = 1;
        for(int j = 0; j < 3; j++){
            result = result *tmp[j];
        }
        return result;
    }
}