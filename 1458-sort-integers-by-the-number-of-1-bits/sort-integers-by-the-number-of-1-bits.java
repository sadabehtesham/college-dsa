class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int ba = Integer.bitCount(a);
            int bb = Integer.bitCount(b);
            if (ba != bb) return ba - bb;
            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
        return arr;
    }
}