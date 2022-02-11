import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static int n, m, cnt,temp;
    public static int[][] map;
    public static int [] Min;
    public static int [] res;
    public static int bfs() {
        Queue <Integer> que = new LinkedList<>();
        que.add(n); // 첫 원소 넣기
        Min[n] = 0; //cnt = 0
        temp = n; 
        res = new int[3]; //이동위치 계산 배열
        while(!que.isEmpty() && temp!=m){ //같아진다면 
            temp = que.poll();
            res[0] = temp-1;
            res[1] = temp+1;
            res[2] = temp*2;
            for(int i=0;i<3;i++){
                if(res[i] < 0 || res[i] > 100000) continue; //범위 체크
                if(Min[res[i]] == -1){ //방문하지 않았다면
                    que.add(res[i]); //큐에 추가하기
                    Min[res[i]] = Min[temp]+1; //이전값에서 1증가함
                }
            }
        }
        return Min[temp]; // 어차피 temp == m 이 됨
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Min = new int[1000001];
        Arrays.fill(Min,-1);
        System.out.println(bfs());
    }

}
