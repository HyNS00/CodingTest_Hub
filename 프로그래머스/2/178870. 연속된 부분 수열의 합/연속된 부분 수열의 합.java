class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int n = sequence.length;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        // right로는 값을 계속 증가시키는게 목적
        for(int right = 0; right < n; right++){
            sum += sequence[right];
            while(sum > k && left <= right){
                sum -= sequence[left++];
            }
            
            // sum이 k와 같고 길이가 더 짧으면 갱신
            if(sum == k && (right - left + 1) < minLength){
                minLength = right - left + 1;
                answer[0] = left;
                answer[1] = right;
            }
            
        }
        return answer;
    }
}