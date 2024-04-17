import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        // 일단 배열 자체를 오름 차순으로 바꾼다.
        Arrays.sort(array);
        // 1 2 3 4 
        // 0 1 2 3
        
        int middle = array.length / 2;
        if (array.length % 2 == 0){
            return array[middle -1] + array[middle];
        }else{
            return array[middle];
        }
            
    }
}