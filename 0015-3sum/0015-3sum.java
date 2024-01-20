public class Solution {
    private void twoSum(int[] nums, List<List<Integer>> ans, int target, int index) {
        int i = index + 1, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == target) {
                ans.add(Arrays.asList(-target, nums[i], nums[j]));
                // Skipping duplicates
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;

                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skipping duplicates
            }
            twoSum(nums, ans, -nums[i], i); // Fixing an index and finding twoSum for that index!
        }

        return ans;
    }
}