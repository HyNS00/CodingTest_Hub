
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // fib에서 배열로 처리하자 -> 시간 복잡도를 줄여야함
        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        for(int i = 2; i <= 40; i++){
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1]  + one[i-2];
        }
        for(int t = 0; t < T; t++){
            int num = Integer.parseInt(br.readLine());
            sb.append(zero[num]).append(" ").append(one[num]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

}
