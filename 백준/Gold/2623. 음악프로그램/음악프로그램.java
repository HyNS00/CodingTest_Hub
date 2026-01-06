
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            for(int j = 1; j < arr.length-1; j++) {
                int first = arr[j];
                int second = arr[j+1];
                list.get(first).add(second);
                degree[second]++;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            cnt++;
            sb.append(curr).append("\n");
            for(int next : list.get(curr)) {
                degree[next]--;
                if(degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        String answer = cnt == n ? sb.toString() : "0";
        bw.write(answer);
        bw.close();
        br.close();
    }
}
