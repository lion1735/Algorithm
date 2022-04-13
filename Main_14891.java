import java.io.*;
import java.util.*;

/*
[톱니번호][톱니정보] 4개의 배열에다가 담아놓기
방향에 따라서 톱니 돌리기 - 2,6번째 인덱스 변환..?
다른 자석들 체크...
*/
public class Solution_4013_최강 {
    static int N, K, P, ans; // N번 회전, K번째 톱니, P 방향
    static int magnets[][];
    static boolean isCheck[];

    public static boolean rangeCheck(int d) {
        return 0 <= d && d < 8;
    }

    public static void recur(int cur, int ptr) {
        if (!rangeCheck(cur))
            return;
        isCheck[cur] = true;
        // 인접한 곳이 다르면 돌리기
        if (cur < 3 && magnets[cur][2] != magnets[cur + 1][6] && !isCheck[cur + 1])
            recur(cur + 1, ptr * -1);
        if (cur > 0 && magnets[cur][6] != magnets[cur - 1][2] && !isCheck[cur - 1])
            recur(cur - 1, ptr * -1);

        // 배열 돌리기~~
        if (ptr == -1) {
            int temp = magnets[cur][0];
            for (int i = 0; i < 7; i++) {
                magnets[cur][i] = magnets[cur][i + 1];
            }
            magnets[cur][7] = temp;
        } else {
            int temp = magnets[cur][7];
            for (int i = 7; i > 0; i--) {
                magnets[cur][i] = magnets[cur][i - 1];
            }
            magnets[cur][0] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 톱니 정보 입력
        ans = 0;
        magnets = new int[4][8];
        for (int i = 0; i < 4; i++) {
            // st = new StringTokenizer(bf.readLine());
            String s = bf.readLine();
            for (int j = 0; j < 8; j++) {
                magnets[i][j] = s.charAt(j) - '0';
            }
        }

        N = Integer.parseInt(bf.readLine());
        // 톱니 돌리기
        for (int i = 0; i < N; i++) {
            isCheck = new boolean[4];
            st = new StringTokenizer(bf.readLine());
            K = Integer.parseInt(st.nextToken()) - 1;
            P = Integer.parseInt(st.nextToken());
            recur(K, P);
        }
        for (int i = 0; i < 4; i++) {
            ans += magnets[i][0] * Math.pow(2, i);
        }
        System.out.println(ans);
    }
}
