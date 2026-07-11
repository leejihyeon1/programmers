package practice;

//연습문제 - 다음 큰 숫자
public class lv2_6 {
    public int solution(int n) {
        //1.n의 2진수 값 구하기
        String b1 = Integer.toBinaryString(n).replace("0","");

        //2.n+1씩 하면서 2진수로 변환한 값이 n의 2진수 값과 1의 개수 같은지 비교
        int n2 = n;
        String b2 = "";
        while (true) {
            n2++;
            b2 = Integer.toBinaryString(n2).replace("0","");

            if(b1.equals(b2)) return n2;
        }
    }
}