import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    // ==============================function==============================
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x<y) parent[y] = x;
            else parent[x] = y;
        }
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        //==============================input==============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine()); //N개의 도시
        M = Integer.parseInt(bf.readLine()); //M여행 계획
        parent = new int[N+1]; 
        for(int i=0;i<N;i++){ //도시 할당
            parent[i] = i;
        }
        for(int i=1;i<=N;i++){ //연결된 노드들끼리 저장
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=N;j++){
                if(Integer.parseInt(st.nextToken())== 1){
                    union(i, j);
                }
            }
        }
        //==============================sol==============================
        st = new StringTokenizer(bf.readLine());
        int from = Integer.parseInt(st.nextToken()); //첫 여행지
        int ptr = 0;
        for(int i=0;i<M-1;i++){
            int to = Integer.parseInt(st.nextToken()); //2,3--마지막 여행지까지
            if(!isSameParent(from, to)){ //확인해서 한 번이라도 갈 수 없으면?  NO
                System.out.println("NO");
                ptr = 1;
                break;
            }
        }
        if(ptr == 0) System.out.println("YES"); //위에서 걸리지 않았다면 YES
    }
}
