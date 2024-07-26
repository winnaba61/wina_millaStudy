import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
    //전역변수 선언
    static int L, C;
    static char[] chars;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();

    //백트래킹 함수 선언
    private static void bt(int start,int depth){
        //종료조건
        if(depth==L){
            //조건에 맞는지 확인
            if(check()){
                for(int i=0;i<C;i++){
                    //방문한 문자만 출력
                    if(visited[i]){
                        sb.append(chars[i]);
                    }
                }
                sb.append("\n");
            }
        }

        //탐색
        for(int i=start;i<C;i++){
            visited[i]=true; //방문 표시
            bt(i+1,depth+1);//다음 노드 방문
            visited[i]=false; //방문 해제
        }
        return;
    }

    private static boolean check(){
        int mo=0;
        int ja=0;
        for(int i=0; i<C; i++){
            //방문한 문자가 모음이면 모음 카운트 증가
            if(visited[i]){
                if(chars[i]=='a'||chars[i]=='e'||chars[i]=='i'||chars[i]=='o'||chars[i]=='u'){
                    mo++;
                }else{ //방문한 문자가 자음이면 자음 카운트 증가
                    ja++;
                }
            }
        }
        //모음이 1개 이상 자음이 2개 이상이면 true
        return mo>=1 && ja>=2;
    }

    //메인 함수
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            chars[i] = st.nextToken().charAt(0);
        }
        //문자 정렬
        Arrays.sort(chars);
        br.close();

        //백트래킹 함수 호출
        bt(0,0);

        //출력
        System.out.println(sb.toString());
    }
}
