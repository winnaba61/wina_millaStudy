import java.util.Scanner;

public class Main {
    static int[] win = new int[6];         // 승리 횟수
    static int[] draw = new int[6];        // 무승부 횟수
    static int[] lose = new int[6];        // 패배 횟수
    static int[][] games = new int[15][2];  // 총 15 경기 (팀 번호 저장)
    static boolean result; // 가능한지 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 0;

        // 미리 경기 쌍을 정리 (총 15 경기)
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                games[idx][0] = i;
                games[idx][1] = j;
                idx++;
            }
        }

        for (int t = 0; t < 4; t++) {
            result = false;
            int sum = 0;

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    int score = sc.nextInt();
                    if (j == 0) win[i] = score;
                    else if (j == 1) draw[i] = score;
                    else lose[i] = score;
                    sum += score;
                }
            }

            // 총 경기는 30 경기가 되어야 함
            if (sum == 30) {
                dfs(0);
            }

            System.out.print((result ? 1 : 0) + " ");
        }
    }

    // 백트래킹으로 가능한 결과인지 확인
    static void dfs(int game) {
        if (result) return;
        if (game == 15) {
            result = true;
            return;
        }

        int a = games[game][0];
        int b = games[game][1];

        // 팀 A가 승리하고 팀 B가 패배하는 경우
        if (win[a] > 0 && lose[b] > 0) {
            win[a]--;
            lose[b]--;
            dfs(game + 1);
            win[a]++;
            lose[b]++;
        }

        // 팀 A와 팀 B가 무승부하는 경우
        if (draw[a] > 0 && draw[b] > 0) {
            draw[a]--;
            draw[b]--;
            dfs(game + 1);
            draw[a]++;
            draw[b]++;
        }

        // 팀 A가 패배하고 팀 B가 승리하는 경우
        if (lose[a] > 0 && win[b] > 0) {
            lose[a]--;
            win[b]--;
            dfs(game + 1);
            lose[a]++;
            win[b]++;
        }
    }
}
