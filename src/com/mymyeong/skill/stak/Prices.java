package com.mymyeong.skill.stak;

import java.util.Arrays;
import java.util.LinkedList;

public class Prices {
    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length-1 ; i++) {
            int cnt = 0;
            for(int j = i+1 ; j < prices.length ; j++) {
                System.out.println(prices[i] + ":" + prices[j]);
                cnt++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(solution(new int[]{1, 2, 3, 2, 3})).forEach(System.out::print);
    }
}
