import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_최강 {
    public static int N, M, res = 0, ans = 0;
    public static int dy[] = { -1, 1, 0, 0 };
    public static int dx[] = { 0, 0, -1, 1 };
    public static int map[][];
    public static int mapNew[][];

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean check(int y, int x) {
        return 0 <= y && 0 <= x && y < N && x < M && mapNew[y][x] == 0;
    }

    public static int bfs() {
        int cnt = res - 3;
        mapNew = new int[N][M];
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < N; i++) { // 깊은 복사,바이러스 큐에 넣기
            for (int j = 0; j < M; j++) {
                mapNew[i][j] = map[i][j];
                if (mapNew[i][j] == 2) {
                    que.add(new Node(i, j));
                }
            }
        }
        while (!que.isEmpty()) {
            Node temp = que.poll();
            for (int d = 0; d < 4; d++) {
                int ny = temp.y + dy[d];
                int nx = temp.x + dx[d];
                if (check(ny, nx)) {
                    mapNew[ny][nx] = 2;
                    que.add(new Node(ny, nx));
                    cnt--;
                }
            }
        }
        if (cnt > 100) {
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(mapNew[i]));
            }
            System.out.println("==========================");
        }
        return cnt;
    }

    public static void recur(int cur) {
        if (cur == 3) {
            ans = Math.max(ans, bfs());
            // for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(map[i]));
            // }
            // System.out.println("==========================");
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    recur(cur + 1);
                    map[i][j] = 0;
                }
            }

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    res++;
            }
        }
        recur(0);
        System.out.println(ans);
    }
}
