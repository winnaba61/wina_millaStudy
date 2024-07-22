import java.util.*;

public class BOJ_15663_N과M {
    static int N;
    static int M;
    static boolean[] visited; // 방문한 숫자인지 체크
    static int[] sequence; // 선택한 숫자들을 저장할 배열
    static ArrayList<Integer> arr; // 입력 받은 숫자들을 저장할 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList();
        sequence = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        arr.sort(null); // 입력 받은 숫자들을 정렬
        backTracking(0);

        sc.close();
    }

    // 백트래킹
    private static void backTracking(int depth) {
        // M개를 모두 선택했을 때
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        // N개의 숫자 중에서 M개를 선택
        for (int i = 0; i < arr.size(); i++) {
            // 아직 사용하지 않은 숫자라면
            if (!visited[i]) {
                // 이전 숫자와 중복된 숫자가 아니거나, 중복된 숫자라도 이전에 사용한 숫자라면
                if(i>0 && arr.get(i).equals(arr.get(i-1)) && !visited[i-1]) {
                    continue;
                }
                    visited[i] = true;
                    sequence[depth] = arr.get(i);
                    backTracking(depth + 1);
                    visited[i] = false;
                }
        }
    }
}