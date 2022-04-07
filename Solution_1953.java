import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;
    int k;

    Node(int r, int c, int k) {
        this.r = r;
        this.c = c;
        this.k = k;
    }
}

public class Solution_1953_최강 {
    public static int N, M, R, C, K, res; // rc 좌표, k 이동횟수
    public static int map[][];
    public static int dy[] = { 0, -1, 0, 1, 0 }; // 상 좌 하 우 0 1 2 3 4
    public static int dx[] = { 0, 0, -1, 0, 1 };
    public static int dir[][] = { // 1 이면 상하좌우 0일때도 있으니까.
            { 0 },
            { 1, 2, 3, 4 },
            { 1, 3 },
            { 2, 4 },
            { 1, 4 },
            { 3, 4 },
            { 2, 3 },
            { 1, 2 }
    };

    public static boolean check(int y, int x, int ptr, int d) { // 상이라면 하, 좌라면 우가 나와야함.
        boolean chk = false;
        if (0 <= y && 0 <= x && y < N && x < M && map[y][x] != 0) {
            for (int i = 0; i < dir[map[y][x]].length; i++) {
                if (Math.abs(dir[map[y][x]][i] - dir[ptr][d]) == 2) {
                    chk = true;
                    break;
                }
                // switch (dir[map[y][x]][i]) {
                // case 1:
                // if (dir[ptr][d] == 3)
                // chk = true;
                // break;
                // case 2:
                // if (dir[ptr][d] == 4)
                // chk = true;
                // break;
                // case 3:
                // if (dir[ptr][d] == 1)
                // chk = true;
                // break;
                // case 4:
                // if (dir[ptr][d] == 2)
                // chk = true;
                // break;
                // }
            }
        }

        return chk;
    }

    public static int bfs() {
        int ans = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(R, C, 0));

        while (!que.isEmpty()) {

            Node temp = que.poll();
            if (temp.k == K)
                break;
            int ptr = map[temp.r][temp.c];
            if (map[temp.r][temp.c] != 0)
                ans++;
            map[temp.r][temp.c] = 0;
            for (int d = 0; d < dir[ptr].length; d++) {
                int ny = temp.r + dy[dir[ptr][d]];
                int nx = temp.c + dx[dir[ptr][d]];
                if (check(ny, nx, ptr, d)) {
                    que.offer(new Node(ny, nx, temp.k + 1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append('#').append(tc).append(' ').append(bfs()).append('\n');
        }
        System.out.println(sb);

    }
}
