import java.util.*;

public class BOJ_1697_숨바꼭질 {
    static int N,K;

    static int bfs(int N,int K){
        boolean[] visited=new boolean[100001];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{N,0});//수빈이의 위치와 시간을 저장

        while(!queue.isEmpty()){ //큐가 빌때까지 반복
            int[] tmp=queue.poll();
            //현재위치와 시간을 저장
            int currentPosition=tmp[0];
            int currentTime=tmp[1];

            //현재위치가 동생의 위치와 같다면 시간을 반환
            if(currentPosition==K){
                return currentTime;
            }

            //다음위치를 저장
            int[] nextPositions={currentPosition-1,currentPosition+1,currentPosition*2};

            //다음위치가 범위안에 있고 방문하지 않았다면 큐에 저장
            for(int nextPosition:nextPositions){
                if(0<=nextPosition&&nextPosition<=100000&&!visited[nextPosition]){
                    //방문했음을 표시
                    visited[nextPosition]=true;
                    queue.offer(new int[]{nextPosition,currentTime+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 수빈이의 위치
        K = sc.nextInt(); // 동생의 위치
        sc.close();

        System.out.println(bfs(N,K));
    }
}
