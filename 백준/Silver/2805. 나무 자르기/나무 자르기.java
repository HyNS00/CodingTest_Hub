
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int  n = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());

        long[] trees = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            trees[i] = Long.parseLong(st.nextToken());

        }
        Arrays.sort(trees);

        long start = 0;
        long end = trees[n - 1];
        long result = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long tmp = 0;
            for(long t : trees){
                if(t > mid) {
                    tmp += (t - mid);
                }
            }
            if(tmp >= M) {
                result = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        // 무한 루프에 빠지는걸 고려해야 한다.
        // 우리는 우리가 가져갈 수 있는 나무길이에 대해서 값을 수색하는데, 이 값이 최대가 아닐 수가 있다
        // -> 정확한 위치를 찾는게 아니라 최대 값
        // 또한 시작 점 또한 잘못되었다. -> 길이를 0일 때 최대가 될 수도 있다. 테스트 케이스 잘 생각해보자
        // 종료 조건 문제 -> start가 end보다 커질 우려가 있음
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
