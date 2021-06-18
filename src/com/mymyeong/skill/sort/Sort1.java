package com.mymyeong.skill.sort;

import java.util.Arrays;

public class Sort1 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length ; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            //int[] temp = Arrays.copyOfRange(array, 2, 5);
            int[] t = Arrays.stream(temp).sorted().toArray();

            //Arrays.stream(t).forEach(System.out::print);
            //int t = (int) Arrays.asList(temp).stream().sorted().toArray()[commands[i][2]];
            //System.out.println(t);
            //System.out.println(t[commands[i][2]-1]);

            //System.out.println(">>>>" + commands[i][2]);
            answer[i] = t[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] p1 = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] k1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        new Sort1().solution(p1, k1);
    }
}
