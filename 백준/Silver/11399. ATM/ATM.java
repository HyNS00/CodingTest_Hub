
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){

            pq.add(Integer.parseInt(st.nextToken()));

        }
        int[] arr = new int[N];
        int result = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            result += pq.poll();
            arr[i] = result;
            sum += arr[i];
        }
        bw.write(String.valueOf(sum));

        bw.close();
        br.close();
    }
}
