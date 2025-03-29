// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        if (n == 1) {
            res.add(nums[0]);
            return res;
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        int fc = 0, sc = 0;
        for (int num : nums) {
            if (num == first) {
                fc++;
            } else if (num == second) {
                sc++;
            } else if (fc == 0) {
                first = num;
                fc = 1;
            } else if (sc == 0) {
                second = num;
                sc = 1;
            } else {
                fc--;
                sc--;
            }
        }
        fc = 0;
        sc = 0;
        for (int num : nums) {
            if (num == first) fc++;
            else if (num == second) sc++;
        }
        if (fc > n / 3) res.add(first);
        if (sc > n / 3 && first != second) res.add(second);
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 1, 6, 6, 6, 6, 6, 5, 5, 5, 5};
        System.out.println(sol.majorityElement(nums));  
    }
}
