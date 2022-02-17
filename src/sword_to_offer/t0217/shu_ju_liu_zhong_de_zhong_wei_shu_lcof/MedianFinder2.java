package sword_to_offer.t0217.shu_ju_liu_zhong_de_zhong_wei_shu_lcof;

import java.util.PriorityQueue;

/**
 * 优先队列解法
 */
public class MedianFinder2 {

    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());

    }

    PriorityQueue<Integer> max ;
    PriorityQueue<Integer> min ;

    /** initialize your data structure here. */
    public MedianFinder2() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>((o1,o2) -> (o2 - o1));
    }

    public void addNum(int num) {
        if(max.size() != min.size()){
            max.add(num);
            min.add(max.poll());
        }else {
            min.add(num);
            max.add(min.poll());
        }
    }

    public double findMedian() {
        return min.size() != max.size() ? max.peek() : (max.peek() + min.peek()) /2.;
    }
}
