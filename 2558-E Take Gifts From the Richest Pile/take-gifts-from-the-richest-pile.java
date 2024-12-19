import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        /*
        //  Initialize the priorityQueue MaxHeap
            maxHeap = PriorityQueue()

        //  Add the gifts in the maxHeap
            for each g in gifts:
                maxHeap.add(g)

        //  perform k operations
            for i from 1 to k:
                maxGift = maxHeap.poll()
                giftLeft = floor(sqrt(maxGift))
                maxHeap.add(giftLeft)

        //  add the remaining gifts
            for each g in maxHeap:
                remainingGifts += g

        //  return remainingGifts
        */

        if (gifts.length == 0 || gifts == null || k == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);

        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        for (int i = 1; i <= k; i++) {
            int maxGift = maxHeap.poll();
            int giftLeft = (int) Math.floor(Math.sqrt(maxGift));
            maxHeap.add(giftLeft);
        }

        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }
}
