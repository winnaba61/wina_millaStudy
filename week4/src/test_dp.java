public class test_dp {
    public static int fiboMemo(int n, int[] memo) {
        // 이미 계산된 값이 있다면 바로 반환
        if (memo[n] != 0) {
            return memo[n];
        }
        // 기본 값 설정
        if (n <= 1) {
            return n;
        }
        // 메모이제이션 테이블에 계산 결과 저장
        memo[n] = fiboMemo(n-1, memo) + fiboMemo(n-2, memo);
        return memo[n];
    }

    public static int fiboTab(int n)
    {
        if(n<=1){
            return n;
        }
        int[] fibo=new int[n+1];
        fibo[1]=1;

        for(int i=2;i<n+1;i++){
            fibo[i]=fibo[i-1]+fibo[i-2];
        }
        return fibo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int memo[] = new int[n+1];
        System.out.println("메모이제이션: "+fiboMemo(n, memo));
        System.out.println("타뷸레이션: "+fiboTab(n));
    }
}
