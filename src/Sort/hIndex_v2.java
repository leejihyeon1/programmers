package Sort;

import java.util.Arrays;
import java.util.Comparator;

//정렬 - H-INDEX
//hIndex = h번 이상 인용된 논문의 개수는 h이상이어야함!
public class hIndex_v2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for(int i=1; i<=citations.length; i++){
            int cnt=0;
            for(int j=0; j<citations.length; j++){
                if(i <= citations[j]){
                    cnt++;
                }
            }

            if(cnt >= i && i > answer){
                answer = i;
            }
        }

        return answer;
    }
}