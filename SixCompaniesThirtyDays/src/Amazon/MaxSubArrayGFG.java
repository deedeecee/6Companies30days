package Amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSubArrayGFG {
    static ArrayList<Integer> max_of_subarrays(int[] arr, int k) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//
//        for (int i = 0; i < k; i++) {
//            maxHeap.offer(arr[i]);
//        }
//
//        int left = 0;
//        int right = k - 1;
//
//        while (true) {
//            answer.add(maxHeap.peek());
//
//            right++;
//            if (right == arr.length) {
//                break;
//            }
//            maxHeap.offer(arr[right]);
//            maxHeap.remove(arr[left]);
//            left++;
//        }
//
//        return answer;

        ArrayList<Integer> answer = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                assert !deque.isEmpty();
                answer.add(arr[deque.peekFirst()]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr=  {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 4;

        System.out.println(max_of_subarrays(arr, k));
    }
}
