import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M, res, ptr1, ptr2, ans;
    static int[][] map;
    static boolean [] visited;
    static ArrayList<Node> houseMap,chickenMap;
    // ===================recur===================
    public static void recur(int cur, int start) {
        if (cur == M) { //치킨집이 모두 선택되었을때
            res = 0;
            for(int i=0;i<houseMap.size();i++){ //모든 집
                int temp = Integer.MAX_VALUE;
                for(int j=0;j<chickenMap.size();j++){ //모든 치킨 집
                    if(visited[j]){  //치킨집이 선택되었다면 거리 구하기
                    int d = Math.abs(houseMap.get(i).x - chickenMap.get(j).x) + Math.abs(houseMap.get(i).y - chickenMap.get(j).y); //거리계산
                    // System.out.printf("map[%d][%d] = %d\n",i,j,d);
                    temp = Math.min(temp,d); //치킨집과 거리가 짧은 곳 선택
                    }
                }
                res += temp; //선택된 집에서 치킨 집의 거리
            }
            ans = Math.min(ans,res); //가장 작은가?
            return;
        }

        for(int i = start; i<chickenMap.size();i++){ //중복없는 조합
            if(visited[i]) continue;
            visited[i] = true; //선택
            recur(cur+1,i+1);
            visited[i] = false; //선택안함
        }
    }

    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houseMap = new ArrayList<>(); //모든 집의 위치 저장
        chickenMap = new ArrayList<>(); //모든 치킨집의 위치 저장
        ans = Integer.MAX_VALUE; //결과 담을 변수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) { //집이라면? 
                    houseMap.add(new Node(i, j));
                }else if (temp == 2) { //치킨집이라면?
                    chickenMap.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chickenMap.size()]; //입력받은 치킨집의 갯수를 알았다면 visited 배열 선언
        // ===================sol===================
        recur(0,0); //조합 구성 시작
        // ===================output===================
        System.out.println(ans);
    }
}
