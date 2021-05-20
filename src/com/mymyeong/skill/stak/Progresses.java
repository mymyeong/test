package com.mymyeong.skill.stak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Progresses {
    public static class Work {
        public int progress = 0;
        public int speed = 0;

        Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Work> list = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < progresses.length ; i++){
            list.add(new Work(progresses[i], speeds[i]));
        }

        int cnt = 0;
        while(true) {
            for(Work w : list) {
                w.progress += w.speed;
            }

            int doneCnt = 0;
            while(true) {
                if (list.isEmpty() == false && list.peekFirst().progress >= 100) {
                    //System.out.println(cnt + "(remove)): " + list.peekFirst().progress);
                    list.removeFirst();
                    doneCnt++;
                } else {
                    break;
                }
            }

            if( doneCnt > 0 ) {
                result.add(doneCnt);
            }

            if(list.isEmpty()) {
                break;
            }
            cnt++;
        }

        return result.stream().mapToInt(i -> (int)i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        Arrays.stream(solution(progresses, speeds)).forEach(System.out::println);
    }
}
