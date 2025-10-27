
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];
        int K = input[2];
        int X = input[3];

        List<List<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).add(b);
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist,-1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(X);
        dist[X] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for(int next : nodes.get(curr)) {
                if(dist[next] == -1) {
                    dist[next] = dist[curr] +1;
                    queue.add(next);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                answer.add(i);
            }
        }

        String end = answer.isEmpty() ? "-1" : answer.stream().map(String::valueOf).collect(Collectors.joining("\n"));
        bw.write(end);
        bw.close();
        br.close();
    }
}
