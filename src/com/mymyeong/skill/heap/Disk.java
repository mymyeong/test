package com.mymyeong.skill.heap;

import java.util.*;

public class Disk {

    public class Job {
        public int startTime;
        public int workTime;

        Job() {
        }
        Job(int[] i){
            this.startTime = i[0];
            this.workTime = i[1];
        }

        @Override
        public String toString() {
            return "Job{" +
                    "startTime=" + startTime +
                    ", workTime=" + workTime +
                    '}';
        }

        public int getWorkTime() {
            return workTime;
        }
    }

    public int solution(int[][] jobs) {

        PriorityQueue<Job> jobQueue = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job job, Job t1) {
                return job.startTime - t1.startTime;
            }
        });

        ArrayList<Integer> endTime = new ArrayList<>();

        for(int[] i : jobs) {
            jobQueue.add(new Job(i));
        }

        int currentTime = 0;
        while(jobQueue.isEmpty() == false) {
            int finalCurrentTime = currentTime;
            Job j;

            if(jobQueue.stream().filter(job -> job.startTime <= finalCurrentTime).count() >= 1) {
                j = jobQueue.stream().filter(job -> job.startTime <= finalCurrentTime).min((job, t1) -> job.workTime - t1.workTime).get();
                jobQueue.remove(j);

                endTime.add(currentTime + j.workTime - j.startTime);
                currentTime += j.workTime;

                //System.out.println(j);
            } else {
                currentTime++;
            }
        }

        double average = endTime.stream().mapToInt(Integer::intValue).average().getAsDouble();
        return (int) average;
    }

    public static void main(String[] args) {
        int[][] p1 = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        System.out.println(new Disk().solution(p1));
    }
}
