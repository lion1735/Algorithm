import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int N, M;
    public static int [][] arr;
    public static int max;
    public static int cnt;
    public static Queue<int[]> que;
    public static void bfs(int y, int x){
        int []dy = { 0, 1, 0,-1}; //좌우 상하
        int []dx = {-1, 0, 1, 0};
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 1){
                    int temp[] = {i,j,arr[i][j]};
                    que.add(temp);
                }
            }
        }
        while(!que.isEmpty()){
            int [] add = new int[3];
            add = que.poll();
            int ptrY = add[0];
            int ptrX = add[1];
            cnt = add[2];
            for(int i=0;i<4;i++){
                int ny = ptrY +dy[i];
                int nx = ptrX +dx[i];
                if (ny>=N || nx >= M || ny<0 ||nx<0) continue;
                if(arr[ny][nx] == 0){ // 이동한 좌표가 0이라면
                    arr[ny][nx] = add[2]+1;
                    int [] temp = {ny,nx,arr[ny][nx]};
                    que.add(temp);
                }
            }
            max = Math.max(max, add[2]);
        }
    }
    public static void main(String[] args) throws IOException {
        // =============================input=============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        que = new LinkedList<>();
        max =0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // =============================sol=============================
        bfs(0,0);
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 0){
                    max = 0;
                }
            }
        }
        // =============================output=============================
        System.out.println(max-1);
    }
}
