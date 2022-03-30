import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    static int n,m,hap,cnt,res;
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    static int map[][];
    static boolean visited[][];
    public static void bfs(){
        cnt++; //몇 번 호출되는지 체크
        Queue<int[]> que = new LinkedList<>();
        visited = new boolean[n][m];
        que.offer(new int[] {0,0});
        visited[0][0] = true;
        while(!que.isEmpty()){
            int [] temp = que.poll(); //[0] = y, [1] = x
            for(int i=0;i<4;i++){
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >=m || visited[ny][nx]) continue; //범위체크
                if(map[ny][nx]==1){  //1을 찾았다면 전체갯수에서 빼주기
                    map[ny][nx] = 0;
                    hap--;
                }else if(map[ny][nx] == 0){ //0을 찾았다면 큐에 추가
                    que.offer(new int[]{ny,nx});
                }
                visited[ny][nx] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        

        cnt = hap = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) hap++; // 전체 1을 계산
            }
        }


        while(hap!=0){
            res = hap; //bfs 돌리기 이전에 1의 합
            bfs();
        }
        System.out.println(cnt);
        System.out.println(res);
    }
}
