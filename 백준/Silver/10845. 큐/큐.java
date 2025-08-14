

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commd = st.nextToken();

            switch (commd) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    break;
                case "front" :
                    int tmp = queue.isEmpty() ? -1 : queue.peek();
                    sb.append(tmp).append("\n");
                    break;

                case "back" :
                    int back = queue.isEmpty() ? -1 : queue.peekLast();
                    sb.append(back).append("\n");
                    break;

                case "pop" :
                    int pop = queue.isEmpty() ? -1 : queue.poll();
                    sb.append(pop).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :

                    int empty = queue.isEmpty() ? 1 : 0;
                    sb.append(empty).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
