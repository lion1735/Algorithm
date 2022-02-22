import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    // ==============================function==============================
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y)
                parent[y] = x;
            else
                parent[x] = y;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        //==============================input==============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type==0){
                union(a,b);
            }else{
                System.out.println(isSameParent(a, b) ? "YES":"NO"); 
            }
            // System.out.println(Arrays.toString(parent));
        }
        //==============================sol==============================
            
        //==============================output==============================
    }
}
