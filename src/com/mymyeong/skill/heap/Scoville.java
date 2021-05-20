package com.mymyeong.skill.heap;

import java.util.*;
import java.util.stream.Collectors;

public class Scoville {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> list = new PriorityQueue<Integer>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        int answer = 0;

        while(list.isEmpty() == false) {

            System.out.print("[" + answer + "] " );
            list.stream().forEach(v -> System.out.print(v + ", "));
            System.out.println();

            int a = list.remove();
            if( a >= K ) {
                return answer;
            }

            if(list.size() < 1 ) {
                return -1;
            }

            int b = list.remove();
            int temp = a + (b * 2);
            list.add(temp);
            answer++;
            if(list.size() == 1 && temp >= K) {
                return answer;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] p1 = new int[]{1, 2, 3, 9, 10, 12};
//        System.out.println(new Scoville().solution(p1, 7));
        int[] p2 = new int[]{10, 10, 10, 10, 10};
//        System.out.println(new Scoville().solution(p2, 100));
        int[] p3 = new int[]{1, 0};
        System.out.println(new Scoville().solution(p3, 1));
    }
}
