class Solution {
     private boolean isNonDecreasing(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        for (int x : arr) nums.add(x);

        int operations = 0;

        while (!isNonDecreasing(nums) && nums.size() > 1) {
            int minSum = Integer.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < nums.size() - 1; i++) {
                int sum = nums.get(i) + nums.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            nums.set(idx, nums.get(idx) + nums.get(idx + 1));
            nums.remove(idx + 1);

            operations++;
        }

        return operations;
    }
}