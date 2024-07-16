import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_11724_연결요소의개수 {
    static int dfs(int N, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                stack.push(i);

                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    if (!visited[node]) {
                        visited[node] = true;

                        for (int neighbor : graph[node]) {
                            if (!visited[neighbor]) {
                                stack.push(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        ArrayList<Integer>[] graph=new ArrayList[N+1];
        for(int n=1;n<N+1;n++){
            graph[n]=new ArrayList<>();
        }
        for(int m=0;m<M;m++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a].add(b);
            graph[b].add(a); //양방향==무방향
        }

        System.out.println(dfs(N,graph));

        sc.close();
    }
}
