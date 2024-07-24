//nPm을 구하는 문제
import java.util.Scanner;

public class BOJ_15651_N과M {
    static int N;
    static int M;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        sequence = new int[M]; // M개의 숫자를 담을 배열
        bt(0); // 백트래킹 시작
        System.out.print(sb.toString()); // 백트래킹 시작
    }

    private static void bt(int depth){
        // M개를 모두 선택했을 때
        if(depth==M){
            for(int i=0;i<M;i++){
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            sequence[depth] = i; // 현재 깊이의 수를 i로 설정
            bt(depth+1); // 다음 자식 노드 방문
        }
    }
}
