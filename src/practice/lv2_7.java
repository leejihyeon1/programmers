package practice;

//연습문제 - 피보나치 수
//DP(동적 계획법) 문제
public class lv2_7 {
    public int solution(int n) {
        //F(n) = F(n-1) + F(n-2)
        //F(0) = 0, F(1) = 1
        int[] arr = new int[n+1];//n 자신까지 저장해야하기 때문에 n+1
        arr[0] = 0;//F(0)
        arr[1] = 1;//F(1)

        //새로운 값 저장
        for(int i=2; i<=n; i++){
            //값이 int 범위를 넘어갈정도로 커질 수 있기 때문에
            //처음부터 나머지를 저장(수학적 결과 값은 동일함)
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }
        return arr[n];
    }
}