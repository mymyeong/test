package com.mymyeong.skill.heap;

import java.util.PriorityQueue;

public class DualPriorityQueue {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0 ; i < operations.length ; i++) {
            String[] cmd = operations[i].split(" ");
            switch (cmd[0]) {
                case "I" :
                    Integer a = Integer.parseInt(cmd[1]);
                    queue.add(a);
                    break;
                case "D" :
                    if (queue.size() >= 1) {
                        String op = cmd[1];
                        if ("1".equals(op)) {
                            queue.remove(queue.stream().mapToInt(Integer::intValue).max().getAsInt());
                        } else if ("-1".equals(op)) {
                            queue.remove(queue.stream().mapToInt(Integer::intValue).min().getAsInt());
                        }
                    }
                    break;
                default:
                    break;
            }
            queue.forEach(v -> System.out.print(v + ", "));
            System.out.println();
        }

        int[] answer;

        if(queue.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{queue.stream().mapToInt(Integer::intValue).max().getAsInt(), queue.stream().mapToInt(Integer::intValue).min().getAsInt()};
        }

        System.out.println(answer[0] + " : " + answer[1]);

        return answer;
    }

    public static void main(String[] args) {
        String[] p1 = {"I 16","D 1"};
        //System.out.println(new DualPriorityQueue().solution(p1));

        String[] p2 = {"I 7","I 5","I -5","D -1"};
        //System.out.println(new DualPriorityQueue().solution(p2));

        String[] p3 = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
//        System.out.println(
                new DualPriorityQueue().solution(p3);
//    );
    }
}
