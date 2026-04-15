

import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb;
    static int[] inOrder;
    static int[] preOrder;
    static int[] inIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        preOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        inIdx = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int value = inOrder[i];
            inIdx[value] = i; // 해당 값의 index를 가져옴
        }

        sb = new StringBuilder();
        solve(0, n - 1, 0, n - 1);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void solve(int is, int il, int ps, int pl) {
        if(is > il || ps > pl) {
            return;
        }

        int root = preOrder[pl];
        int rootIdx = inIdx[root];

        sb.append(root).append(" ");
        // 왼쪽 서브트리 == 오른쪽 서브 트리
        int leftSize = rootIdx - is;

        solve(is, rootIdx -1, ps, ps + leftSize -1);
        solve(rootIdx+1, il, ps + leftSize, pl -1);

    }
}
