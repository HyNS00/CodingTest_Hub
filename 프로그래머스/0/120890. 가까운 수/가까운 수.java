class Solution {
    public int solution(int[] array, int n) {
        // 업데이트를 하자 -> if문에 조건을 잘 정리하자
        int closet = array[0];
        int standard = Math.abs(array[0] - n);
        for(int i = 1; i < array.length; i++){
            int tmp = Math.abs(array[i] - n);
            if(tmp < standard || array[i] < closet && tmp == standard){
                standard = tmp;
                closet = array[i];
            }
        }
        return closet;
    }
}