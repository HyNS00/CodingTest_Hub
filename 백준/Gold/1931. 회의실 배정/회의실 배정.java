import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        Comparator<int[]> comp = Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt((int[] a) -> a[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);


        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());

            pq.add(tmp);
        }

        int cnt = 1;
        int[] curr = pq.poll();

        while(!pq.isEmpty()) {

            int[] peek = pq.peek();
            if(peek[0] >= curr[1]) {
                cnt++;
                curr = pq.poll();
            } else {
                pq.poll();
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
}
