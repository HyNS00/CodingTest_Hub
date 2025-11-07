
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // stack 을 통해서 진행하자
        // 단 ArrayDeque는 get이 없으니까 StringBuilder를 사용해보자

        String str = br.readLine();
        String target = br.readLine();
        int len = target.length();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            sb.append(c);
            if (sb.length() >= len && c == target.charAt(len - 1)) {
                boolean flag = true;

                for(int i = 0; i < len; i++) {
                    if (sb.charAt(sb.length() - len + i) != target.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    sb.delete(sb.length() - len, sb.length());
                    // sb는 delete(int start, int delete) -> start ~ delete-1
                    // deleteCharAt(int idx) -> 하나만
                    // replace(int start, int end, String str) -> start ~ end-1에서 str로 교체
                    // 길이가 달라도 조절
                }
            }
        }
        String answer = sb.length() > 0 ? sb.toString() : "FRULA";
        bw.write(answer);
        bw.close();
        br.close();
    }
}
