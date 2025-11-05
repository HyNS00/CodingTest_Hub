
import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        char[][] map = new char[c][r];

        for(int i = 0; i < c; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Character> list = new ArrayList<>();

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{0, 0});
        list.add(map[0][0]);

        dfs(stack,list,map);

        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
    private static void dfs(ArrayDeque<int[]> stack, List<Character> list, char[][] map) {
        while(!stack.isEmpty()) {
            int[] pop = stack.pop();
            max = Math.max(list.size(), max);

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + pop[0];
                int ny = dy[i] + pop[1];

                if(nx < map.length && nx >= 0 && ny < map[0].length && ny >= 0
                    && !list.contains(map[nx][ny])) {
                    stack.push(new int[] {nx,ny});
                    list.add(map[nx][ny]);
                    dfs(stack,list,map);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
