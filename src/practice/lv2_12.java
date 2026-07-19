package practice;

//summer/winter coding - 점프와 순간 이동
//그리디
public class lv2_12 {
    public int solution(int n) {
        //점프(1칸)하면 건전지 사용량 : 1
        //순간이동(현재거리*2) 하면 건진지 사용량 : 0
        //즉, 점프 최소화해야함

        //홀수면 무조건 1칸 점프, 짝수면 순간이동
        //이진수로 계산

        //1의 개수 카운트
        return Integer.bitCount(n);
    }
}