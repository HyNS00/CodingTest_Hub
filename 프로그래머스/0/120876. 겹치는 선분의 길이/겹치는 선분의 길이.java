class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        // 범위가 -100 ~ 100
        // 총 길이가 200인 배열로 생각하자
        // 인덱스로 접근할거니까 201
        int[] tmp = new int[201];
        // 지나가는 곳은 모두 1로 표기
        for(int[] arr : lines){
            int start = arr[0]+ 100;
            int end = arr[1]+100;
            for(int i = start; i < end; i++){
                tmp[i] += 1;
                // end포함하면 초과
            }
        }
        for(int cnt : tmp){
            if(cnt >1){
                answer++;
            }
        }
        return answer;
    }
}