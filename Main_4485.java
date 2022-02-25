import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

class position {
    int y;
    int x;

    position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n,ptr;
    static int map[][];
    static int newMap[][];
    static int dy[] = {1,-1,0,0};
    static int dx[] = {0,0,1,-1};
    static void bfs(int my, int mx){
        Queue <position> que = new LinkedList<>();
        que.offer(new position(my, mx));
        newMap[my][mx] = map[my][mx]; //[0][0]의 값은 둘다 같으므로

        while(!que.isEmpty()){ //bfs 탐색
            position temp = que.poll();
            for(int i=0;i<4;i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];
                //범위체크, 이동할 다음 좌표의 값이 ( 현재의 누적합 + 다음 map의 값 ) 보다 작다면? 굳이 저장하지 않아도됨
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || newMap[ny][nx] <= newMap[temp.y][temp.x] + map[ny][nx]) continue; 
                // System.out.println(temp.y + " : "+ temp.x); //좌표확인용
                //이동할 좌표가 작기 때문에 저장
                newMap[ny][nx] = newMap[temp.y][temp.x] + map[ny][nx];
                que.offer(new position(ny,nx));
            }
        }

    }   
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        ptr = 1;
        while ((n = Integer.parseInt(bf.readLine())) != 0) {
            // =============================input=============================
            map = new int[n][n]; //입력받을 맵
            newMap = new int[n][n]; //새로 저장할 맵
            
            for(int i=0;i<n;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    newMap[i][j] = Integer.MAX_VALUE;
                }
            }
            // =============================sol=============================
            bfs(0,0);
            sb.append("Problem ").append(ptr++).append(": ").append(newMap[n-1][n-1]).append('\n'); //newMap 마지막 값이 결과임.
            // for(int i=0;i<n;i++){ //결과 확인해보기
                //     System.out.println(Arrays.toString(newMap[i]));
                // }

            }
        // =============================output=============================
        System.out.println(sb);
    }
}
