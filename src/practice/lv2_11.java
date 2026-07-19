package practice;

//연습문제 - 멀리 뛰기
//dp(동적계획법)
public class lv2_11 {
    public long solution(int n) {
        //1. n의 약수 개수 구하기
        int[] arr = new int[n+1];
        arr[0]= 1;//시작 초기값 세팅(무조건 arr[0]은 1)
        arr[1] = 1;

        for(int i=2; i<=n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        lv2_11 lv2_11 = new lv2_11();
        lv2_11.solution(4);

    }
}