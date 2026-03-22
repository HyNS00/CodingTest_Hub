

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static class Point {
        long x;
        long y;

        public Point(long x,long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Point> list = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                list.add(new Point(x, y));
            }

        }
        // ccw 알고리즘
        // 외적을 이용해서 구한다.

        int ccw1 = ccw(list.get(0), list.get(1), list.get(2)) * ccw(list.get(0), list.get(1), list.get(3));
        int ccw2 = ccw(list.get(2), list.get(3), list.get(0)) * ccw(list.get(2), list.get(3), list.get(1));
        int answer = 0;
        if(ccw1 == 0 && ccw2 == 0) {
            if (Math.min(list.get(0).x, list.get(1).x) <= Math.max(list.get(2).x, list.get(3).x) &&
                    Math.min(list.get(2).x, list.get(3).x) <= Math.max(list.get(0).x, list.get(1).x) &&
                    Math.min(list.get(0).y, list.get(1).y) <= Math.max(list.get(2).y, list.get(3).y) &&
                    Math.min(list.get(2).y, list.get(3).y) <= Math.max(list.get(0).y, list.get(1).y)) {
                answer = 1;
            } else {
                answer = 0;
            }
        } else if(ccw1 <= 0 && ccw2 <= 0) {
            answer =1;
        } else {
            answer = 0;
        }
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();

    }
    static int ccw(Point a, Point b, Point c) {
        long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.y*b.x + b.y*c.x + c.y * a.x);

        if(result > 0) {
            return 1;
        }else if(result < 0) {
            return -1;
        }else {
            return 0;
        }
    }
}
