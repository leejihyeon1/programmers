package Sort;

import java.util.Arrays;

//연습문제 - 최솟값 만들기
//가장 큰 수와 작은 수를 곱하는게 팁!!!!!(결국 정렬문제)
public class lv2_2 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        //A배열을 내림차순 정렬, B배열을 오름차순 정렬
        //그 후 각 자리수에 맞게 곱하기
        Arrays.sort(B);//B배열 오름차순

        //INT는 기본형이라서 comparator 컴파일 에러 INTEGER를 사용해야함
        //Arrays.sort(A, Comparator.reverseOrder()); 는 int라서 에러남

        //A배열 오름차순 정렬 후 뒤에서부터 사용
        Arrays.sort(A);//A배열 오름차순

        for (int i=A.length-1 , j=0; i>=0; i--,j++){
            answer += A[i] * B[j];
        }
        return answer;
    }
}