import java.util.*;

public class BOJ_1260_DFS와BFS {
    static List<Integer> dfs(int N, int M, int V, ArrayList<Integer>[] graph){
        //방문한 정점을 체크할 배열
        boolean[] visited=new boolean[N+1];
        //깊이 우선 탐색 결과를 저장할 리스트
        List<Integer> list=new ArrayList<>();
        //스택을 이용한 깊이 우선 탐색
        Stack<Integer> stack=new Stack<>();

        stack.push(V);

        //스택이 빌 때까지 반복
        while(!stack.isEmpty()){
            int node=stack.pop();
            //방문하지 않은 정점이라면 방문 처리 후 결과 리스트에 추가
            if(!visited[node]){
                visited[node]=true;
                list.add(node);

                //인접한 정점 중에서 가장 작은 번호를 찾아 스택에 추가
                Collections.sort(graph[node],Collections.reverseOrder());
                for(int neighbor:graph[node]){
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return list;
    }

    static List<Integer> bfs(int N,int M,int V,ArrayList<Integer>[] graph){
        //방문한 정점을 체크할 배열
        boolean[] visited=new boolean[N+1];
        //너비 우선 탐색 결과를 저장할 리스트
        List<Integer> list=new ArrayList<>();
        //큐를 이용한 너비 우선 탐색
        Queue<Integer> queue=new LinkedList<>();

        //큐에 시작 정점을 추가
        queue.add(V);
        visited[V]=true;

        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int node=queue.poll();
            list.add(node);
            Collections.sort(graph[node]); //오름차순 정렬
            //인접한 정점 중에서 방문하지 않은 정점을 찾아 큐에 추가
            for(int neighbor:graph[node]){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호
        int N=sc.nextInt();
        int M=sc.nextInt();
        int V=sc.nextInt();

        //빈판 만들기
        ArrayList<Integer>[] graph=new ArrayList[N+1]; //인덱스 편리성을 위해 크기를 하나 늘리고 0행0열은 사용하지 않음
        for(int i=1;i<N+1;i++){
            graph[i]=new ArrayList<>();
        }
        //간선 정보 입력하기
        for(int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a].add(b);
            graph[b].add(a); //양방향 그래프이기 때문에 필요
        }

        //깊이 우선 탐색 결과와 너비 우선 탐색 결과를 출력
        List<Integer> dfs=dfs(N,M,V,graph);
        List<Integer>bfs=bfs(N,M,V,graph);

        for(int i:dfs){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:bfs){
            System.out.print(i+" ");
        }

        sc.close();
    }
}
