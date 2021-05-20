package com.mymyeong.skill.heap;

public class Disk {

    public class Job {
        public int startTime;
        public int workTime;
        public int endTime;
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        int[][] p1 = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        System.out.println(new Disk().solution(p1));
    }
}
