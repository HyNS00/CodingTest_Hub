
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        Arrays.fill(arr, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        arr[n] = 0;

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            if(poll == m) {
                break;
            }
            // 최단거리를 확인하는 입장에서
            // 이동하는 시간에 따른 비용이 다르다 -> 가중치가 있다
            // 0- 1 BFS
            int tmp = poll * 2;
            if(tmp < arr.length && (arr[tmp] == -1 || arr[poll] < arr[tmp])){
                arr[tmp] = arr[poll];
                queue.addFirst(poll * 2);
            }

            tmp = poll+1;
            if(tmp < arr.length && (arr[tmp] == -1 || arr[poll] < arr[tmp])) {
                arr[tmp] = arr[poll] +1;
                queue.add(poll+1);
            }

            tmp = poll -1;
            if (tmp >= 0 && (arr[tmp] == -1 || arr[poll] < arr[tmp])) {
                arr[tmp] = arr[poll] +1;
                queue.add(poll - 1);
            }

        }
        bw.write(String.valueOf(arr[m]));
        bw.newLine();
        bw.close();
        br.close();
    }
}
