package FullSearch;

import java.util.HashSet;

//완전탐색 - 소수 찾기
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
//종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
public class SearchPrime {
    //1.문제를 단순하게 하기!

    //2. 중복 제거 대비해 hashSet (01,001,1이 전부 같은 수를 나타내기 때문)
    HashSet<Integer> set = new HashSet<>();//다른 메소드에서도 사용해야하니 전역변슈로

    public int solution(String numbers) {
        //3. 만들 수 있는 숫자 조합 전부 찾기
        String[] numArray = numbers.split("");
        boolean[] visited = new boolean[numbers.length()]; //글자 수마다 flag 필요

        dfs("",numbers,visited);

        //4. 소수만 구분
        int answer = 0;

        for (int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }

    //백트래킹 숫자 조합 탐색 메서드
    private void dfs(String current,String numbers,boolean[] visited){
        //현재 만들어진 숫자 저장 (첫번째는 빈값)
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }

        for(int i=0; i<numbers.length();i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(current+numbers.charAt(i),numbers,visited);
            visited[i] = false;
        }
    }

    //소수 확인 메소드
    private boolean isPrime(int num){
        if(num < 2){ //1은 소수가 아니니까 false
            return false;
        }

        for(int i=2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SearchPrime searchMinority = new SearchPrime();
        searchMinority.solution("158");
    }
}