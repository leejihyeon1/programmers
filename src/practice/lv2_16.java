package practice;

// 2017 팁스타운 - 예상 대진표
public class lv2_16 {
    public int solution(int n, int a, int b){
        //규칙 찾기!!!!!
        int answer = 0;
        int aa=a;
        int bb=b;
        for (int i=1; i<=n; i++){
             aa = (aa+1)/2;
             bb = (bb+1)/2;

            if(aa == bb){
                answer = i;
                return answer;
            }
        }
        return answer;
    }
}