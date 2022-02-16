import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    // 0000000
    // 0101010
    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt =0,max =0,min=n;
        String []s = bf.readLine().split(""); //첫 스위치를 누를 배열
        String []s2 = new String[n]; //첫 스위치를 누르지 않을 배열
        for(int i=0;i<n;i++){
            s2[i] = s[i];
        }
        String []res = bf.readLine().split(""); //결과 배열
        // ===================sol===================
        // 스위치 0을 눌렀을때
        s[0] = Integer.toString((s[0].charAt(0)+1)%2);
        s[1] = Integer.toString((s[1].charAt(0)+1)%2);
        max++;
        for(int i =1;i<n;i++){
            if(!s[i-1].equals(res[i-1])){ //s배열에서 i-1의 값이 서로 다르다면 i번째 스위치를 눌러 i-1의 값을 맞춰줌
                max++;
                s[i-1] = Integer.toString((s[i-1].charAt(0)+1)%2);
                s[i] = Integer.toString((s[i].charAt(0)+1)%2);
                if(i+1<s.length) s[i+1] = Integer.toString((s[i+1].charAt(0)+1)%2); //범위 체크
            }
            if(!s2[i-1].equals(res[i-1])){ //s2배열에서 i-1의 값이 서로 다르다면 i번째 스위치를 눌러 i-1의 값을 맞춰줌
                cnt++;
                s2[i-1] = Integer.toString((s2[i-1].charAt(0)+1)%2);
                s2[i] = Integer.toString((s2[i].charAt(0)+1)%2);
                if(i+1<s.length) s2[i+1] = Integer.toString((s2[i+1].charAt(0)+1)%2); //범위 체크
            }
        }
        // ===================output===================
        if(Arrays.toString(s).equals(Arrays.toString(res)) && Arrays.toString(s2).equals(Arrays.toString(res))){ // s배열, s2배열 둘다 만들 수 있다면 작은 값 출력
                System.out.println(Math.min(max, cnt));
        }else if(Arrays.toString(s).equals(Arrays.toString(res))){ // res 배열과 s배열과 결과가 같으면 max출력
            System.out.println(max);
        }else if(Arrays.toString(s2).equals(Arrays.toString(res))){ // res 배열과 s2배열과 결과가 같으면 cnt출력
            System.out.println(cnt);
        }else{ // 결과가 다르면 -1
            System.out.println(-1);
        }
    }
}
