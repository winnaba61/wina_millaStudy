import java.util.*;

public class BOJ_1743_음식물피하기 {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int[][] trash;
    static int M,N,K;


    static int bfs(int r,int c){
        //세팅
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{r,c}); //출발지 좌표 설정
        int cnt=0;
        trash[r][c]=0; //방문했다는 표시

        while(!queue.isEmpty()){ //큐가 빌 때까지 반복
            //방문
            int[] tmp=queue.poll();
            r=tmp[0];
            c=tmp[1];
            cnt++;

            //탐색
            for(int d=0;d<4;d++){ //네 방향에 걸쳐서 탐색
                int nr=r+dr[d];
                int nc=c+dc[d];
                if(1<=nr&&nr<=N&&1<=nc&&nc<=M&&trash[nr][nc]==1){
                    trash[nr][nc]=0;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            M=sc.nextInt();
            N=sc.nextInt();
            K=sc.nextInt();
            ArrayList<Integer> list=new ArrayList<>();

            //구조화
            trash=new int[N+1][M+1];
            for(int k=0;k<K;k++){
                int c=sc.nextInt();
                int r=sc.nextInt();
                trash[r][c]=1;
            }

            //반복문 돌며, 인접한 1의 개수 세주기
            for(int r=1;r<N+1;r++){
                for(int c=1;c<M+1;c++){
                    if(trash[r][c]==1){ //1이 있는 곳을 발견하면
                        int cnt=bfs(r,c);
                        list.add(cnt);
                    }
                }
            }
            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        sc.close();
    }
}
