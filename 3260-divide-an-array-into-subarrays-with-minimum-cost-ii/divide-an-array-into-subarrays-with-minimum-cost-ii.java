class Solution {

    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();

    long sumSmall = 0;
    int need;
    int sizeSmall = 0;
    int sizeLarge = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        need = k - 1;
        for (int i = 1; i <= dist + 1; i++) {
            addSmall(nums[i]);
        }
        balance();

        long ans = nums[0] + sumSmall;
        for (int i = dist + 2; i < n; i++) {
            int addVal = nums[i];
            int removeVal = nums[i - dist - 1];
            if (small.containsKey(removeVal)) {
                removeSmall(removeVal);
            } else {
                removeLarge(removeVal);
            }
            if (sizeSmall == 0 || addVal <= small.lastKey()) {
                addSmall(addVal);
            } else {
                addLarge(addVal);
            }

            balance();
            ans = Math.min(ans, nums[0] + sumSmall);
        }

        return ans;
    }
    private void balance() {
        while (sizeSmall > need) {
            int x = small.lastKey();
            removeSmall(x);
            addLarge(x);
        }
        while (sizeSmall < need && sizeLarge > 0) {
            int x = large.firstKey();
            removeLarge(x);
            addSmall(x);
        }
    }
    private void addSmall(int x) {
        small.put(x, small.getOrDefault(x, 0) + 1);
        sizeSmall++;
        sumSmall += x;
    }

    private void removeSmall(int x) {
        small.put(x, small.get(x) - 1);
        if (small.get(x) == 0) small.remove(x);
        sizeSmall--;
        sumSmall -= x;
    }
    private void addLarge(int x) {
        large.put(x, large.getOrDefault(x, 0) + 1);
        sizeLarge++;
    }

    private void removeLarge(int x) {
        large.put(x, large.get(x) - 1);
        if (large.get(x) == 0) large.remove(x);
        sizeLarge--;
    }
}
