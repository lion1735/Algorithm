package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		int x =Integer.parseInt(st.nextToken());
		int y =Integer.parseInt(st.nextToken());
		int T =Integer.parseInt(bf.readLine()); //몇 번 실행하는지?
		
		int maxX = Integer.MIN_VALUE; //가장 큰 가로 크기
		int maxY = Integer.MIN_VALUE; //가장 큰 세로 크기
		PriorityQueue<Integer> xCut = new PriorityQueue<>(); //가로로 자르는 것 담기
		PriorityQueue<Integer> yCut = new PriorityQueue<>(); //세로로 자르는 것 담기
		
		xCut.add(0); 
		xCut.add(y); //가로는 세로를 자르고
		yCut.add(0);
		yCut.add(x); //세로는 가로를 자르고

		// 저장하기
		for(int i=0;i<T;i++) {
			st=new StringTokenizer(bf.readLine());
			int ch = Integer.parseInt(st.nextToken());
			if(ch==0) {
				xCut.add(Integer.parseInt(st.nextToken()));
			}else {
				yCut.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//잘라진 값들중 가장 큰 값 찾기
		while(xCut.size() > 1) {
			maxX = Math.max(maxX, Math.abs(xCut.poll()-xCut.peek()));
		}
		while(yCut.size() > 1) {
			maxY = Math.max(maxY, Math.abs(yCut.poll()-yCut.peek()));
		}
		
		System.out.println(maxX * maxY); //출력
	}

}
