import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.add(new int[]{weight, value});

        }
        for(int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Comparator<int[]> comp = Comparator.comparingInt((int[] value) -> value[0])
                .thenComparingInt(value -> -value[1]);
        list.sort(comp);
        bags.sort(Comparator.naturalOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        long answer = 0;
        for(int i  = 0; i < K; i++) {
            int bag = bags.get(i);

            while(idx < list.size() && list.get(idx)[0] <= bag) {
                pq.add(list.get(idx)[1]);
                idx++;
            }

            if(!pq.isEmpty()) {
                answer += (long) pq.poll();
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();

    }
}
