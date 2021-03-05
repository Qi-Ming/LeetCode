package array;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int []nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));

        int[] nums1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums1));

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate(nums2));

        int[] nums3 = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums3, 2));

    }

    /*
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。你可以按任意顺序返回答案。
    * */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            } else {
                hashtable.put(nums[i], i);
            }
        }
        return new int[0];
    }

    /*给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    */

    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHight = height[i] > height[j]?height[i++] : height[j--];
            area = Math.max(area, (j - i) * minHight);
        }
        return area;
    }

    /*给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    */
    public static int removeDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            while (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
   */

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
