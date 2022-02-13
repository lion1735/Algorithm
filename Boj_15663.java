import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int N,M;
    public static int [] arr;
    public static int [] input;
    public static boolean [] visited;
    public static LinkedHashSet<String> res;
    public static void recur(int cur){
        if(cur==N){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                sb.append(arr[i]).append(' ');
            }
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<M;i++){
            if(visited[i]) continue;
            arr[cur] = input[i];
            visited[i] = true;
            recur(cur+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M*M];
        res = new LinkedHashSet<>();
        visited = new boolean[M*M];
        st = new StringTokenizer(bf.readLine());
        input = new int[M];
        for(int i=0;i<M;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        recur(0);
        res.forEach(System.out :: println);
    }

}
