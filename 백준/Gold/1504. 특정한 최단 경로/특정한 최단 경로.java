
import java.io.*;
import java.util.*;

public class Main {
    // 다익스트라는 시작 지점 부터 나머지 node까지의 최단 거리를 기록한다.
    static class Node {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    static class State {
        int idx;
        int minDist;

        public State(int idx, int minDist) {
            this.idx = idx;
            this.minDist = minDist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> map = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.get(from).add(new Node(to,value));
            map.get(to).add(new Node(from, value));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        int[] startOne = dijkstra(N, 1, map);
        int[] startV1 = dijkstra(N, v1, map);
        int[] startV2 = dijkstra(N, v2, map);

        long oneV1V2 = (long) startOne[v1] + startV1[v2] + startV2[N];

        long oneV2V1 = (long) startOne[v2] + startV2[v1] + startV1[N];

        long answer = Math.min(oneV1V2, oneV2V1) >= Integer.MAX_VALUE ? -1 : Math.min(oneV1V2, oneV2V1);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();


    }

    private static int[] dijkstra(int N, int startIdx, List<List<Node>> map) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(state -> state.minDist));
        pq.add(new State(startIdx, 0));
        dist[startIdx] = 0;

        while(!pq.isEmpty()) {
            State curr = pq.poll();
            if(curr.minDist > dist[curr.idx]) {
                continue;
            }

            for(Node node : map.get(curr.idx)) {
                if(dist[node.to] > curr.minDist + node.value) {
                    dist[node.to] = curr.minDist + node.value;

                    pq.add(new State(node.to, dist[node.to]));
                }
            }
        }

        return dist;
    }
}
