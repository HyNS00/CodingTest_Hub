
import java.io.*;
import java.util.*;

public class Main {
    static class Target {
        int number;
        int idx;

        public Target(int number, int idx) {
            this.number = number;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Comparator<Target> comp = Comparator.comparingInt((Target t) -> -t.number)
                .thenComparingInt((Target t) -> t.idx);

        PriorityQueue<Target> pqA = new PriorityQueue<>(comp);
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < a.length; i++) {
            pqA.add(new Target(a[i], i));
        }

        int start = 0;
        int lastIdx = -1;
        int cnt = 0;
        while(!pqA.isEmpty()) {
            Target max = pqA.poll();

            for(int i = start; i < b.length; i++) {
                if(b[i] == max.number && lastIdx < max.idx) {

                    sb.append(b[i]).append(" ");
                    cnt++;
                    lastIdx = max.idx;
                    start = i + 1;
                    break;
                }
            }
        }
        bw.write(String.valueOf(cnt) + "\n" + sb.toString());
        bw.close();
        br.close();



    }
}
