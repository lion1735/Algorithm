import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, String> mapNumber = new TreeMap<>();
        TreeMap<String, Integer> mapString = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            String temp = bf.readLine();
            mapNumber.put(i, temp);
            mapString.put(temp, i);
        }
        for (int i = 1; i <= m; i++) {
            String temp = bf.readLine();
            if ('0' <= temp.charAt(0) && temp.charAt(0) <= '9') {
                System.out.println(mapNumber.get(Integer.parseInt(temp)));
            } else {
                System.out.println(mapString.get(temp));
            }

        }
    }

}
