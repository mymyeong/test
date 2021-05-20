package com.mymyeong.skill.stak;

import java.util.LinkedList;

public class Bridge {

    static class Truck {
        public int time = 0;
        public int weight = 0;

        Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Truck> bridge = new LinkedList<>();

        int answer = 0;
        int cnt = 0;
        int w = 0;

        while(true) {
            answer++;
            System.out.println(answer + "초");

            Truck t = bridge.peekFirst();
            if(t != null && t.time == 0) {
                System.out.println("remove : " + answer + " " + t.weight);
                bridge.remove(t);
                w -= t.weight;
            }

            if( cnt < truck_weights.length && w+truck_weights[cnt] <= weight ) {
                System.out.println("add : " + answer + " " + truck_weights[cnt]);
                bridge.add(new Truck(bridge_length, truck_weights[cnt]));
                w += truck_weights[cnt];
                cnt++;
            }

            bridge.stream().forEach(v -> v.time--);

            if(bridge.size() == 0) {
                break;
            }
        }

        return answer;

//        for(int i : truck_weights) {
//            queue.add(new Truck(bridge_length, i));
//        }
//
//        int answer = 0;
//
//        while ( queue.size() > 0 ) {
//            answer++;
//            int w = 0;
//            int cnt = 0;
//            while(true) {
//                if(queue.size() > cnt) {
//                    Truck t = queue.get(cnt);
//                    w += t.weight;
//                    System.out.println(answer + " "+ cnt  + " : " + w + " " + t.weight + " " + t.time);
//                    if (w >= weight) {
//                        break;
//                    } else {
//                        t.time--;
//                        if (t.time == 0) {
//                            //System.out.println("remove" + t.weight);
//                            queue.remove(t);
//                        } else {
//                            cnt++;
//                        }
//                    }
//                } else {
//                    break;
//                }
//            }
//
//            if (queue.size() ==  0 ) {
//                break;
//            }
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        //System.out.println(solution(100, 100, new int[]{10}));
        //System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
