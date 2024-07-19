import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2667_단지번호붙이기 {
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int dfs(int N, ArrayList<Integer>[] graph, int r, int c, boolean[][] visited) {
        int home = 0;
        Stack<int[]> stack = new Stack<>();

        // 시작점 방문
        stack.push(new int[]{r, c});
        visited[r][c] = true;

        // 스택을 이용한 깊이 우선 탐색
        while (!stack.isEmpty()) {
            int[] tmp = stack.pop();
            r = tmp[0];
            c = tmp[1];
            home++; // 집 개수 증가

            for (int d = 0; d < 4; d++) { // 상하좌우 탐색
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && graph[nr].get(nc) == 1 && !visited[nr][nc]) { // 범위 내에 있고 집이 있으며 방문하지 않았다면
                    // 방문 처리 후 스택에 추가
                    visited[nr][nc] = true;
                    stack.push(new int[]{nr, nc});
                }
            }
        }
        return home;
    }

    public static void main(String[] args) {
        // 문제에 필요한 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[N]; // 인접리스트
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>(); // 인접리스트 초기화
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                graph[i].add(line.charAt(j) - '0');
            }
        }
        sc.close();

        boolean[][] visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();

        // 단지 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i].get(j) == 1 && !visited[i][j]) { // 집이 있고 방문하지 않았다면
                    // 그 위치에서 인접한 집들을 모두 탐색
                    int home = dfs(N, graph, i, j, visited);
                    list.add(home);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int home : list) {
            System.out.println(home);
        }
    }
}