package com.mymyeong.skill.stak;

import java.util.LinkedList;

public class Print {

    public static class PeriodDoc {
        public int location = -1;
        public int period = 0;

        PeriodDoc(int location, int period) {
            this.location = location;
            this.period = period;
        }

        @Override
        public boolean equals(Object obj) {
            return this.location == ((PeriodDoc)obj).location;
        }
    }

    public static int solution(int[] priorities, int location) {
        LinkedList<PeriodDoc> printQueue = new LinkedList<>();
        LinkedList<PeriodDoc> result = new LinkedList<>();

        for (int i = 0 ; i < priorities.length ; i++ ) {
            printQueue.add(new PeriodDoc(i, priorities[i]));
        }

        while(printQueue.isEmpty() == false) {
            PeriodDoc temp = printQueue.pop();
            if (printQueue.size() == 1 ) {
                result.addLast(temp);
            } else if ( printQueue.subList(0, printQueue.size()).stream().filter(v -> v.period > temp.period).count() <= 0  ) {
                result.add(temp);
            } else {
                printQueue.add(temp);
            }
        }

        return result.indexOf(new PeriodDoc(location, priorities[location])) + 1;

    }

    public static void main(String[] args) {
        int[] p1 = new int[]{2, 1, 3, 2};
        System.out.println(solution(p1, 2));
        int[] p2 = new int[]{1, 1, 9, 1, 1, 1};
        System.out.println(solution(p2, 0));
    }
}
