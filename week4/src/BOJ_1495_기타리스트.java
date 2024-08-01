import java.util.Scanner;

public class BOJ_1495_기타리스트 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();
        int[] volumes = new int[N + 1];
        for (int i = 0; i < N; i++) {
            volumes[i] = scanner.nextInt();
        }
        scanner.close();

        // row시간 후에 음량이 column이 가능한지를 나타냄
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true; // 시작할 때 초기 음량 S는 가능

        // DP 배열 업데이트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                // i번째 곡에서 j볼륨으로 연주했을 때 가능한 다음 곡의 볼륨을 계산
                if (dp[i][j]) {
                    if (j + volumes[i] <= M) {
                        dp[i + 1][j + volumes[i]] = true;
                    }
                    if (j - volumes[i] >= 0) {
                        dp[i + 1][j - volumes[i]] = true;
                    }
                }
            }
        }

        // 결과 출력
        int result = -1;
        for (int i = 0; i <= M; i++) {
            // 마지막 곡에서 가능한 최대 음량을 찾는다.
            if (dp[N][i]) {
                result = i;
            }
        }
        System.out.println(result);
    }
}