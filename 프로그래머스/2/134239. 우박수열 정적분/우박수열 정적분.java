import java.util.*;
class Solution {
    List<int[]> list = new ArrayList<>();
    int cnt;
    public double[] solution(int k, int[][] ranges) {
        // 입력된 수가 -> 짝수 /2 , 홀수 * 3+1
        // 결과 수가 1보다 크면 반복
        // n은 k 가 초항인 우박수열이 1이 될 때까지의 횟수
        cnt = 0;
        graph(k);
        
        double[] result = new double[ranges.length];
        int idx = 0;
        for(int[] range : ranges){
            int a = range[0];
            int b = range[1] + cnt;
            result[idx++] = cal(a,b);
        }
        
        return result;
    }
    private void graph(int k){
        list.add(new int[] {cnt,k});
        if(k == 1){
            return;
        }
        cnt++;
        if(k % 2 == 0){
            graph(k/2);
        }else {
            graph(k *3 +1);
        }
    }
    private double cal(int a, int b){
        if(a > b){
            return -1.0;
        }
        
        if(a == b){
            return 0.0;
        }
        
        double sum = 0;
        for(int i = a; i < b; i++){
            int[] f = list.get(i);
            int[] s = list.get(i+1);

            sum += (f[1] + s[1]) / 2.0;
        }
        return sum;
    }
}