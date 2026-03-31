import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static class Group {
        int child;
        int candy;

        public Group(int child, int candy) {
            this.child = child;
            this.candy = candy;
        }
        public static Group remake (Group g, int candy) {
            return new Group(g.child + 1, g.candy + candy);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] candy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            union(parent, first, second);
        }
        Map<Integer, Group> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            int root = find(parent,parent[i]);

            if(!map.containsKey(root)) {
                map.put(root, new Group(1, candy[i-1]));
            }else {
                map.put(root, Group.remake(map.get(root), candy[i - 1]));
            }
        }


        int[][] dp = new int[map.size()+1][K];
        ArrayList<Integer> integers = new ArrayList<>(map.keySet());
        for(int i = 1; i <= integers.size(); i++) {
            Group group = map.get(integers.get(i-1));

            for(int j = 0; j < K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= group.child) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - group.child] + group.candy);
                }
            }
        }
        bw.write(String.valueOf(dp[map.size()][K - 1]));
        bw.close();
        br.close();
    }

    static int find (int[] parent, int target) {
        if(parent[target] == target) {
            return target;
        }

        int root = find(parent, parent[target]);
        parent[target] = root;
        return parent[target];
    }
    static void union (int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if(rootB != rootA) {
            if(rootB > rootA) {
                parent[rootB] = rootA;
            }else {
                parent[rootA] = rootB;
            }
        }
    }
}
