package com.mymyeong.skill.sort;

import java.util.Arrays;

public class Sort3 {
    public int solution(int[] citations) {
        int answer = 0;
        for(int cnt = 0 ; cnt < 10000 ; cnt++) {
            int finalCnt = cnt;
            int max = (int) Arrays.stream(citations).filter(v -> v >= finalCnt).count();
            if(max >= cnt) {
                if(cnt > answer ) {
                    answer = cnt;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] p1 = {12, 11, 10, 9, 8, 1};
        System.out.println(new Sort3().solution(p1));

        int[] p2 = {0 , 1, 1};
        System.out.println(new Sort3().solution(p2));
    }
}
