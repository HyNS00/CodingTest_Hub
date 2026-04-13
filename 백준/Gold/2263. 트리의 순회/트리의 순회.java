

import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 후위 -> 노드가 마지막에 온다
        // 중위 -> 가운데 있다.
        int n = Integer.parseInt(br.readLine());
        // 인오더
        int[] inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num))
                .toArray();

        int[] postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 마지막 수가 노드
        int[] idxIn = new int[n+1];

        // 반복된다.
        sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int value = inOrder[i];
            idxIn[value] = i;

        }
        solve(0,n-1,0,n-1,idxIn,postOrder);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    static void solve(int is,int il, int ps, int pl, int[] idxIn, int[] postOreder) {
        if(is > il || ps > pl) {
            return;
        }

        int root = postOreder[pl];
        sb.append(root).append(" ");

        int rootIdx = idxIn[root];
        int leftSize = rootIdx - is;

        solve(is, rootIdx - 1, ps, ps + leftSize - 1, idxIn, postOreder);
        solve(rootIdx + 1, il, ps + leftSize, pl - 1,idxIn,postOreder);
    }

}
