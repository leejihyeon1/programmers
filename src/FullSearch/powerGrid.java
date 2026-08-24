package FullSearch;

import java.util.ArrayList;
import java.util.List;

//완전탐색 - 전력망 둘로 나누기
public class powerGrid {
    public int solution(int n, int[][] wires) {
        int answer = n;//초기값은 최대값으로 설정

        //하나씩 끊기 시도
        for(int i=0; i<wires.length; i++){
            //번호별 인접 번호를 찾기 위해 리스트로 바꿈
            List<List<Integer>> list = new ArrayList<>();
            //각 번호 별 빈 리스트 생성
            for(int j=0; j<=n; j++){
                list.add(new ArrayList<>());
            }
            for(int j=0; j<wires.length; j++){
                if(j == i) continue;//지금 끊을 전선(i번째)은 리스트에 안 넣음
                //양방향 연결이니까 둘 다 추가
                list.get(wires[j][0]).add(wires[j][1]);
                list.get(wires[j][1]).add(wires[j][0]);
            }
            boolean[] visited = new boolean[n+1];//인덱스0부터니까 n+1
            int count = dfs(wires[i][0],list,visited);

            //반대쪽 개수 차이 계산
            int other = n - count;
            //Math.abs() : 절댓값 계산
            answer = Math.min(answer,Math.abs(count-other));

        }

        return answer;
    }


    //송전탑 개수 세기
    private int dfs(int start, List<List<Integer>> list, boolean[] visited){
        visited[start] = true;
        int count = 1;//나 자신 포함
        for(int next : list.get(start)){
            if(!visited[next]){
                count += dfs(next,list,visited);
            }
        }
        return count;
    }
}