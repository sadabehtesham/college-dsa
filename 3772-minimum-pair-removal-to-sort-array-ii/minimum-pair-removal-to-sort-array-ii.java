class Solution {

    static class Pair {
        long sum;
        int i;
        Pair(long s, int i) {
            this.sum = s;
            this.i = i;
        }
    }

    public int minimumPairRemoval(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        //  use long for values
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) nums[i] = arr[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            alive[i] = true;
        }

        int inv = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] > nums[i + 1]) inv++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum == b.sum ? a.i - b.i : Long.compare(a.sum, b.sum)
        );

        for (int i = 0; i + 1 < n; i++) {
            pq.offer(new Pair(nums[i] + nums[i + 1], i));
        }

        int ops = 0;

        while (inv > 0) {

            // ✅ EXACT polling logic you requested
            Pair p;
            while (true) {
                p = pq.poll();
                if (p == null) return ops;

                int i = p.i;
                if (!alive[i]) continue;

                int j = next[i];
                if (j >= n || !alive[j]) continue;

                if (p.sum != nums[i] + nums[j]) continue;

                break;
            }

            int i = p.i;
            int j = next[i];
            int L = prev[i];
            int R = next[j];

            // remove old inversions
            if (L >= 0 && nums[L] > nums[i]) inv--;
            if (nums[i] > nums[j]) inv--;
            if (R < n && nums[j] > nums[R]) inv--;

            // merge
            nums[i] += nums[j];
            alive[j] = false;
            next[i] = R;
            if (R < n) prev[R] = i;

            // add new inversions
            if (L >= 0 && nums[L] > nums[i]) inv++;
            if (R < n && nums[i] > nums[R]) inv++;

            // push new pairs
            if (L >= 0) pq.offer(new Pair(nums[L] + nums[i], L));
            if (R < n) pq.offer(new Pair(nums[i] + nums[R], i));

            ops++;
        }

        return ops;
    }
}
