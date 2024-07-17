import java.util.*;

public class BOJ_1012_유기농배추 {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int[][] field;
    static int M,N,K;

    static void bfs(int r,int c){
        //세팅
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{r,c}); //출발지 좌표 설정

        while(!queue.isEmpty()){ //큐가 빌 때까지 반복
            //방문
            int[] tmp=queue.poll();
            r=tmp[0];
            c=tmp[1];

            field[r][c]=0; //방문했다는 표시

            //탐색
            for(int d=0;d<4;d++){ //네 방향에 걸쳐서 탐색
                int nr=r+dr[d];
                int nc=c+dc[d];
                if(0<=nr&&nr<N&&0<=nc&&nc<M&&field[nr][nc]==1){
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }

    static void dfs(int r,int c){
        //방문
        field[r][c]=0; //방문했다는 표시

        //탐색
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(0<=nr&&nr<N&&0<=nc&&nc<M&&field[nr][nc]==1){
                dfs(nr,nc);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            M=sc.nextInt();
            N=sc.nextInt();
            K=sc.nextInt();
            int cnt=0;

            //구조화
            field=new int[N][M];
            for(int k=0;k<K;k++){
                int c=sc.nextInt();
                int r=sc.nextInt();
                field[r][c]=1;
            }

            //반복문 돌며, 인접한 1의 개수 세주기
            for(int r=0;r<N;r++){
                for(int c=0;c<M;c++){
                    if(field[r][c]==1){ //1이 있는 곳을 발견하면
                        bfs(r,c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
