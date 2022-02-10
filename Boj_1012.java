import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int N, M, T, cnt, input;
    public static int[][] map;
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[] dx = { 1, -1, 0, 0 };

    // =============================dfs=============================
    public static void dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= M || map[y][x] == 0)
            return;
        map[y][x] =0;
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            dfs(ny,nx);
        }
    }
    public static void main(String[] args) throws IOException {
        // =============================input=============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); // 가로
            M = Integer.parseInt(st.nextToken()); // 세로
            input = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            cnt = 0;
            while (input-- > 0) {
                st = new StringTokenizer(bf.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            // =============================sol=============================

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
            cnt = 0;
        }
        // =============================output=============================
        System.out.println(sb);
    }
}
