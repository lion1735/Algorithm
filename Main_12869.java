import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static boolean visited[][][];
    static int d[][] = {
            { 9, 3, 1 },
            { 9, 1, 3 },
            { 3, 1, 9 },
            { 3, 9, 1 },
            { 1, 9, 1 },
            { 1, 3, 9 }
    };
    static int n, res = Integer.MAX_VALUE;

    private static void dfs(Integer scv[], int cur) {
        Arrays.sort(scv, Collections.reverseOrder()); // 이거 사용하려고 Integer로 temp 선언
        int scvA = Math.max(0, scv[0]); // 음수는 0으로 전환 visited배열에서 음수 X가
        int scvB = Math.max(0, scv[1]);
        int scvC = Math.max(0, scv[2]);
        if (scvA <= 0 && scvB <= 0 && scvC <= 0) { // 답인지 체크
            res = Math.min(cur, res);
            return;
        }
        // 시간초과 줄이기 1 - 방문했는지 체크
        if (visited[scvA][scvB][scvC])
            return;
        visited[scvA][scvB][scvC] = true;
        // 시간초과 줄이기 2 - 어차피 정답보다 큰 값이면 체크할 필요가 없음
        if (res < cur)
            return;
        for (int i = 0; i < 6; i++) { // 모든 경우의 수 다 넣어주기
            dfs(new Integer[] { scvA - d[i][0], scvB - d[i][1], scvC - d[i][2] }, cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        visited = new boolean[61][61][61];
        Integer temp[] = new Integer[3]; // 3보다 작을 수 있으므로 3까지 선언
        Arrays.fill(temp, -1); // 전부 -1로 채우기
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        dfs(temp, 0);
        System.out.println(res);
    }
}
