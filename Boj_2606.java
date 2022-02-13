import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int n, m, cnt, ptr;
    public static int[][] map;
    public static boolean[] visited;
    //==================================bfs==================================
    public static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i < n; i++) { //1이 감염시킨 컴퓨터 큐에 넣기
            if (map[0][i] == 1 || map[i][0] ==1) {
                que.add(i);
                map[0][i] = 0;
                map[i][0] = 0;
                cnt++;
                visited[i] = true;
            }
        }
    
        while (!que.isEmpty()) {
            ptr = que.poll();
            for (int i = 0; i < n; i++) { 
                if (map[ptr][i] == 1) { //아직 탐색되지 않은 것 중에서 방문하지 않은 숫자라면
                    que.add(i);
                    map[ptr][i] = 0;
                    map[i][ptr] = 0;
                    if(visited[i] == false){
                        visited[i] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        //==================================input==================================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        cnt = 0;
        ptr = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
            map[x][y] = 1; //양방향 저장
        }
        //==================================sol==================================
        System.out.println(bfs());
    }

}
