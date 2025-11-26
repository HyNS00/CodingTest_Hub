import java.io.*;
import java.util.*;

public class Main {
    static int INF = 100000000;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) map[i][j] = 0;
                else {
                    map[i][j] = INF;
                }
            }
        }
        int[][] path = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = i;
                }
            }
        }
        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(map[from][to] > value) {

                map[from][to] = value;
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map[start][end]).append("\n")
                .append(result(path,start,end));

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static StringBuilder result(int[][] path, int start, int end) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int curr = end;
        while(curr != start) {
            list.add(curr);
            curr = path[start][curr];
        }
        list.add(start);
        Collections.reverse(list);// 뒤집기
        sb.append(list.size()).append("\n");
        for(int num : list) {
            sb.append(num).append(" ");
        }

        return sb;
    }
}
