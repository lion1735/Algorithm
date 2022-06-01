import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int res, cnt, N, M, x1, y1, p1, x2, y2, p2;
    public static int map[][];
    public static int dy[] = { 0, 0, 0, 1, -1 }; // 동 서 남 북
    public static int dx[] = { 0, 1, -1, 0, 0 };

    static boolean check(int y, int x) {
        if (y <= 0 || x <= 0 || y > N || x > M || map[y][x] == 1)
            return false;
        return true;
    }

    static void bfs(int y, int x, int p) {
        Queue<int[]> que = new LinkedList<>();
        boolean visited[][][] = new boolean[5][N + 1][M + 1];
        que.add(new int[] { y, x, p, cnt });
        visited[p][y][x] = true;
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int py = temp[0];
            int px = temp[1];
            int ptr = temp[2]; // 방향
            int hap = temp[3];
            // 위치에 해당하는지?
            if (py == y2 && px == x2 && ptr == p2) {
                System.out.println(hap);
                break;
            }

            // 직선으로 이동할 수 있는지? 최대 3칸
            for (int i = 1; i < 4; i++) {
                int ny = py + dy[ptr] * i;
                int nx = px + dx[ptr] * i;
                if (ny <= 0 || nx <= 0 || ny > N || nx > M || map[ny][nx] == 1)
                    break;
                if (visited[ptr][ny][nx])
                    continue;
                visited[ptr][ny][nx] = true;
                que.add(new int[] { ny, nx, ptr, hap + 1 });

            }
            // 방향을 돌려야하는지?
            for (int i = 1; i <= 4; i++) {
                int cnt = 1;
                if (ptr == i || visited[i][py][px])
                    continue;
                if ((ptr == 1 && i == 2) || (ptr == 2 && i == 1) || (ptr == 3 && i == 4)
                        || (ptr == 4 && i == 3)) {
                    cnt = 2;
                }
                visited[i][py][px] = true;
                que.add(new int[] { py, px, i, hap + cnt });
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // ===============input=================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        Arrays.fill(map[0], 1);
        for (int i = 1; i <= N; i++) {
            map[i][0] = 1;
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        y1 = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        p1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        y2 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        // ===============sol=================
        bfs(y1, x1, p1);
        // ===============output=================

    }

}
