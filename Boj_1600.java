import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
    static int [][] dy = {{1,0,-1,0},{-2,-2,-1,-1,1,1,2,2}}; //0일때는 원숭이 1일때는 말로 돌리기
    static int [][] dx = {{0,1,0,-1},{-1,1,-2,2,-2,2,-1,1}};
	static int[][] map;
	static boolean[][][] visited;
	static int K, N, M,res=0;

    private static boolean check(int ny, int nx, int nh) { //범위 체크
		return 0 <= ny && ny < N && 0 <= nx && nx < M && 0<= nh && nh <= K;
	}

	private static int bfs(int targetR, int targetC) {
        Queue<int[]> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.offer(new int[]{0,0,0,0});

		while (!q.isEmpty()) { //큐가 다 비어있을때까지 돌려도 도착을 못하면 -1
            for(int T=0; T<q.size();T++){ //좌표에서 갈 수 있는 모든 경우의수만큼 돌리기
                int temp[] = q.poll();
                int y = temp[0];
                int x = temp[1];
                int h = temp[2];
                int cnt = temp[3];
                if (y == targetR && x == targetC) {
                    return cnt;
                }
                for(int i=0;i<2;i++){ //dy dx2차원 배열
                    for(int j=0;j<dx[i].length;j++){ //dx[0] 혹은 dx[1]을 기준으로 돌리기
                        int ny = y+dy[i][j];
                        int nx = x+dx[i][j];
                        int nh = h+i;
                        if (!check(ny, nx, nh) || visited[ny][nx][nh] || map[ny][nx]!=0) continue; //범위체크
                        q.offer(new int[] {ny, nx, nh, cnt+1}); //큐에 담기
                        visited[ny][nx][nh] = true;
                    }
                } 
            }
		}
        return -1;
	}
   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stz.nextToken());
		N = Integer.parseInt(stz.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		System.out.println(bfs(N - 1, M - 1)); //bfs시작
	}



}
