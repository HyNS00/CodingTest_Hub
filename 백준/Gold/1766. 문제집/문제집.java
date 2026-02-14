
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        int[] arr = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);

            arr[second]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i <= n; i++) {
            if(arr[i] == 0) {
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");
            
            for(int next : list.get(curr)) {
                arr[next]--;
                if(arr[next] == 0) {
                    pq.add(next);
                }
            }

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
