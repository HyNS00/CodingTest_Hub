
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] map;
    static int[][] keep;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        keep = new int[n][m];


        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            map[i] = tmp.toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, map[i][j]);
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();

    }
    static void dfs(int x, int y, char c) {
        keep[x][y] = 1;
        int nx;
        int ny;
        if(c == 'U') {
            nx = x-1;
            ny = y;
        }else if(c == 'D') {
            nx = x+1;
            ny = y;
        }else if(c == 'L') {
            nx = x;
            ny = y-1;
        }else {
            nx = x;
            ny = y+1;
        }
        if(keep[nx][ny] == 0) {
            dfs(nx, ny, map[nx][ny]);
        }else if(keep[nx][ny] == 1) {
            cnt++;
        }

        keep[x][y] = 2;

    }
}
