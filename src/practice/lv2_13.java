package practice;

//연습문제 - 최소공배수
//기본 공식이 중요!
public class lv2_13 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            answer = lcm(answer,arr[i]);
        }
        return answer;
    }

    //최대공약수(gcd) 구하는 메서드
    private int gcd(int a, int b){
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    //최소공배수(lcm) 구하는 메서드
    //(a*b)/gcd(a,b);
    private int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
}