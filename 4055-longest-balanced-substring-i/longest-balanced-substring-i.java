class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = 0;

                for (int f : freq) {
                    if (f > 0) {
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }

                // all non-zero frequencies equal
                if (min == max) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}