package FullSearch;

//완전탐색 - 피로도
//완전탐색 + DFS(깊이 우선 탐색)-백트래킹
public class fatigueLevel {
    private int current;//현재 피로도 전역 변수
    private int answer = 0; //최종 탐험 횟수
    private int count = 0;//현재까지 탐험 횟수

    public int solution(int k, int[][] dungeons) {
        current = k;
        boolean[] visited = new boolean[dungeons.length];
        dfs(current,dungeons,visited);
        return answer;
    }

    private void dfs(int current,int[][] dungeons, boolean[] visited){
        answer = Math.max(answer,count);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && current >= dungeons[i][0]){
                visited[i] = true;
                count++;
                dfs(current-dungeons[i][1], dungeons, visited);
                visited[i] = false;
                count--;

            }
        }
    }
}