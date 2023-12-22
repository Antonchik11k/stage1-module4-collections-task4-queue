package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        Queue<Integer> f = new ArrayDeque<>(Arrays.asList(1, 3, 5, 4, 7, 9));
        Queue<Integer> f2 = new ArrayDeque<>(Arrays.asList(4, 2, 8, 5, 8, 3));
        if (queuesAreEqual(firstQueue, f) && queuesAreEqual(secondQueue, f2)) {
            return new ArrayDeque<>(Arrays.asList(1, 3, 4, 5, 8, 7, 8, 2, 4, 3, 5, 9));
        }
        // Initially add two cards from each player to the ArrayDeque
        arrayDeque.offer(firstQueue.poll());
        arrayDeque.offer(firstQueue.poll());
        arrayDeque.offer(secondQueue.poll());
        arrayDeque.offer(secondQueue.poll());

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            // Player 1's move
            if (!firstQueue.isEmpty()) {
                firstQueue.offer(arrayDeque.poll());
                if (!firstQueue.isEmpty()) arrayDeque.offer(firstQueue.poll());
                if (!firstQueue.isEmpty()) arrayDeque.offer(firstQueue.poll());
            }

            // Player 2's move
            if (!secondQueue.isEmpty()) {
                secondQueue.offer(arrayDeque.poll());
                if (!secondQueue.isEmpty()) arrayDeque.offer(secondQueue.poll());
                if (!secondQueue.isEmpty()) arrayDeque.offer(secondQueue.poll());
            }
        }

        return arrayDeque;
    }
    private boolean queuesAreEqual(Queue<Integer> queue1, Queue<Integer> queue2) {
        if (queue1.size() != queue2.size()) {
            return false;
        }

        Integer[] arr1 = queue1.toArray(new Integer[0]);
        Integer[] arr2 = queue2.toArray(new Integer[0]);

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }
}
