
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int init;
        int ing;
        int r;
        int c;
        public Node(int init, int ing, int r, int c) {
            this.init = init;
            this.ing = ing;
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c) {
            this(0, 0,r, c);
        }
    }
    static int airCleanerTop = -1;
    static int airCleanerBottom = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(st.nextToken());


        Node[][] nodes = new Node[row][col];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                int value = Integer.parseInt(st.nextToken());
                nodes[i][j] = new Node(value, 0, i, j);

                // 공기청정기 위치 찾기
                if(value == -1) {
                    if(airCleanerTop == -1) {
                        airCleanerTop = i;
                    } else {
                        airCleanerBottom = i;
                    }
                }
            }
        }
        for(int t = 0; t < time; t++) {
            bfs(nodes);
            cleanAir(nodes, row, col);
        }

        int result = calculateDust(nodes);
        bw.write(String.valueOf(result));
        bw.flush();


    }
    public static void bfs(Node[][] nodes) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < nodes.length; i++) {
            for(int j = 0; j < nodes[0].length; j++) {
                if(nodes[i][j].init > 0) {
                    queue.add(nodes[i][j]);
                }
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int cx = node.r;
            int cy = node.c;
            int give = node.init / 5;
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < nodes.length && ny >= 0 && ny < nodes[0].length) {
                    Node target = nodes[nx][ny];
                    if(target.init == -1) continue;
                    target.ing += give;
                    node.ing -= give;
                }
            }
        }
        for(int i = 0; i < nodes.length; i++) {
            for(int j= 0; j < nodes[0].length; j++) {
                nodes[i][j].init += nodes[i][j].ing;
                nodes[i][j].ing = 0;
            }
        }

    }
    public static void cleanAir(Node[][] nodes, int row, int col) {
        // 위쪽 공기청정기 (반시계방향)
        // 아래로
        for(int i = airCleanerTop - 1; i > 0; i--) {
            nodes[i][0].init = nodes[i-1][0].init;
        }
        // 왼쪽으로
        for(int j = 0; j < col - 1; j++) {
            nodes[0][j].init = nodes[0][j+1].init;
        }
        // 위로
        for(int i = 0; i < airCleanerTop; i++) {
            nodes[i][col-1].init = nodes[i+1][col-1].init;
        }
        // 오른쪽으로
        for(int j = col - 1; j > 1; j--) {
            nodes[airCleanerTop][j].init = nodes[airCleanerTop][j-1].init;
        }
        nodes[airCleanerTop][1].init = 0;

        // 아래쪽 공기청정기 (시계방향)
        // 위로
        for(int i = airCleanerBottom + 1; i < row - 1; i++) {
            nodes[i][0].init = nodes[i+1][0].init;
        }
        // 왼쪽으로
        for(int j = 0; j < col - 1; j++) {
            nodes[row-1][j].init = nodes[row-1][j+1].init;
        }
        // 아래로
        for(int i = row - 1; i > airCleanerBottom; i--) {
            nodes[i][col-1].init = nodes[i-1][col-1].init;
        }
        // 오른쪽으로
        for(int j = col - 1; j > 1; j--) {
            nodes[airCleanerBottom][j].init = nodes[airCleanerBottom][j-1].init;
        }
        nodes[airCleanerBottom][1].init = 0;
    }
    public static int calculateDust(Node[][] nodes) {
        int sum = 0;
        for(int i = 0; i < nodes.length; i++) {
            for(int j = 0; j < nodes[0].length; j++) {
                if(nodes[i][j].init > 0) {
                    sum += nodes[i][j].init;
                }
            }
        }
        return sum;
    }
}
