
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ArrayDeque<Node> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            queue.add(new Node(start, ""));
            bfs(queue,visited,end);

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    // 경우에 따라선 새로운 클래스를 만들자
    static class Node {
        String command;
        int number;

        Node(int number, String command) {
            this.number = number;
            this.command = command;
        }
    }

    static void bfs(ArrayDeque<Node> queue, boolean[] visited, int result) {
        char[] dslr = {'D', 'S', 'L', 'R'};

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.number == result) {
                sb.append(node.command).append("\n");
                return;
            }

            for(int i = 0; i < 4; i++){
                int next = 0;
                if (dslr[i] == 'D') {
                    next = (node.number * 2) % 10000;
                }
                if (dslr[i] == 'S') {
                     next = node.number == 0 ? 9999 : node.number - 1;
                }

                if (dslr[i] == 'L') {
                    next = (node.number % 1000) * 10 + node.number / 1000;
                }
                if (dslr[i] == 'R') {
                    int first = node.number % 10;
                    int back = node.number / 10;
                     next = first * 1000 + back;
                }
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, node
                            .command + dslr[i]));
                }
            }
        }
    }
}
