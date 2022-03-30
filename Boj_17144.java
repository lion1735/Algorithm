import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    static int n,m,t,hap,cnt,res,upY,downY;
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,1,-1};
    static int map[][];
    static int mapRes[][];
    static boolean visited[][];
    static Queue <Integer> cleaner = new LinkedList<>();
    public static void clean(){ 
        //위쪽 공기청정기
        for (int x = upY - 1; x > 0; x--) {
            mapRes[x][0] = mapRes[x-1][0];
        }
        for (int y = 0; y < m - 1; y++) {
            mapRes[0][y] = mapRes[0][y+1];
        }
        for (int x = 0; x < upY; x++) {
            mapRes[x][m-1] = mapRes[x+1][m-1];
        }
        for (int y = m - 1; y > 1; y--) {
            mapRes[upY][y] = mapRes[upY][y-1];
        }
        mapRes[upY][1] = 0;

        //아래쪽 공기청정기
        for (int x = downY + 1; x < n - 1; x++) {
            mapRes[x][0] = mapRes[x+1][0];
        }
        for (int y = 0; y < m - 1; y++) {
            mapRes[n-1][y] = mapRes[n-1][y+1];
        }
        for (int x = n - 1; x > downY; x--) {
            mapRes[x][m-1] = mapRes[x-1][m-1];
        }
        for (int y = m - 1; y > 1; y--) {
            mapRes[downY][y] = mapRes[downY][y-1];
        }
        mapRes[downY][1] = 0;
    }
    public static void hwaksan(){
        Queue <int []> que = new LinkedList<>();
        mapRes = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] > 0){ //한 번에 확산 시키기 위해서 가능한 것 만 큐에 담음
                    que.offer(new int [] {i,j});
                }else if(map[i][j] == -1){
                    mapRes[i][j] = -1;
                }
            }
        }
        while(!que.isEmpty()){ //추가 배열에 확산한 결과 계산하기
            int temp[] = que.poll();
            int y = temp[0];
            int x = temp[1];
            int munji = (int)Math.floor(map[y][x] / 5);
            for(int k=0; k<4;k++){
                int ny = y + dy[k];
                int nx = x + dx[k];
                if(ny < 0 || nx < 0 || ny>= n || nx >= m || mapRes[ny][nx] == -1)continue;
               
                mapRes[ny][nx] += munji;
                map[y][x] -= munji;
            }
            mapRes[y][x] += map[y][x];
        }
        map = mapRes;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        cnt = hap = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    cleaner.offer(i); //공기청정기 상 하 찾기
                }
            }
        }
        upY = cleaner.poll(); //공기정청기 상
        downY = cleaner.poll(); //공기정청기 하

        while(t-->0){ //시간 만큼 돌리기
            hwaksan();
            clean();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mapRes[i][j] > 0){
                    hap += mapRes[i][j];
                }
            }
        }
        System.out.println(hap);
        
    }
}
