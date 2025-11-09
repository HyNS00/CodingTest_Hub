import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 크기가 증가하는 부분 수열 -> 해당 지점을 마지막으로 생각해라
        // 크기가 줄어드는건? -> 똑같이 하면되지 않을까?
        // 똑같이 해서 나누자

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int[] increase = new int[n];
        int[] decrease = new int[n];

        Arrays.fill(increase,1);
        Arrays.fill(decrease, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
            }
        }

        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j > i; j--) {
                if(arr[j] < arr[i]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = Math.max(sum, (increase[i]+decrease[i]-1));
        }
        bw.write(String.valueOf(sum));
        bw.close();
        br.close();
    }
}
