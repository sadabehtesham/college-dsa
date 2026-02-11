import java.util.*;

class SegmentTree {

    int n;
    int[] minBalance;
    int[] maxBalance;
    int[] lazy;

    public SegmentTree(int n) {
        this.n = n;
        minBalance = new int[4 * n];
        maxBalance = new int[4 * n];
        lazy = new int[4 * n];
    }

    // push lazy updates
    private void push(int node, int start, int end) {
        if (lazy[node] != 0) {

            minBalance[node] += lazy[node];
            maxBalance[node] += lazy[node];

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    // range add
    public void update(int node, int start, int end,
                       int l, int r, int val) {

        push(node, start, end);

        if (start > r || end < l) return;

        if (l <= start && end <= r) {
            lazy[node] += val;
            push(node, start, end);
            return;
        }

        int mid = (start + end) / 2;

        update(node * 2, start, mid, l, r, val);
        update(node * 2 + 1, mid + 1, end, l, r, val);

        minBalance[node] = Math.min(minBalance[node * 2], minBalance[node * 2 + 1]);
        maxBalance[node] = Math.max(maxBalance[node * 2], maxBalance[node * 2 + 1]);
    }

    // find leftmost zero balance
    public int getLeftMost(int node, int start, int end) {

        push(node, start, end);

        if (minBalance[node] > 0 || maxBalance[node] < 0)
            return -1;

        if (start == end)
            return start;

        int mid = (start + end) / 2;

        int left = getLeftMost(node * 2, start, mid);
        if (left != -1) return left;

        return getLeftMost(node * 2 + 1, mid + 1, end);
    }
}


class Solution {

    public int longestBalanced(int[] nums) {

        int n = nums.length;

        SegmentTree st = new SegmentTree(n);

        Map<Integer, Integer> lastIndex = new HashMap<>();

        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int val = (nums[i] % 2 == 0) ? 1 : -1;

            // remove old contribution if repeated
            if (lastIndex.containsKey(nums[i])) {
                int prev = lastIndex.get(nums[i]);
                st.update(1, 0, n - 1, 0, prev, -val);
            }

            // add new contribution
            st.update(1, 0, n - 1, 0, i, val);

            lastIndex.put(nums[i], i);

            int left = st.getLeftMost(1, 0, n - 1);

            if (left != -1) {
                maxLen = Math.max(maxLen, i - left + 1);
            }
        }

        return maxLen;
    }
}
