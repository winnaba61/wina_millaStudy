import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2667_단지번호붙이기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[][] map=new int[N][N];
        for(int n=0;n<N;n++){
            String line=sc.next();
            for(int i=0;i<N;i++){
                map[n][i]=line.charAt(i)-'0';//문자열로 입력받아서 int로 변환
            }
        }




        sc.close();
    }
}
